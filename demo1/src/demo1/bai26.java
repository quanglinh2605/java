package demo1;

import java.util.Scanner;

public class bai26 {
	public static void main(String[] args) {
		long oct, dec = 0;
		long[] bin = new long[50];
		int i = 0;
		System.out.println("nhap vao so he so octal: ");
		Scanner sc = new Scanner(System.in);
		oct = sc.nextLong();
		while (oct != 0) {
			dec = (long) (dec + (oct % 10) * Math.pow(8, i++));
			oct = oct / 10;
		}
		i = 0;
		while (dec != 0) {
			bin[i++] = dec % 2;
			dec = dec / 2;
		}
		for (i = i - 1; i >= 0; i--) {
			System.out.print(bin[i]);
		}
	}
}
