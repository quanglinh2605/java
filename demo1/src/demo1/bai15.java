package demo1;

import java.util.Scanner;

public class bai15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao hai so a va b:");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("before swapping: a,b = " + a + ","+b );
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("after swapping: a,b = " + a + ","+b );
	}

}
