package demo1;

import java.util.Scanner;

public class bai29 {
	public static int hextobin(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = val * 16 + d;
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println("nhap vao so he so hex");
		Scanner sc = new Scanner(System.in);
		String hex;
		hex = sc.nextLine();
		int dec = hextobin(hex);
		long[] bin = new long[50];
		int i = 0;
		while (dec != 0) {
			bin[i] = dec % 2;
			dec = dec / 2;
			i++;
		}
		for (i = i - 1; i >= 0; i--) {
			System.out.print(bin[i]);
		}
	}
}
