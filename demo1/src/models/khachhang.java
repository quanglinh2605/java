package models;

import java.util.Scanner;

public class khachhang {

	private String makh;
	private String tenkh;
	private String dt;
	private String dc;

	public khachhang() {
		super();
	}

	public khachhang(String makh, String tenkh, String dt, String dc) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.dt = dt;
		this.dc = dc;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getMakh() {
		return makh;
	}

	public void Nhapthongtinkhachhang() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ma khach hang: ");
		makh = sc.nextLine();
		System.out.println("Ten khach hang: ");
		tenkh = sc.nextLine();
		System.out.println("Dien thoai: ");
		dt = sc.nextLine();
		System.out.println("Dia chi: ");
		dc = sc.nextLine();
	}

	public void hienthithongtinkhachhang() {
		System.out.println("ma khach hang" + makh);
		System.out.println("ten khach hang" + tenkh);
		System.out.println("so dien thoai" + dt);
		System.out.println("dia chi" + dc);
	}
}
