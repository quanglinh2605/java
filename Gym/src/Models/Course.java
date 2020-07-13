package Models;

public class Course {
	private int id;

	public void setid(int value) {
		this.id = value;
	}

	public int getid() {
		return id;
	}

	private String name;

	public void setname(String value) {
		this.name = value;
	}

	public String getname() {
		return name;
	}

	private double price;

	public void setprice(double value) {
		this.price = value;
	}

	public double getprice() {
		return price;
	}

	private int numdays;

	public void setnumdays(int value) {
		this.numdays = value;
	}

	public int getnumdays() {
		return numdays;
	}

	private int weekdays;

	public void setweekdays(int value) {
		this.weekdays = value;
	}

	public int getweekdays() {
		return weekdays;
	}

	private Status statusid;

	public void setstatusid(Status value) {
		statusid = value;
	}

	public Status getstatusid() {
		return statusid;
	}
}
