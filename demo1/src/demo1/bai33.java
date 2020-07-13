package demo1;

import java.util.Scanner;

public class bai33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so nguyen");
		a = sc.nextInt();
		while (a != 0) {
			b = a % 10;
			a = a / 10;
			c = c + b;
		}
		System.out.println("tong cua cac chu so la: " + c);
	}

}
