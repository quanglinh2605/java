package demo1;

import java.util.Scanner;

public class bai19 {
	public static void main(String[] args) {
		int a, i = 0;
		int[] bin_num = new int[50];
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so thap phan: ");
		a = sc.nextInt();
		while (a != 0) {
			bin_num[i++] = a % 2;
			a = a / 2;
		}
		System.out.print("binary number is: ");
		for (i = i - 1; i >= 0; i--) {
			System.out.print(bin_num[i]);
		}
	}
}
