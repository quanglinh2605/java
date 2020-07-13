package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionSQL {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=baitap2;user=sa;password=123456";;
	public Connection conn;

	public void Connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int Create(String query, String[] arrParameter) {

		// thuc hien cau truy van
		PreparedStatement state;
		try {
			state = conn.prepareStatement(query);
			for (int i = 0; i < arrParameter.length; i++) {
				state.setString(i + 1, arrParameter[i]);
			}
			int rs = state.executeUpdate();
			return rs;// result execute line
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}
}
