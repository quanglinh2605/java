package demo1;

import java.util.Scanner;

public class bai17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a, b;
		int i = 0, r = 0;
		int[] kq = new int[20];
		Scanner sc = new Scanner(System.in);
		System.out.print("nhap vao so thu nhat: ");
		a = sc.nextLong();
		System.out.print("nhap vao so thu hai: ");
		b = sc.nextLong();
		while (a != 0 || b != 0) {
			kq[i++] = (int) (a % 10 + b % 10 + r) % 2;
			r = (int) (a % 10 + b % 10 + r) / 2;
			a = a / 10;
			b = b / 10;
		}
		if(r!=0) {
			kq[i++]=r;
		}
		i--;
		while(i>=0) {
			System.out.print(kq[i--]);
		}
		System.out.print("\n");
	}
}
