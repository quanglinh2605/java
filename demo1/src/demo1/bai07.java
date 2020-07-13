package demo1;

import java.util.Scanner;

public class bai07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,i;
		System.out.println("a = ");
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		for(i=1;i<11;i++) {
			System.out.println(a + " * " + i + " = " +(a*i));
		}

	}

}
