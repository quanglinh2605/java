package mainPackage;

public class thamtri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5, y = 6;
		int kq = sum(x, y);
		System.out.println("value sum:" + kq);
		tong(x, y);
		System.out.println("value x:" + x);
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static void tong(int a, int b) {
		a = a + b;
	}
}
