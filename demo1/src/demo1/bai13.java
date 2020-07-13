package demo1;

public class bai13 {
	public static void main(String[] args) {
		final double a = 5.6;
		final double b = 8.5;
		double perimeter = 2*(a+b);
		double area = a*b;
		System.out.printf("perimeter is 2*(%.1f + %.1f) = %.2f\n",a,b,perimeter);
		System.out.printf("area is %.1f * %.1f = %.2f",a,b,area);
	}
}
