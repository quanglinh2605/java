package demo1;

//import: nhung thu vien
import models.lophoc;

public class program {
	public static void main(String[] args) {
		// tao doi tuong lh thuoc class lophoc
		lophoc lh = new lophoc();
		lophoc lh1 = new lophoc(1);
		lophoc lh2 = new lophoc("accp1809");
		lophoc lh3 = new lophoc(1, "accp1809");
		// doi tuong thuoc class lop hoc su dung cac phuong thuc duoc dinh nghia trong
		// lop hoc
		lh.setMalop(10);
		lh.setTenlop("accp1809");
	}
}