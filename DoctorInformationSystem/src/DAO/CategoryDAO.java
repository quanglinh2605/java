package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JTable;
import javax.swing.JTextField;

import Config.Config;
import Models.Doc_Pro;
import Models.Doctor;
import Models.Doctors;
import Models.Professional;
import Models.Professionals;
import Models.User;
import Models.Users;
import Models.Usertype;
import Models.Usertypes;
import Models.Work;
import Models.dsDoc_Pro;
import MyLibrary.BindingArrayList;
import MyLibrary.ButtonEditor;
import MyLibrary.ButtonRenderer;

public class CategoryDAO {
//quanglinh
	private ArrayList<Object[]> datas;

	public void setdatas(ArrayList<Object[]> value) {
		datas = value;
	}

	public ArrayList<Object[]> getdatas() {
		return datas;
	}

	private ArrayList<Object> column;

	public void setcolumn(ArrayList<Object> value) {
		column = value;
	}

	public ArrayList<Object> getcolumn() {
		return column;
	}

	private Doctors dsDoctor;

	public void setdsDoctor(Doctors value) {
		dsDoctor = value;
	}

	public Doctors getdsDoctor() {
		return dsDoctor;
	}

	private dsDoc_Pro dsdocpro;

	public void setdsdocpro(dsDoc_Pro value) {
		dsdocpro = value;
	}

	public dsDoc_Pro getdsdocpro() {
		return dsdocpro;
	}

	private Professionals dsPro;

	public void setdsPro(Professionals value) {
		dsPro = value;
	}

	public Professionals getdsPro() {
		return dsPro;
	}

