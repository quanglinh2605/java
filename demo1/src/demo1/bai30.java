package demo1;

import java.util.Scanner;

public class bai30 {
	public static int hextooct(String s) {
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
		String hex = sc.nextLine();
		int[] oct = new int[50];
		int dec = hextooct(hex);
		int i = 0;
		while (dec != 0) {
			oct[i++] = dec % 8;
			dec = dec / 8;
		}
		for (i = i - 1; i >= 0; i--) {
			System.out.print(oct[i]);
		}
		System.out.print("\n");
	}
}
