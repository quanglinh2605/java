package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

import models.vattu;

public class qlvt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<models.vattu> lsvt = new ArrayList<models.vattu>();
		int chucnang = 0;
		Scanner sc = new Scanner(System.in);
		while (chucnang != 6) {
			System.out.println("hay chon chuc nang(1-6)");
			System.out.println("1.nhap vat tu");
			System.out.println("2. hien thi danh sach vat tu");
			System.out.println("3.tim vat tu theo ma vat tu");
			System.out.println("4.xoa vat tu theo ma vat tu");
			System.out.println("5.sua vat tu theo ma vat tu");
			System.out.println("6.thoat chuong trinh");
			chucnang = sc.nextInt();
			switch (chucnang) {
			case 1:
				NewVT(lsvt);
				break;
			case 2:
				showDSVT(lsvt);
				break;
			case 3:
				timVT(lsvt);
				break;
			case 4:
				xoaVT(lsvt);
				break;
			case 5:
				updateVT(lsvt);
				break;
			case 6:
				break;
			}
		}
	}

	/**
	 * them moi 1 vat tu
	 * 
	 * @param ls
	 */
	public static void NewVT(ArrayList<models.vattu> ls) {
		models.vattu vt = new vattu();
		vt.setInfo();
		ls.add(vt);
	}

	public static void showDSVT(ArrayList<models.vattu> ls) {
		System.out.println("danh sach vat tu");
		for (vattu item : ls) {
			item.getInfo();
		}
	}

	public static void timVT(ArrayList<models.vattu> ls) {
		System.out.println("nhap ma vat tu can tim:");
		Scanner sc = new Scanner(System.in);
		String mavt = sc.nextLine();
		System.out.println("vat tu can tim la: ");
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getMavt().equals(mavt)) {
				ls.get(i).getInfo();
				break;
			}
		}
	}

	public static void xoaVT(ArrayList<models.vattu> ls) {
		System.out.println("nhap ma vat tu can xoa:");
		Scanner sc = new Scanner(System.in);
		String mavt = sc.nextLine();
		vattu vtCurrent = new vattu();
		for (vattu item : ls) {
			if (item.getMavt().equals(mavt)) {
				vtCurrent = item;
				break;
			}
		}
		boolean result = ls.remove(vtCurrent);
		if (result) {
			System.out.println("da xoa thanh cong");
		} else {
			System.out.println("khong co ma vat tu nay");
		}
	}

	public static void updateVT(ArrayList<models.vattu> ls) {
		System.out.println("nhap ma vat tu can sua: ");
		Scanner sc = new Scanner(System.in);
		String mavt = sc.nextLine();
		int i = 0;
		vattu vtCurrent = new vattu();
		for (vattu item : ls) {
			if (item.getMavt().equals(mavt)) {
				vtCurrent = item;
				vtCurrent.setInfo();
				break;
			}
			i++;
		}
		ls.set(i, vtCurrent);
		System.out.println("vat tu da duoc sua thanh");
		ls.get(i).getInfo();
	}
}