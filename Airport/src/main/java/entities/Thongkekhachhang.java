package entities;

public class Thongkekhachhang {
	private String hoten;
	private int sove;

	public Thongkekhachhang() {
		super();
	}

	public Thongkekhachhang(String hoten, int sove) {
		super();
		this.hoten = hoten;
		this.sove = sove;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getSove() {
		return sove;
	}

	public void setSove(int sove) {
		this.sove = sove;
	}

}
