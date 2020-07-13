package mainPackage;

public class program1 {
	private int val;

	public void set(int newval) {
		val = newval;
	}

	public int getVal() {
		return val;
	}

	public static void main(String[] args) {
		program1 x = new program1();
		x.set(7);
		System.out.println(x.getVal());
		program1 x = new program1();
		System.out.println(x);
	}
}
