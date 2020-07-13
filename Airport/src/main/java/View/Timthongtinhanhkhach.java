package View;

import java.util.ArrayList;
import java.util.List;

import Models.HanhkhachModel;
import entities.Hanhkhach;

public class Timthongtinhanhkhach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Hanhkhach> dshk = new ArrayList<Hanhkhach>();
		HanhkhachModel hanhkhachModel = new HanhkhachModel();
		dshk = hanhkhachModel.timhanhkhachtheohoten("Tan");
		System.out.println("Thong tin hanh khach:");
		for (Hanhkhach hanhkhach : dshk) {
			System.out.println("Ho ten: " + hanhkhach.getHoten());
			System.out.println("chung minh nhan dan: " + hanhkhach.getCmnd());
			System.out.println("Ngay sinh :" + hanhkhach.getNgaysinh());
			System.out.println("==================");
		}
	}

}
