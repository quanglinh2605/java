package Models;

public class Invoice {
	private Member_Course membercourseid;

	public void setmembercourseid(Member_Course value) {
		membercourseid = value;
	}

	public Member_Course getmembercourseid() {
		return membercourseid;
	}

	private Member member_id;

	private boolean pay;

	public void setpay(boolean value) {
		pay = value;
	}

	public boolean getpay() {
		return pay;
	}

	private String paydate;

	public void setpaydate(String value) {
		paydate = value;
	}

	public String getpaydate() {
		return paydate;
	}
}
