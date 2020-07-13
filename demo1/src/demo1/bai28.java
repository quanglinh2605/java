package demo1;

import java.util.Scanner;

public class bai28 {
	public static int hextodec(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			value = value * 16 + d;
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println("nhap vao so he so hex");
		Scanner sc = new Scanner(System.in);
		String hex = sc.nextLine();
		int Dec_num = hextodec(hex);
		System.out.println("so he so thap phan tuong ung la: " + Dec_num);
	}
}
