package View;

import java.util.ArrayList;
import java.util.List;

import Models.ChuyenbayModel;
import entities.Chuyenbay;

public class Thongtinchuyenbaytheongay {
	public static void main(String[] args) {
		List<Chuyenbay> dsitem = new ArrayList<Chuyenbay>();
		ChuyenbayModel chuyenbayModel = new ChuyenbayModel();
		dsitem = chuyenbayModel.xemchuyenbaytheongay(23, 01, 2020);
		for (Chuyenbay chuyenbay : dsitem) {
			System.out.println("Ten chuyen bay: " + chuyenbay.getTencb());
			System.out.println("San bay di:" + chuyenbay.getSanbayByMasbdi().getTensanbay());
			System.out.println("San bay den:" + chuyenbay.getSanbayByMasbden().getTensanbay());
			System.out.println("Ngay di: " + chuyenbay.getNgaydi());
			System.out.println("Gia ghe loai 1:" + chuyenbay.getGiagheloai1());
			System.out.println("Gia ghe loai 2:" + chuyenbay.getGiagheloai2());
			System.out.println("=====================");
		}
	}
}
