package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.ConnectionSQL;
import models.Dept;
import models.Depts;

public class DeptBusiness {
	public static Depts LoadAll() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		ResultSet rs = conn.Query("select * from dept");
		Depts ds = new Depts();
		try {
			while (rs.next()) {
				Dept d = new Dept();
				d.setDeptNo(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setLoc(rs.getString(3));
				ds.add(d);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
