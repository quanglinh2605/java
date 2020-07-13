package demo1;

import java.util.Scanner;

public class bai20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		String c = "";
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (a != 0) {
			b = a % 16;
			c = hex[b] + c;
			a = a / 16;
		}
		System.out.print(c);
	}

}
