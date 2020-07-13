package models;

import java.util.Scanner;

public class donhang {
	private String madh;
	private String makh;
	private String ngay;
	private Double tongTG;

	public donhang() {
		super();
	}

	public donhang(String madh, String makh, String ngay, Double tongTG) {
		super();
		this.madh = madh;
		this.makh = makh;
		this.ngay = ngay;
		this.tongTG = tongTG;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String madh) {
		this.makh = makh;
	}

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public void nhapthongtindonhang() {
		Scanner sc = new Scanner(System.in);
		System.out.println("madh");
		madh = sc.nextLine();
		System.out.println("makh");
		makh = sc.nextLine();
		System.out.println("ngay");
		ngay = sc.nextLine();
		System.out.println("tongtg");
		tongTG = sc.nextDouble();
	}

	public void hienthithongtinhoadon() {
		System.out.println("ma don hang: " + madh);
		System.out.println("ma khach hang: " + makh);
		System.out.println("ngay: " + ngay);
		System.out.println("tongTg: " + tongTG);
	}
}
