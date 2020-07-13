package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Models.ConnectionSQL;
import Models.Course;
import Models.Courses;
import Models.Emp;
import Models.Emps;
import Models.Invoice;
import Models.Invoices;
import Models.Member;
import Models.Member_Course;
import Models.Member_Course_List;
import Models.Members;
import Models.Status;
import Models.Statuses;
import Models.Trainer;
import Models.Trainers;
import Models.emptype;
import Models.emptypes;

public class CategoryDAO {
	private Statuses dsStatus;

	public void setdsStatus(Statuses value) {
		dsStatus = value;
	}

	public Statuses getdsStatus() {
		return dsStatus;
	}

	public void GetAllStatus() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from status";
		ResultSet rs = conn.Query(str);
		try {
			dsStatus = new Statuses();
			while (rs.next()) {
				Status s = new Status();
				s.setid(rs.getInt("id"));
				s.setname(rs.getString("name"));
				dsStatus.add(s);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public Status GetStatusById(int statusid) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from status where id = ?";
		String[] paras = { String.valueOf(statusid) };
		ResultSet rs = conn.Query(str, paras);
		try {
			dsStatus = new Statuses();
			Status s = new Status();
			while (rs.next()) {

				s.setid(rs.getInt("id"));
				s.setname(rs.getString("name"));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Trainers dstrainer;

	public void setdstrainer(Trainers value) {
		dstrainer = value;
	}

	public Trainers getdstrainer() {
		return dstrainer;
	}

	public void CreateTrainer(Trainer train) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "insert into trainers(name,numberphone,salary,status_id) values(?,?,?,?)";
		String[] paras = { train.getname(), train.getnumberphone(), String.valueOf(train.getsalary()),
				String.valueOf(2) };
		myconn.Create(str, paras);
	}

	private Courses dscourse;

	public void setdscourse(Courses value) {
		dscourse = value;
	}

	public Courses getdscourse() {
		return dscourse;
	}

	public void CreateCourse(Course course) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "insert into course(name,price,numdays,weekdays,status_id) values(?,?,?,?,?)";
		String[] paras = { course.getname(), String.valueOf(course.getprice()), String.valueOf(course.getnumdays()),
				String.valueOf(course.getweekdays()), String.valueOf(2) };
		myconn.Create(str, paras);
	}

	public void GetAllCourse(int statusid) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from course where status_id = ?";
		String[] para = { String.valueOf(statusid) };
		ResultSet rs = myconn.Query(str, para);
		try {
			dscourse = new Courses();
			while (rs.next()) {
				Course c = new Course();
				c.setid(rs.getInt("id"));
				c.setname(rs.getString("name"));
				c.setprice(rs.getDouble("price"));
				c.setnumdays(rs.getInt("numdays"));
				c.setweekdays(rs.getInt("weekdays"));
				c.setstatusid(GetStatusById(rs.getInt("status_id")));
				dscourse.add(c);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void GetAllTrainer(int statusid) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from trainers where status_id = ?";
		String[] para = { String.valueOf(statusid) };
		ResultSet rs = conn.Query(str, para);
		try {
			dstrainer = new Trainers();
			while (rs.next()) {
				Trainer train = new Trainer();
				train.setid(rs.getInt("id"));
				train.setname(rs.getString("name"));
				train.setnumberphone(rs.getString("numberphone"));
				train.setsalary(rs.getDouble("salary"));
				train.setstatusid(GetStatusById(rs.getInt("status_id")));
				dstrainer.add(train);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void GetTrainerByName(String name, int statusid) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from trainers where lower(name) like ? and status_id = ?";
		String[] params = { "%" + name + "%", String.valueOf(statusid) };
		ResultSet rs = myconn.Query(str, params);
		try {
			dstrainer = new Trainers();
			while (rs.next()) {
				Trainer t = new Trainer();
				t.setid(rs.getInt("id"));
				t.setname(rs.getString("name"));
				t.setnumberphone(rs.getString("numberphone"));
				t.setsalary(rs.getDouble("salary"));
				t.setstatusid(GetStatusById(rs.getInt("status_id")));
				dstrainer.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void GetCourseByName(String name, int statusid) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		name = name.toLowerCase();
		String str = "select * from course where lower(name) like ? and status_id = ?";
		String[] params = { "%" + name + "%", String.valueOf(statusid) };
		ResultSet rs = myconn.Query(str, params);
		try {
			dscourse = new Courses();
			while (rs.next()) {
				Course c = new Course();
				c.setid(rs.getInt("id"));
				c.setname(rs.getString("name"));
				c.setprice(rs.getDouble("price"));
				c.setnumdays(rs.getInt("numdays"));
				c.setweekdays(rs.getInt("weekdays"));
				c.setstatusid(GetStatusById(rs.getInt("status_id")));
				dscourse.add(c);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Trainer GetTrainerById(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from trainers where id = ?";
		String[] params = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, params);
		try {
			Trainer t = new Trainer();
			while (rs.next()) {
				t.setid(rs.getInt("id"));
				t.setname(rs.getString("name"));
				t.setnumberphone(rs.getString("numberphone"));
				t.setsalary(rs.getDouble("salary"));
				t.setstatusid(GetStatusById(rs.getInt("status_id")));
			}
			return t;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
	}

	public void DeleteTrainer(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "Update trainers set status_id = ? where id = ?";
		String[] paras = { String.valueOf(1), String.valueOf(id) };
		conn.Create(str, paras);
	}

	public void DeleteCourse(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "Update course set status_id = ? where id = ?";
		String[] paras = { String.valueOf(1), String.valueOf(id) };
		conn.Create(str, paras);
	}

	public Course GetCourseById(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from course where id = ?";
		String[] paras = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, paras);
		try {
			Course c = new Course();
			while (rs.next()) {
				c.setid(rs.getInt("id"));
				c.setname(rs.getString("name"));
				c.setprice(rs.getDouble("price"));
				c.setnumdays(rs.getInt("numdays"));
				c.setweekdays(rs.getInt("weekdays"));
				c.setstatusid(GetStatusById(rs.getInt("status_id")));
			}
			return c;
		} catch (SQLException e) {
			return null;
		}
	}

	public void UpdateTrainer(String name, String numberphone, double salary, int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update trainers set name = ?, numberphone = ?, salary = ? where id = ?";
		String[] paras = { name, numberphone, String.valueOf(salary), String.valueOf(id) };
		conn.Create(str, paras);
	}

	public void UpdateCourse(String name, double price, int numdays, int weekdays, int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update course set name = ?, price = ?, numdays = ?, weekdays = ? where id = ?";
		String[] params = { name, String.valueOf(price), String.valueOf(numdays), String.valueOf(weekdays),
				String.valueOf(id) };
		conn.Create(str, params);
	}

	public int CheckTrainer(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select count(*) as nums from members_course where trainer_id = ?";
		String[] paras = { String.valueOf(id) };
		return conn.Count(str, paras);
	}

	public int CheckCourse(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select count(*) as nums from members_course where course_id = ?";
		String[] paras = { String.valueOf(id) };
		return conn.Count(str, paras);
	}

	public void Delete(int id, String title) {
		ConnectionSQL conn;
		String str = "";
		String[] para = { String.valueOf(id) };
		switch (title) {
		case "trainer":
			conn = new ConnectionSQL();
			conn.Connect();
			str = "delete from trainers where id =?";
			conn.Create(str, para);
			break;
		case "course":
			conn = new ConnectionSQL();
			conn.Connect();
			str = "delete from course where id =?";
			conn.Create(str, para);
			break;
		default:
			break;
		}
	}

// Quang Linh: Members
	private Members dsMem;

	public void setdsMem(Members value) {
		dsMem = value;
	}

	public Members getdsMem() {
		return dsMem;
	}

	public void CreateMem(Member MemItem) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "insert into members values(?,?)";
		String[] parameters = { MemItem.getname(), MemItem.getnumPhone() };
		conn.Create(str, parameters);
	}

	public Members getAllMem() {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from members";
		ResultSet rs = myconn.Query(str);
		dsMem = new Members();
		try {
			while (rs.next()) {
				Member item = new Member();
				item.setid(rs.getInt("id"));
				item.setname(rs.getString("name"));
				item.setnumPhone(rs.getString("numberphone"));
				dsMem.add(item);
			}
			return dsMem;
		} catch (SQLException e) {
			return null;
		}
	}

	public Members getMembyName(String name) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from members where name like ?";
		String[] paramerters = { "%" + name + "%" };
		ResultSet rs = conn.Query(str, paramerters);
		dsMem = new Members();
		try {
			while (rs.next()) {
				Member item = new Member();
				item.setid(rs.getInt("id"));
				item.setname(rs.getString("name"));
				item.setnumPhone(rs.getString("numberphone"));
				dsMem.add(item);
			}
			return dsMem;
		} catch (SQLException e) {
			return null;
		}
	}

	public Member getMembyId(String idmem) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from members where id = ?";
		String[] paramerters = { idmem };
		ResultSet rs = conn.Query(str, paramerters);
		try {
			Member item = new Member();
			while (rs.next()) {
				item.setid(rs.getInt("id"));
				item.setname(rs.getString("name"));
				item.setnumPhone(rs.getString("numberphone"));
			}
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean updateMem(Member updateMem) throws SQLException {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update members set name = ?, numberPhone = ? where id = ?";
		String[] parameters = { updateMem.getname(), updateMem.getnumPhone(), String.valueOf(updateMem.getid()) };
		int kq = conn.Create(str, parameters);
		if (kq > 0) {
			return true;
		} else
			return false;
	}

//Quang Linh: EmpType
	public emptypes getEmptype() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from emptype";
		ResultSet rs = conn.Query(str);
		emptypes ds = new emptypes();
		try {
			while (rs.next()) {
				emptype item = new emptype();
				item.setid(rs.getInt("id"));
				item.setemptype(rs.getString("emp"));
				ds.add(item);
			}
			return ds;
		} catch (SQLException e) {
			return null;
		}
	}

//Quang Linh: Employee;
	private Emps dsEmp;

	public void setdsEmps(Emps value) {
		dsEmp = value;
	}

	public Emps getdsEmps() {
		return dsEmp;
	}

	public void CreateEmp(Emp itemEmp) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "insert into emp values(?,?,?,?,?)";
		String[] parameters = { itemEmp.getName(), itemEmp.getUserName(), itemEmp.getpassword(),
				String.valueOf(itemEmp.getemptype()), "2" };
		conn.Create(str, parameters);
	}

	public Emps getAllEmp() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from emp";
		ResultSet rs = conn.Query(str);
		dsEmp = new Emps();
		try {
			while (rs.next()) {
				Emp item = new Emp();
				item.setid(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setUserName(rs.getString("Username"));
				item.setpassword(rs.getString("pass"));
				item.setemptype(rs.getInt("emptype_id"));
				dsEmp.add(item);
			}
			return dsEmp;
		} catch (SQLException e) {
			return null;
		}

	}

	public Emps getEmpbyName(String name) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from emp where Name like ?";
		String[] paramerters = { "%" + name + "%" };
		ResultSet rs = conn.Query(str, paramerters);
		dsEmp = new Emps();
		try {
			while (rs.next()) {
				Emp item = new Emp();
				item.setid(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setUserName(rs.getString("UserName"));
				item.setpassword(rs.getString("pass"));
				item.setemptype(rs.getInt("emptype_id"));
				dsEmp.add(item);
			}
			return dsEmp;
		} catch (SQLException e) {
			return null;
		}
	}

	public Emp getEmpbyUsername(String name) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from emp where UserName like ?";
		String[] paramerters = { "%" + name + "%" };
		ResultSet rs = conn.Query(str, paramerters);
		try {
			Emp item = new Emp();
			while (rs.next()) {
				item.setid(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setUserName(rs.getString("UserName"));
				item.setpassword(rs.getString("pass"));
				item.setemptype(rs.getInt("emptype_id"));
				item.setstatus(rs.getInt("status_id"));
			}
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

	public Emp getEmpbyId(String idEmp) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from emp where id = ?";
		String[] paramerters = { idEmp };
		ResultSet rs = conn.Query(str, paramerters);
		try {
			Emp item = new Emp();
			while (rs.next()) {
				item.setid(rs.getInt("id"));
				item.setName(rs.getString("Name"));
				item.setUserName(rs.getString("UserName"));
				item.setpassword(rs.getString("pass"));
				item.setemptype(rs.getInt("emptype_id"));
			}
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean updateEmp(Emp updateEmp) throws SQLException {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update emp set Name = ?, Username = ?, emptype_id = ? where id = ?";
		String[] parameters = { updateEmp.getName(), updateEmp.getUserName(), String.valueOf(updateEmp.getemptype()),
				String.valueOf(updateEmp.getid()) };
		int kq = conn.Create(str, parameters);
		if (kq > 0) {
			return true;
		} else
			return false;
	}

	public boolean resetPass(Emp item) throws SQLException {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update emp set pass = ? where id = ?";
		String[] parameters = { "123456", String.valueOf(item.getid()) };
		int kq = conn.Create(str, parameters);
		if (kq > 0) {
			return true;
		} else
			return false;
	}

	// Quang Linh: Invoice
	private Invoices dsInv;

	public void setdsInv(Invoices value) {
		dsInv = value;
	}

	public Invoices getdsInv() {
		return dsInv;
	}

	public Invoices getAllInv() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from invoice";
		ResultSet rs = conn.Query(str);
		dsInv = new Invoices();
		try {
			while (rs.next()) {
				Invoice item = new Invoice();
				item.setmembercourseid(GetMemberCourseById(rs.getInt("member_course_id")));
				item.setpay(rs.getBoolean("paid"));
				item.setpaydate(rs.getString("PayDate"));
				dsInv.add(item);
			}
			return dsInv;
		} catch (SQLException e) {
			return null;
		}
	}

	public Invoices getInvoiceByName(String name) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		name = name.toLowerCase();
		String str = "select i.member_course_id as mcid,member_id,course_id,paid,PayDate " + "from invoice as i "
				+ "left join course as c on course_id = c.id " + "left join members as m on member_id = m.id "
				+ "where (lower(c.name) like ? or lower(m.name) like ?)";
		String[] paras = { "%" + name + "%", "%" + name + "%" };
		ResultSet rs = conn.Query(str, paras);
		try {
			dsInv = new Invoices();
			while (rs.next()) {
				Invoice item = new Invoice();
				item.setmembercourseid(GetMemberCourseById(rs.getInt("mcid")));
				item.setpay(rs.getBoolean("paid"));
				item.setpaydate(rs.getString("PayDate"));
				dsInv.add(item);
			}
			return dsInv;
		} catch (SQLException e) {
			return null;
		}
	}

//Giang: Membercourse
	private Member_Course_List dsmemcourse;

	public void setdsmemcourse(Member_Course_List value) {
		dsmemcourse = value;
	}

	public Member_Course_List getdsmemcourse() {
		return dsmemcourse;
	}

	public long NewMemCourse(Member_Course mc) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "insert into members_course values(?,?,?,?,?,?,?)";
		String[] paras = { String.valueOf(mc.getmemberid().getid()), String.valueOf(mc.getcourseid().getid()),
				mc.getStartdate(), mc.getEnddate(), String.valueOf(mc.getprice()),
				String.valueOf(mc.getempid().getid()), String.valueOf(mc.gettrainerid().getid()) };
		return conn.GetInsertId(str, paras);
	}

	public Member_Course GetMemberCourseById(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from members_course where id = ?";
		String[] para = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, para);
		try {
			Member_Course mc = new Member_Course();
			while (rs.next()) {
				mc.setid(rs.getInt("id"));
				mc.setmemberid(getMembyId(rs.getString("members_id")));
				mc.setcourseid(GetCourseById(rs.getInt("course_id")));
				mc.setStartdate(rs.getString("startdate"));
				mc.setEnddate(rs.getString("enddate"));
				mc.setprice(rs.getDouble("price"));
				mc.setempid(getEmpbyId(rs.getString("emp_id")));
				mc.settrainerid(GetTrainerById(rs.getInt("trainer_id")));
			}
			return mc;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void NewInvoice(Invoice i) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "insert into invoice values(?,?,?)";
		String[] params = { String.valueOf(i.getmembercourseid().getid()), String.valueOf(i.getpay()), i.getpaydate() };
		conn.Create(str, params);
	}

	public void GetMemberCourseBymemid(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from members_course where members_id = ?";
		String[] paras = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, paras);
		try {
			dsmemcourse = new Member_Course_List();
			while (rs.next()) {
				Member_Course mc = new Member_Course();
				mc.setid(rs.getInt("id"));
				mc.setmemberid(getMembyId(rs.getString("members_id")));
				mc.setcourseid(GetCourseById(rs.getInt("course_id")));
				mc.setStartdate(rs.getString("startdate"));
				mc.setEnddate(rs.getString("enddate"));
				mc.setprice(rs.getDouble("price"));
				mc.setempid(getEmpbyId(rs.getString("emp_id")));
				mc.settrainerid(GetTrainerById(rs.getInt("trainer_id")));
				dsmemcourse.add(mc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void GetMemberCourseByMemIdAndName(String name, int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		name = name.toLowerCase();
		String str = "select mc.id as mcid,members_id,course_id,startdate,enddate,mc.price as mcprice,emp_id,trainer_id "
				+ "from members_course as mc " + "left join course as c on course_id = c.id "
				+ "left join trainers as t on trainer_id = t.id "
				+ "where members_id = ? and (lower(c.name) like ? or lower(t.name) like ?) ";
		String[] paras = { String.valueOf(id), "%" + name + "%", "%" + name + "%" };
		ResultSet rs = conn.Query(str, paras);
		try {
			dsmemcourse = new Member_Course_List();
			while (rs.next()) {
				Member_Course mc = new Member_Course();
				mc.setid(rs.getInt("mcid"));
				mc.setmemberid(getMembyId(rs.getString("members_id")));
				mc.setcourseid(GetCourseById(rs.getInt("course_id")));
				mc.setStartdate(rs.getString("startdate"));
				mc.setEnddate(rs.getString("enddate"));
				mc.setprice(rs.getDouble("mcprice"));
				mc.setempid(getEmpbyId(rs.getString("emp_id")));
				mc.settrainerid(GetTrainerById(rs.getInt("trainer_id")));
				dsmemcourse.add(mc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateMemberCourse(Member_Course mc) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update members_course set course_id = ?,trainer_id = ?,emp_id = ?,startdate =?,enddate =? where id = ?";
		String[] params = { String.valueOf(mc.getcourseid().getid()), String.valueOf(mc.gettrainerid().getid()),
				String.valueOf(mc.getempid().getid()), mc.getStartdate(), mc.getEnddate(), String.valueOf(mc.getid()) };
		conn.Create(str, params);
	}

	public Invoice GetInvoiceById(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "select * from invoice where member_course_id = ?";
		String[] para = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, para);
		try {
			Invoice i = new Invoice();
			while (rs.next()) {
				i.setmembercourseid(GetMemberCourseById(rs.getInt("member_course_id")));
				i.setpay(rs.getBoolean("paid"));
				i.setpaydate(rs.getString("PayDate"));
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void UpdateInvoice(Invoice i) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "update invoice set paid = ?, PayDate = ? where member_course_id = ?";
		String[] paras = { String.valueOf(i.getpay()), i.getpaydate(), String.valueOf(i.getmembercourseid().getid()) };
		conn.Create(str, paras);
	}
}
