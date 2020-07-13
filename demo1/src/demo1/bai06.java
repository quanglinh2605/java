package demo1;

import java.util.Scanner;

public class bai06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("a = ");
		a = sc.nextInt();
		System.out.println("b = ");
		b=sc.nextInt();
		System.out.println(a + "+" + b + "=" +(a+b) );
		System.out.println(a + "-" + b + "=" +(a-b) );
		System.out.println(a + "*" + b + "=" +(a*b) );
		System.out.println(a + "/" + b + "=" +(a/b) );
		System.out.println(a + "mod" + b + "=" +(a%b) );
		
	}

}
