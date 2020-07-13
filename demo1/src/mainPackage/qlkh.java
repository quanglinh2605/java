package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

import models.khachhang1;

public class qlkh {
	public static void main(String[] args) {
		ArrayList<models.khachhang1> lskh = new ArrayList<models.khachhang1>();
		Scanner sc = new Scanner(System.in);
		int chucnang = 0;
		while (chucnang != 6) {
			System.out.println("hay chon chuc nang(1-6)");
			System.out.println("1.nhap khach hang");
			System.out.println("2. hien thi danh sach khach hang");
			System.out.println("3.tim vat tu theo ma khach hang");
			System.out.println("4.xoa vat tu theo ma khach hang");
			System.out.println("5.sua vat tu theo ma khach hang");
			System.out.println("6.thoat chuong trinh");
			chucnang = sc.nextInt();
			switch (chucnang) {
			case 1:
				newKH(lskh);
				break;
			case 2:
				showKH(lskh);
				break;
			case 3:
				findKH(lskh);
				break;
			case 4:
				deleteKH(lskh);
				break;
			case 5:
				updateKH(lskh);
				break;
			case 6:
				break;
			}
		}
	}

	public static void newKH(ArrayList<models.khachhang1> ls) {
		models.khachhang1 kh = new khachhang1();
		kh.getInfo();
		ls.add(kh);
	}

	public static void showKH(ArrayList<models.khachhang1> ls) {
		for (khachhang1 item : ls) {
			item.setInfo();
		}
	}

	public static void findKH(ArrayList<models.khachhang1> ls) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma khach hang can tim: ");
		String makh = sc.nextLine();
		for (khachhang1 item : ls) {
			if (item.getMakh().equals(makh)) {
				item.getInfo();
				break;
			}
		}
	}

	public static void deleteKH(ArrayList<models.khachhang1> ls) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma khach hang can xoa");
		String makh = sc.nextLine();
		khachhang1 khCurrent = new khachhang1();
		for (khachhang1 item : ls) {
			if (item.getMakh().equals(makh)) {
				khCurrent = item;
				break;
			}
		}
		boolean result = ls.remove(khCurrent);
		if (result) {
			System.out.println("da xoa thanh cong");
		} else {
			System.out.println("khong co ma vat tu nay");
		}
	}

	public static void updateKH(ArrayList<models.khachhang1> ls) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma khach hang can sua thong tin");
		String makh = sc.nextLine();
		int i = 0;
		khachhang1 khCurrent = new khachhang1();
		for (khachhang1 item : ls) {
			if (item.getMakh().equals(makh)) {
				khCurrent = item;
				khCurrent.setInfo();
				break;
			}
			i++;
		}
		ls.set(i, khCurrent);
	}
}
