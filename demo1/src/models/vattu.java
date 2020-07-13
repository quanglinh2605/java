package models;

import java.util.Scanner;

public class vattu {
	private String mavt;
	private String tenvt;
	private String dvt;
	private int soluong;
	private double dongia;

	public vattu() {
		// TODO Auto-generated constructor stub

	}

	public void setMavt(String mavt) {
		this.mavt = mavt;
	}

	public String getMavt() {
		return mavt;
	}

	public void setTenvt(String tenvt) {
		this.tenvt = tenvt;
	}

	public String getTenvt() {
		return tenvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public String getDvt() {
		return dvt;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public double getDongia() {
		return dongia;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.print("ma vat tu:");
		setMavt(sc.nextLine());
		System.out.print("ten vat tu:");
		setTenvt(sc.nextLine());
		System.out.print("don vi tinh");
		setDvt(sc.nextLine());
		System.out.print("don gia");
		setDongia(sc.nextDouble());
		System.out.print("so luong");
		setSoluong(sc.nextInt());
		System.out.println();

	}

	public void getInfo() {
		System.out.println("thong tin vat tu");
		System.out.println("ma vat tu: " + getMavt());
		System.out.println("ten vat tu: " + getTenvt());
		System.out.println("don vi tinh: " + getDvt());
		System.out.println("so luong: " + getSoluong());
		System.out.println("don gia: " + getDongia());
	}
}