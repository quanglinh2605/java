package models;

public class lophoc {
// khai bao thuoc tinh
	int malop;
	String tenlop;// String: kieu chuoi
	// dinh nghia constructor;
	// Constructor sinh ra(instance) 1 doi tuong(object) thuoc class
	// constructor co tham so

	/**
	 * constructor: co tham so
	 * 
	 * @param newid:ma    lop
	 * @param newName:ten lop
	 */
	public lophoc(int newid, String newName) {
		// gan gia tri cho thuoc tinh cua doi tuong duoc sinh ra tu lop
		malop = newid;
		tenlop = newName;
	}

	public lophoc(int newid) {
		malop = newid;
	}

	public lophoc(String newName) {
		tenlop = newName;
	}

	// constructor khong tham so
	public lophoc() {
		malop = 0;
		tenlop = "";
	}
	// constructor mac dinh
	// -----property

	public void setMalop(int malop) {
		this.malop = malop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public int getMalop() {
		return malop;
	}

	public String getTenlop() {
		return tenlop;
	}
}
