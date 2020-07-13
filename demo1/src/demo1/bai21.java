package demo1;

import java.util.Scanner;

public class bai21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nhap vao so thap phan: ");
		int a, i = 0, j;
		int[] oct_num = new int[50];
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		while (a != 0) {
			oct_num[i++] = a % 8;
			a = a / 8;
		}
		for (j = i - 1; j >= 0; j--) {
			System.out.print(oct_num[j]);
		}
	}

}
