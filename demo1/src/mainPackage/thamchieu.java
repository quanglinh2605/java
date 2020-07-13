package mainPackage;

public class thamchieu {
	private int value;

	public static void main(String[] args) {
		thamchieu num1, num2;
		num1 = new thamchieu();
		num2 = new thamchieu();
		num1.setValue(5);
		num2.setValue(6);
		tong2so(num1, num2);
		num1.show();
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static void tong2so(thamchieu p1, thamchieu p2) {
		int kq = p1.getValue() + p2.getValue();
		p1.setValue(kq);
	}

	public void show() {
		System.out.println(value);
	}
}
