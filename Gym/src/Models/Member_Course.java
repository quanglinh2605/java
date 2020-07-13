package Models;

public class Member_Course {
	private int id;

	public void setid(int value) {
		this.id = value;
	}

	public int getid() {
		return id;
	}

	private Member memberid;

	public void setmemberid(Member value) {
		this.memberid = value;
	}

	public Member getmemberid() {
		return memberid;
	}

	private Course courseid;

	public void setcourseid(Course value) {
		this.courseid = value;
	}

	public Course getcourseid() {
		return courseid;
	}

	private String Startdate;

	public void setStartdate(String value) {
		this.Startdate = value;
	}

	public String getStartdate() {
		return Startdate;
	}

	private String Enddate;

	public void setEnddate(String value) {
		this.Enddate = value;
	}

	public String getEnddate() {
		return Enddate;
	}

	private Double price;

	public void setprice(Double value) {
		this.price = value;
	}

	public Double getprice() {
		return price;
	}

	private Emp empid;

	public void setempid(Emp value) {
		this.empid = value;
	}

	public Emp getempid() {
		return empid;
	}

	private Trainer trainerid;

	public void settrainerid(Trainer value) {
		this.trainerid = value;
	}

	public Trainer gettrainerid() {
		return trainerid;
	}
}
