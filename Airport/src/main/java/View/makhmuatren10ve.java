package View;

import java.util.ArrayList;
import java.util.List;

import Models.VeModel;
import entities.Ve;

public class makhmuatren10ve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeModel veModel = new VeModel();
		List<Ve> lshk = new ArrayList<Ve>();
		lshk = veModel.danhsachkhachhangmuatren10ve();
		System.out.println("danh sach khach hang mua tren 10 ve: ");
		for (Ve item : lshk) {
			System.out.println("Ma hanh khach: " + item.getHanhkhach().getMahk());
		}
	}

}
