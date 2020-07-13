package View;

import Models.VeModel;
import entities.Chuyenbay;
import entities.Hanhkhach;
import entities.Ve;

public class Datve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ve item = new Ve();
		VeModel veModel = new VeModel();
		item.setChuyenbay(new Chuyenbay(1));
		item.setHanhkhach(new Hanhkhach(1));
		item.setLoaighe(1);
		item.setSoghe(15040);
		item.setGiaghe(5500);
		item = veModel.Create(item);
		System.out.println("Ve id: " + item.getMave());
	}

}
