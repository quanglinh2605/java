package models;

public class demo {
	int a, b;

	public demo() {
		a = 0;
	}

	public void change(int newvalue) {
		// thuoc tinh dang private duoc truy xuat ben trong mot method class
		// this.a = new value;
		a = newvalue;
	}

	public void f1() {
		class kethua extends demo {
			public void f2() {
				b = 5;
				f1();
				change(6);
			}
		}
	}
}

class test {
	public static void main(String[] args) {
		demo d = new demo();
		// a co dạng private nen không gọi từ đối tượng thuộc class
		d.a = 10;
		// change la method co dang private khong the goi tu doi tuong thuoc lop
		d.change(5);
	}
}