package demo1;

import java.util.Scanner;

public class bai22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a, b = 0, i, j = 1;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		while (a != 0) {
			i = a % 10;
			b = b + i * j;
			j = j * 2;
			a = a / 10;
		}
		System.out.println(b);
	}

}
