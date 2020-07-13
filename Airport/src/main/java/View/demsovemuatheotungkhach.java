package View;

import java.util.ArrayList;
import java.util.List;

import Models.VeModel;
import entities.Thongkekhachhang;

public class demsovemuatheotungkhach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeModel veModel = new VeModel();
		List<Thongkekhachhang> lsitem = new ArrayList<Thongkekhachhang>();
		lsitem = veModel.dsthongkeve();
		for (Thongkekhachhang item : lsitem) {
			System.out.println("Ten khach: " + item.getHoten());
			System.out.println("So ve mua: " + item.getSove());
			System.out.println("============================");
		}
	}
}
