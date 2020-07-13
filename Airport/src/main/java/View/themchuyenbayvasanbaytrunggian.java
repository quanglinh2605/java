package View;

import java.text.SimpleDateFormat;
import java.util.Date;

import Models.ChitietModel;
import Models.ChuyenbayModel;
import entities.Chitietchuyenbay;
import entities.Chuyenbay;
import entities.Sanbay;

public class themchuyenbayvasanbaytrunggian {
	public static void main(String[] args) {
		ChuyenbayModel chuyenbayModel = new ChuyenbayModel();
		ChitietModel chitietModel = new ChitietModel();
		Chuyenbay model = new Chuyenbay();
		Chitietchuyenbay item1 = new Chitietchuyenbay();
		Chitietchuyenbay item2 = new Chitietchuyenbay();
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse("25/12/2019");
			model.setTencb("MH-370");
			model.setSanbayByMasbdi(new Sanbay(4));
			model.setSanbayByMasbden(new Sanbay(1));
			model.setNgaydi(date);
			model.setGheloai1(1);
			model.setGheloai2(2);
			model.setGiagheloai1(3500);
			model.setGiagheloai2(3000);
			model = chuyenbayModel.Create(model);
			if (model != null) {
				System.out.println("new Id: " + model.getMacb());
			}

			item1.setChuyenbay(new Chuyenbay(model.getMacb()));
			item1.setSanbay(new Sanbay(2));
			item1.setThoigiandung(2);
			item1.setMota("good");
			chitietModel.Create(item1);

			item2.setChuyenbay(new Chuyenbay(model.getMacb()));
			item2.setSanbay(new Sanbay(5));
			item2.setThoigiandung(1);
			item2.setMota("nothing");
			chitietModel.Create(item2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
