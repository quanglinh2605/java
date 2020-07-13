package apps;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.ConnectionSQL;
import models.Dept;
import models.Depts;
import models.Emp;
import models.Emps;

public class Repositories {
	private Depts dsDept = new Depts();

	public void setdsDept(Depts value) {
		dsDept = value;
	}

	public Depts getdsDept() {
		return dsDept;
	}

	private Emps dsEmp = new Emps();

	public void setDsEmp(Emps value) {
		dsEmp = value;
	}

	public Emps getDsEmp() {
		return dsEmp;
	}

	public void CreateDept() {
		// khai bao doi tuong dept
		System.out.println("Them moi 1 phong ban");
		Dept newItem = new Dept();
		newItem.NewInfo();
		// create new item in database
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "insert into dept values(?,?)";
		String[] parameters = { newItem.getDname(), newItem.getLoc() };
		myconn.Create(str, parameters);
	}

	public void GetAllDepts() {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from dept";
		ResultSet rs = myconn.Query(str);
		// create arraylist dept return
		try {
			while (rs.next()) {
				Dept item = new Dept();
				item.setDeptNo(rs.getInt("DeptNo"));
				item.setDname(rs.getString("DName"));
				item.setLoc(rs.getString("loc"));
				dsDept.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ShowAllDepts() {
		for (Dept dept : dsDept) {
			dept.Info();
		}
	}

	public Dept GetDeptById(int deptno) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from dept where deptno=?";
		String[] parameters = { String.valueOf(deptno) };
		ResultSet rs = myconn.Query(str, parameters);
		// create arraylist dept return
		try {
			Dept item = new Dept();
			while (rs.next()) {
				item.setDeptNo(rs.getInt("DeptNo"));
				item.setDname(rs.getString("DName"));
				item.setLoc(rs.getString("loc"));
			}
			return item;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * update row from database
	 * 
	 * @param updateItem
	 * @return true: update success or false: update failed
	 * @throws SQLException
	 */
	public boolean UpdateDept(Dept updateItem) throws SQLException {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "update dept set DName=?,Loc=? where DeptNo=?";
		String[] parameters = { updateItem.getDname(), updateItem.getLoc(), String.valueOf(updateItem.getDeptNo()) };
		int resultNumber = myconn.Create(str, parameters);
		if (resultNumber > 0) {
			// da cap nhat thanh cong
			return true;
		}
		return false;
	}

	public boolean DeleteDept(Dept deleteItem) throws SQLException {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "delete from dept where DeptNo = ?";
		String[] parameters = { String.valueOf(deleteItem.getDeptNo()) };
		int kq = myconn.Create(str, parameters);
		if (kq > 0) {
			// da xoa thanh cong
			return true;
		}
		return false;
	}

	public void CreateEmp(Emp newItem) {
		System.out.println("them moi 1 nhan vien");
		Emp newEmp = new Emp();
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "insert into emp value(?,?,?,?,?,?,?)";
		String[] parameters = { newEmp.getEname(), newEmp.getJob() };
		myconn.Create(str, parameters);
	}

	public Emp GetEmpById(int id) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from emp where empNo=?";
		String[] params = { String.valueOf(id) };
		ResultSet rs = myconn.Query(str, params);
		try {
			Emp empItem = new Emp();
			while (rs.next()) {

				empItem.setempNo(rs.getInt("empNo"));
				empItem.setEname(rs.getString("Ename"));
				empItem.setJob(rs.getString("Job"));
				if (rs.getInt("Mgr") > 0) {
					empItem.setMgr(GetEmpById(rs.getInt("Mgr")));
				}
				empItem.setHireDate(rs.getDate("HireDate"));
				empItem.setSal(rs.getDouble("Sal"));
				empItem.setComm(rs.getDouble("Comm"));
				empItem.setMyDept(GetDeptById(rs.getInt("DeptNo")));
			}
			return empItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void GetAllEmp() {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select empNo from emp";
		ResultSet rs = myconn.Query(str);
		try {
			while (rs.next()) {
				dsEmp.add(GetEmpById(rs.getInt("empNo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ShowAllEmp() {
		for (Emp item : dsEmp) {
			item.Info();
		}
	}

}
