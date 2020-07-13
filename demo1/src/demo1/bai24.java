package demo1;

import java.util.Scanner;

public class bai24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so nhi phan: ");
		int bin = sc.nextInt();
		int dec = 0, i, j = 1;
		int[] hex = new int[50];
		while (bin != 0) {
			i = bin % 10;
			dec = dec + i * j;
			j = j * 2;
			bin = bin / 10;
		}
		i = 0;
		while (dec != 0) {
			hex[i++] = dec % 8;
			dec = dec / 8;
		}
		System.out.println("so he so octal la");
		for (i = i - 1; i >= 0; i--) {
			System.out.print(hex[i]);
		}
	}
}
