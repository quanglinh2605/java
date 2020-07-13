package demo1;

import java.util.Scanner;

public class bai32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		System.out.println("nhap vao 2 so nguyen");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		if (a == b) {
			System.out.println(a + " = " + b);
		} else
			System.out.println(a + "!=" + b);
		if (a > b) {
			System.out.println(a + ">" + b);
			System.out.println(a + ">=" + b);
		} else {
			System.out.println(a + "<" + b);
			System.out.println(a + "<=" + b);
		}
	}

}
