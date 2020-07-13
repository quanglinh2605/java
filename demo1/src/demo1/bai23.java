package demo1;

import java.util.Scanner;

public class bai23 {
	public static void main(String[] args) {
		int[] hex = new int[100];
		int bin, dec = 0;
		int i, j = 1;
		Scanner sc = new Scanner(System.in);
		bin = sc.nextInt();
		while (bin != 0) {
			i = bin % 10;
			dec = dec + i * j;
			j = j * 2;
			bin = bin / 10;
		}
		i = 0;
		while (dec != 0) {
			hex[i] = dec % 16;
			dec = dec / 16;
			i++;
		}
		System.out.println("so he so hex la: ");
		for (j = i - 1; j >= 0; j--) {
			if (hex[j] > 9) {
				System.out.print((char) (hex[j] + 55));
			} else {
				System.out.print(hex[j]);
			}
		}
	}
}
