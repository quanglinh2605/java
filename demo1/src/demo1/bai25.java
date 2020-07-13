package demo1;

import java.util.Scanner;

public class bai25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so octal");
		int oct = sc.nextInt();
		int r = 0, dec = 0;
		while (oct != 0) {
			dec = (int) (dec + (oct % 10) * Math.pow(8, r++));
			oct = oct / 10;
		}
		System.out.println("so decimal la: " + dec);
	}

}
