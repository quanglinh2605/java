package View;

import java.text.SimpleDateFormat;
import java.util.Date;

import Models.HanhkhachModel;
import Models.VeModel;
import entities.Chuyenbay;
import entities.Hanhkhach;
import entities.Ve;

public class themhanhkhachvadatve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanhkhachModel hanhkhachModel = new HanhkhachModel();
		VeModel veModel = new VeModel();
		Hanhkhach item = new Hanhkhach();
		Ve ve1 = new Ve();
		Ve ve2 = new Ve();
		try {
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
			Date ngaysinh = date.parse("02/12/1994");
			item.setHoten("Ha Huy Tap");
			item.setCmnd("789456213");
			item.setNgaysinh(ngaysinh);
			item = hanhkhachModel.Create(item);
			if (item != null) {
				System.out.println("Ma hanh khach: " + item.getMahk());
			} else {
				System.out.println("Failed");
			}
			ve1.setChuyenbay(new Chuyenbay(1));
			ve1.setHanhkhach(new Hanhkhach(item.getMahk()));
			ve1.setSoghe(15032);
			ve1.setLoaighe(1);
			ve1.setGiaghe(5000);
			veModel.Create(ve1);

			ve2.setChuyenbay(new Chuyenbay(3));
			ve2.setHanhkhach(new Hanhkhach(item.getMahk()));
			ve2.setSoghe(33014);
			ve2.setLoaighe(2);
			ve2.setGiaghe(4500);
			veModel.Create(ve2);
			System.out.println("Add Success");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
