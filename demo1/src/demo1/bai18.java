package demo1;

import java.util.Scanner;

public class bai18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a, b, e = 0;
		int q = 1;
		a = sc.nextLong();
		b = sc.nextLong();
		while (b != 0) {
			if ((int) b % 10 == 1) {
				a = a * q;
				e = multiply((int) a, (int) e);
			} else {
				a = a * q;
			}
			b = b / 10;
			q = 10;
		}
		System.out.print("ket qua: " + e + "\n");
	}

	static int multiply(int a, int b) {
		int i = 0, r = 0;
		int[] sum = new int[20];
		int c = 0;
		while (a != 0 || b != 0) {
			sum[i++] = (a % 10 + b % 10 + r) % 2;
			r = (a % 10 + b % 10 + r) / 2;
			a = a / 10;
			b = b / 10;
		}
		if (r != 0) {
			sum[i++] = r;
		}
		--i;
		while (i >= 0) {
			c = c * 10 + sum[i--];
		}
		return c;
	}
}