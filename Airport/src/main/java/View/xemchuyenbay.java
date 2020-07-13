package View;

import java.util.ArrayList;
import java.util.List;

import Models.ChitietModel;
import Models.ChuyenbayModel;
import entities.Chitietchuyenbay;
import entities.Chuyenbay;

public class xemchuyenbay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chuyenbay chuyenbay = new Chuyenbay();
		List<Chitietchuyenbay> dschitiet = new ArrayList<Chitietchuyenbay>();
		ChuyenbayModel chuyenbayModel = new ChuyenbayModel();
		ChitietModel chitietModel = new ChitietModel();
		chuyenbay = chuyenbayModel.xemchuyenbay("QH-150");
		System.out.println("Ten chuyen bay: " + chuyenbay.getTencb());
		System.out.println("San bay di:" + chuyenbay.getSanbayByMasbdi().getTensanbay());
		System.out.println("San bay den:" + chuyenbay.getSanbayByMasbden().getTensanbay());
		System.out.println("Ngay di: " + chuyenbay.getNgaydi());
		System.out.println("Gia ghe loai 1:" + chuyenbay.getGiagheloai1());
		System.out.println("Gia ghe loai 2:" + chuyenbay.getGiagheloai2());
		System.out.println("=====================");
		System.out.println("Danh sach san bay trung gian");
		dschitiet = chitietModel.danhsachdiemdung("QH-150");
		for (Chitietchuyenbay ctcb : dschitiet) {
			System.out.println("Ten san bay:" + ctcb.getSanbay().getTensanbay());
			System.out.println("Thoi gian dung:" + ctcb.getThoigiandung());
			System.out.println("Mo ta: " + ctcb.getMota());
			System.out.println("=====================");
		}
		for (Chitietchuyenbay ctcb : chuyenbay.getChitietchuyenbays()) {
			System.out.println("Ten san bay:" + ctcb.getSanbay().getTensanbay());
			System.out.println("Thoi gian dung:" + ctcb.getThoigiandung());
			System.out.println("Mo ta: " + ctcb.getMota());
			System.out.println("=====================");
		}
	}

}
