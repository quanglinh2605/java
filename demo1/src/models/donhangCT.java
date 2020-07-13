package models;

public class donhangCT {
	private String madh;
	private String mavt;
	private int soluong;
	private double giaban;

	public donhangCT() {
		madh = "";
		mavt = "";
		soluong = 0;
		giaban = 0;
	}

	public donhangCT(String madh, String mavt, int soluong, double giaban) {
		this.madh = madh;
		this.mavt = mavt;
		this.soluong = soluong;
		this.giaban = giaban;
	}

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public String getMavt() {
		return mavt;
	}

	public void setMavt(String mavt) {
		this.mavt = mavt;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getGiaban() {
		return giaban;
	}

	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
}