	public void loadData(String sp_name, String[] button, String[] key) {
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_name, key);
		datas = new ArrayList<Object[]>();
		column = new ArrayList<Object>();
		int index = 0;
		int stt = 1;
		try {
			int length = rs.getMetaData().getColumnCount();
			if (button != null)
				index = length + button.length;
			else
				index = length;
			column.add("STT");
			for (int i = 2; i <= length; i++) {
				column.add(rs.getMetaData().getColumnLabel(i));
			}
			if (index >= length) {
				if (button != null)
					for (int i = 0; i < button.length; i++) {
						column.add(button[i]);
					}
				while (rs.next()) {
					Object[] obj = new Object[index];
					for (int i = 1; i < length; i++) {
						obj[0] = stt;
						obj[i] = rs.getString(i + 1);
					}
					if (button != null) {
						for (int i = length, j = 0; i < index; i++, j++) {
							obj[i] = button[j];
						}
					}
					stt++;
					datas.add(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addbtn(JTable table, String colname) {
		table.getColumn(colname).setCellRenderer(new ButtonRenderer());
		table.getColumn(colname).setCellEditor(new ButtonEditor(new JTextField()));
	}

	public void Action(String sp_Name, String[] para) {
		Config conn = new Config();

		conn.CallProcExec(sp_Name, para);
	}

	public Object[] returnval(String sp_name, String[] para) {
		Config conn = new Config();
		return conn.CallProcScala(sp_name, para, 1);
	}

//Doctor
	public Doctor getDoctor(String sp_name, String[] para) {
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_name, para);
		try {
			Doctor item = new Doctor();
			while (rs.next()) {
				item.setcontact(rs.getString("Contact"));
				item.setexperience(rs.getString("Experience"));
				item.setid(rs.getInt("id"));
				item.setfaculty(rs.getString("Faculty"));
				item.setgender(rs.getString("Gender"));
				item.setloc(rs.getString("Location"));
				item.setname(rs.getString("Name"));
				item.setList(getDoctor_proByid("doc_pro_showbydoc_id", rs.getInt("id")));
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void getDoctor_detail(String sp_Name, String[] id) {
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_Name, id);
		dsDoctor = new Doctors();
		try {
			while (rs.next()) {
				Doctor item = new Doctor();
				item.setqualification(rs.getString("Qualification"));
				item.setachivement(rs.getString("Achivement"));
				dsDoctor.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//Professional
	public void getAllPro(String sp_name) {
		Config conn = new Config();
		conn.Connect();
		ResultSet rs = conn.CallProc(sp_name);
		dsPro = new Professionals();
		try {
			while (rs.next()) {
				Professional item = new Professional();
				item.setname(rs.getString("name"));
				item.setid(rs.getInt("id"));
				dsPro.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Professional getPro(String sp_name, String[] para) {
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_name, para);
		try {
			Professional item = new Professional();
			while (rs.next()) {
				item.setname(rs.getString("name"));
				item.setid(rs.getInt("id"));
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//Doctor_pro
	public dsDoc_Pro getDoctor_proByid(String sp_name, int id) {
		String[] para = { String.valueOf(id) };
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_name, para);
		dsdocpro = new dsDoc_Pro();
		try {
			while (rs.next()) {
				Doc_Pro item = new Doc_Pro();
				item.setDoc_id(rs.getInt("doctor_id"));
				item.setPro_id(rs.getInt("pro_id"));
				dsdocpro.add(item);
			}
			return dsdocpro;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//List_work
	public Work GetWork(String sp_name, String[] para) {
		Config conn = new Config();
		ResultSet rs = conn.CallProc(sp_name, para);
		try {
			Work item = new Work();
			while (rs.next()) {
				item.setdate(rs.getString("Date"));
				item.setevent(rs.getString("Event"));
				item.setStartTime(rs.getString("Start"));
				item.setEndTime(rs.getString("Finish"));
			}
			return item;
		} catch (SQLException e) {
			return null;
		}
	}

// Giang
	private Users dsuser;

	public void setdsuser(Users value) {
		this.dsuser = value;
	}

	public Users getdsuser() {
		return dsuser;
	}

	private Usertype role;

	public void setrole(Usertype value) {
		this.role = value;
	}

	public Usertype getrole() {
		return role;
	}

	private Usertypes dsusertype;

	public void setdsusertype(Usertypes value) {
		this.dsusertype = value;
	}

	public Usertypes getdsusertype() {
		return dsusertype;
	}

	private int count;

	public void setcount(int value) {
		this.count = value;
	}

	public int getcount() {
		return count;
	}

	/**
	 * Load datas and column for table and insert this 2 attribute into Datasource
	 * Use LoadTable method load(table,model,Datasource) to load this data in table
	 * 
	 * @param sp_name Procedure name
	 * @param add     Array additional column
	 * @author Giang
	 */
	public void LoadData(String sp_name, String[] add) {
		Config conf = new Config();

		ResultSet rs = conf.CallProc(sp_name);
		try {
			datas = new ArrayList<Object[]>();
			column = new ArrayList<Object>();
			int stt = 1;
			int length = rs.getMetaData().getColumnCount();
			int index = length + 1;
			int a = 0;
			if (add != null) {
				a = add.length;
				index = length + a + 1;
			}
			count = index;
			while (rs.next()) {
				Object[] row = new Object[index];
				row[0] = stt;
				stt++;
				for (int i = 0; i < length; i++) {
					if (i + 1 == 1) {
						byte[] decode = Base64.getDecoder().decode(rs.getString(i + 1));
						String s1 = new String(decode);
						row[i + 1] = s1;
					} else {
						row[i + 1] = rs.getString(i + 1);
					}
				}
				if (index > length + 1) {
					for (int i = 0; i < a; i++) {
						row[length + i + 1] = add[i];
					}
				}
				datas.add(row);
			}
			column.add("STT");
			for (int i = 0; i < length; i++) {
				String col = rs.getMetaData().getColumnLabel(i + 1);
				column.add(col);
			}
			if (index > length + 1) {
				for (int i = 0; i < a; i++) {
					column.add(add[i]);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Search data by keyword
	 * 
	 * @param sp_name Procedure name
	 * @param add     Array additional column
	 * @param obj     keyword need to search
	 * @author Giang
	 * 
	 */
	public void LoadData(String sp_name, String[] add, String obj) {
		Config conf = new Config();
		String[] paras = { "%" + String.valueOf(obj) + "%" };
		ResultSet rs = conf.CallProc(sp_name, paras);
		try {
			datas = new ArrayList<Object[]>();
			column = new ArrayList<Object>();
			int a = add.length;
			int stt = 1;
			int length = rs.getMetaData().getColumnCount();
			int index = length + 1;
			if (add != null && a > 0) {
				index = length + a + 1;
			}
			count = index;
			while (rs.next()) {
				Object[] row = new Object[index];
				row[0] = stt;
				stt++;
				for (int i = 0; i < length; i++) {
					if (i + 1 == 1) {
						byte[] decode = Base64.getDecoder().decode(rs.getString(i + 1));
						String s1 = new String(decode);
						row[i + 1] = s1;
					} else {
						row[i + 1] = rs.getString(i + 1);
					}
				}
				if (index > length) {
					for (int i = 0; i < a; i++) {
						row[length + i + 1] = add[i];
					}
				}
				datas.add(row);
			}
			column.add("STT");
			for (int i = 0; i < length; i++) {
				String col = rs.getMetaData().getColumnLabel(i + 1);
				column.add(col);
			}
			if (index > length) {
				for (int i = 0; i < a; i++) {
					column.add(add[i]);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private ArrayList<Object> object;

	public void setobj(ArrayList<Object> value) {
		this.object = value;
	}

	public ArrayList<Object> getobj() {
		return object;
	}

	/**
	 * Search data by keyword
	 * 
	 * @param sp_name Procedure name
	 * @param add     Array additional column
	 * @param obj     keyword need to search
	 * @author Giang
	 * 
	 */
	public void SearchData(String sp_name, String[] add, String obj) {
		Config conf = new Config();
		ResultSet rs = conf.CallProc(sp_name);
		try {
			datas = new ArrayList<Object[]>();
			column = new ArrayList<Object>();

			int a = add.length;
			int stt = 1;
			int length = rs.getMetaData().getColumnCount();
			int index = length + 1;
			if (add != null && a > 0) {
				index = length + a + 1;
			}
			count = index;
			while (rs.next()) {

				byte[] decode = Base64.getDecoder().decode(rs.getString(1));
				String check = new String(decode);
				if (check.toLowerCase().contains(obj.toLowerCase())) {
					object = new ArrayList<Object>();
					object.add(stt);
					for (int i = 0; i < length; i++) {
						if (i + 1 == 1) {
							object.add(check);
						} else {
							object.add(rs.getString(i + 1));
						}
					}
					if (index > length) {
						for (int i = 0; i < a; i++) {
							object.add(add[i]);
						}
					}
					BindingArrayList bind = new BindingArrayList();
					datas.add(bind.ToObject(object));
					stt++;
				}
			}
			column.add("STT");
			for (int i = 0; i < length; i++) {
				String col = rs.getMetaData().getColumnLabel(i + 1);
				column.add(col);
			}
			if (index > length) {
				for (int i = 0; i < a; i++) {
					column.add(add[i]);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Insert,Delete Information
	 * 
	 * @param sp_name storage name
	 * @param paras   List of parameters you want to insert/delete
	 * @param para    condition parameter
	 * @return boolean
	 * @author Giang
	 */
	public boolean Execute(String sp_name, ArrayList<String> paras, String para) {
		Config conn = new Config();
		if (paras == null) {
			String[] params = { para };
			return conn.CallProcExec(sp_name, params);
		} else {
			if (para == null) {
				BindingArrayList bind = new BindingArrayList();
				String[] params = bind.ToString(paras);
				return conn.CallProcExec(sp_name, params);
			} else {
				paras.add(para);
				BindingArrayList bind = new BindingArrayList();
				String[] params = bind.ToString(paras);
				return conn.CallProcExec(sp_name, params);
			}
		}
	}

	/**
	 * Get an Object information
	 * 
	 * @param sp_name storage name
	 * @param obj     condition parameters
	 * @return Object[]
	 * @author Giang
	 */
	public Object[] GetAData(String sp_name, Object obj) {
		Config conn = new Config();
		String[] para = { String.valueOf(obj) };
		ResultSet rs = conn.CallProc(sp_name, para);
		try {
			Object[] item = new Object[rs.getMetaData().getColumnCount()];
			while (rs.next()) {
				for (int i = 0; i < item.length; i++) {
					item[i] = rs.getString(i + 1);
				}
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Check login
	 * 
	 * @param sp_name storage name
	 * @param login   parameter for query
	 * @return int
	 * @author Giang
	 */
	public Object[] CheckLogin(String sp_name, String[] login, int paraout) {
		Config conn = new Config();
		return conn.CallProcScala(sp_name, login, paraout);
	}

	public User GetUserInform(String username) {
		Config conn = new Config();
		String str = "select * from users where username = ?";
		String[] params = { username };
		ResultSet rs = conn.Query(str, params);
		try {
			User u = new User();
			while (rs.next()) {

				u.setid(rs.getInt("id"));
				u.setpassword(rs.getString("password"));
				u.setusername(username);
				u.setusertype(GetUsertypeById(rs.getInt("usertype_id")));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usertype GetUsertypeById(int id) {
		Config conn = new Config();
		String str = "select * from usertype where id = ?";
		String[] paras = { String.valueOf(id) };
		ResultSet rs = conn.Query(str, paras);
		try {
			Usertype ut = new Usertype();
			while (rs.next()) {
				ut.setid(rs.getInt("id"));
				ut.setname(rs.getString("name"));
			}
			return ut;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
