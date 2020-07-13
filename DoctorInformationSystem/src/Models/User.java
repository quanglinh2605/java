package Models;

public class User {
	private int id;

	public void setid(int value) {
		this.id = value;
	}

	public int getid() {
		return id;
	}

	private String username;

	public void setusername(String value) {
		this.username = value;
	}

	public String getusername() {
		return username;
	}

	private String password;

	public void setpassword(String value) {
		this.password = value;
	}

	public String getpassword() {
		return password;
	}

	private Usertype usertype;

	public void setusertype(Usertype value) {
		this.usertype = value;
	}

	public Usertype getusertype() {
		return usertype;
	}
}
