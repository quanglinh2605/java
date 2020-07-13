package Config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Config {
	private static String url = Helper.FileHelper.getConnectionString("bin//App.xml");
	private static Parameters pars;

	public static Connection Connect() {
		try {
			Connection conn;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get data
	 * 
	 * @param storeName
	 * @return ResultSet
	 */
	public static ResultSet CallProc(String storeName) {
		try {
			// khong truyen tham so
			CallableStatement state = Connect().prepareCall("{ call " + storeName + "}");
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get data by a parameters
	 * 
	 * @param storeName
	 * @param parameters
	 * @return ResultSet
	 */
	public static ResultSet CallProc(String storeName, String[] parameters) {
		try {
			pars = new Parameters();
			String str = "{ call " + storeName + "(" + pars.getpara(parameters) + ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * goi thu tuc de thuc thi truyen tham so de delete
	 * 
	 * @param storeName
	 * @param parameters
	 * @return boolean
	 */
	public static boolean CallProcExec(String storeName, String[] parameters) {
		try {
			pars = new Parameters();
			String str = "{ call " + storeName + "(" + pars.getpara(parameters) + ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);
			}
			return state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * tra ve n gia tri
	 * 
	 * @param storeName
	 * @param parameters
	 * @param paraout    number of object you want to get
	 * @return Object
	 */
	public static Object[] CallProcScala(String storeName, String[] parameters, int paraout) {
		String[] obj = new String[paraout];

		int len = parameters.length + paraout;
		pars = new Parameters();
		try {
			String str = "{ call " + storeName + "(" + pars.getpara(parameters, paraout) + ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);
			}
			for (int i = parameters.length; i < len; i++) {
				state.registerOutParameter(i + 1, java.sql.Types.JAVA_OBJECT);
			}

			state.execute();
			int j = 0;
			for (int i = parameters.length; i < len; i++) {
				obj[j] = state.getString(i + 1);
				j++;
			}

			return obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch blok
			e.printStackTrace();
		}

		return null;

	}

	public static ResultSet Query(String str, String[] params) {
		try {
			PreparedStatement stmt = Connect().prepareStatement(str);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
