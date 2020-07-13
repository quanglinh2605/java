package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.ConnectionSQL;
import models.dsProduct;
import models.product;

public class ProBusiness {
	public static dsProduct GetAll() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		ResultSet rs = conn.Query("select * from Product");
		dsProduct ds = new dsProduct();
		try {
			while (rs.next()) {
				product d = new product();
				d.setid(rs.getInt(1));
				d.setname(rs.getString(2));
				d.setprice(rs.getFloat(3));
				d.setquantity(rs.getInt(4));
				ds.add(d);
			}
			return ds;
		} catch (SQLException e) {
			return null;
		}
	}

	public product getProductById(int idPro) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from product where id = ?";
		String[] prameters = { String.valueOf(idPro) };
		ResultSet rs = conn.Query(str, prameters);
		try {
			product item = new product();
			while (rs.next()) {
				item.setid(rs.getInt("id"));
				item.setname(rs.getString("name"));
				item.setprice(rs.getFloat("price"));
				item.setquantity(rs.getInt("quantity"));
			}
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean deleteRow(product deleterow) throws SQLException {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "delete from product where id=?";
		String[] parameters = { String.valueOf(deleterow.getid()) };
		int kq = myconn.Create(str, parameters);
		if (kq > 0) {
			return true;
		} else
			return false;
	}
}
