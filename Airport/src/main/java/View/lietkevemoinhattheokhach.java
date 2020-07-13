package View;

import java.util.ArrayList;
import java.util.List;

import Models.VeModel;
import entities.Ve;

public class lietkevemoinhattheokhach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Ve> dsve = new ArrayList<Ve>();
		VeModel veModel = new VeModel();
		dsve = veModel.sovemoinhat("Ha Tan Tuong", 2);
		System.out.println("Ten khach: " + dsve.get(0).getHanhkhach().getHoten());
		System.out.println("Danh sach ve moi nhat da mua:\n ");
		for (Ve ve : dsve) {
			System.out.println("Ten chuyen bay: " + ve.getChuyenbay().getTencb());
			System.out.println("so ghe: " + ve.getSoghe());
			System.out.println("Loai ghe: " + ve.getLoaighe());
			System.out.println("Gia ghe: " + ve.getGiaghe());
			System.out.println("======================");
		}
	}
}
