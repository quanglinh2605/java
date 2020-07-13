package models;

import java.util.ArrayList;
import java.util.Scanner;

public class khachhang1 {
	private String makh;
	private String tenkh;
	private String dt;
	private String dc;
	private ArrayList<donhang> dsdh;

	public khachhang1() {
		makh = "";
		tenkh = "";
		dt = "";
		dc = "";
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getMakh() {
		return makh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getDt() {
		return dt;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getDc() {
		return dc;
	}

	public void setInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ten khach hang: ");
		setTenkh(sc.nextLine());
		System.out.println("ma khach hang: ");
		setMakh(sc.nextLine());
		System.out.println("so dien thoai: ");
		setDt(sc.nextLine());
		System.out.println("dia chi");
		setDc(sc.nextLine());
	}

	public void getInfo() {
		System.out.println("thong tin khach hang");
		System.out.println("ten khach hang: " + getTenkh());
		System.out.println("ma khach hang: " + getMakh());
		System.out.println("so dien thoai: " + getDt());
		System.out.println("Dia chi" + getDc());
	}
}