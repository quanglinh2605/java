package demo1;

import java.util.Scanner;

public class bai27 {
	public static void main(String[] args) {
		long oct, dec = 0;
		long[] hex = new long[50];
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so octal");
		oct = sc.nextLong();
		while (oct != 0) {
			dec = (long) (dec + (oct % 10) * Math.pow(8, i++));
			oct = oct / 10;
		}
		i = 0;
		while (dec != 0) {
			hex[i] = dec % 16;
			dec = dec / 16;
			i++;
		}
		for (i = i - 1; i >= 0; i--) {
			if (hex[i] > 9) {
				System.out.print((char) (hex[i] + 55));
			} else {
				System.out.print(hex[i]);
			}
		}
	}
}
