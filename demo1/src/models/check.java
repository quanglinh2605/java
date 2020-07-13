package models;

import java.util.ArrayList;
import java.util.Scanner;

public class check {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		khachhang khachHang;
		donhang donHang;
		ArrayList<khachhang> listKH = new ArrayList();
		System.out.println("nhap so luong khach hang: ");
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			khachHang = new khachhang();
			System.out.println("khach hang thu " + (i + 1) + ":");
			khachHang.Nhapthongtinkhachhang();
			listKH.add(khachHang);
		}
		ArrayList<donhang> listDH = new ArrayList();
		System.out.println("nhap so luong don hang");
		n = sc.nextInt();
		for (int j = 0; j < n; j++) {
			donHang = new donhang();
			donHang.nhapthongtindonhang();
			listDH.add(donHang);
		}
		System.out.println("nhap ma khach hang: ");
		String timmakh = sc.next();
		for (int i = 0; i < listDH.size(); i++) {
			if (listDH.get(i).getMakh().equalsIgnoreCase(timmakh)) {
				listDH.get(i).hienthithongtinhoadon();
			}
		}
		System.out.println("nhap ma don hang: ");
		String timmadh = sc.next();
		for (int i = 0; i < listDH.size(); i++) {
			if (listDH.get(i).getMadh().equalsIgnoreCase(timmadh)) {
				System.out.println(listDH.get(i).getMakh());
			}
		}
	}
}
