package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionSQL {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName = myGym;user = sa; password = 123456";
	public Connection conn;

	public void Connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet Query(String strQuery) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(strQuery);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int Count(String query, String[] para) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			for (int i = 0; i < para.length; i++) {
				stmt.setString(i + 1, para[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return (rs.getInt("nums"));
		} catch (SQLException e) {
			// TODO: handle exception
			return 0;
		}
	}

	public ResultSet Query(String strQuery, String[] params) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(strQuery);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public long GetInsertId(String query, String[] params) {
		PreparedStatement stmt;
		try {
			long key = -1;
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				key = rs.getLong(1);
			}
			return key;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return -1;
	}

	public int Create(String strQuery, String[] parameters) {
		PreparedStatement state;
		try {
			state = conn.prepareStatement(strQuery);
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);
			}
			int rs = state.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
