package View;

import java.text.SimpleDateFormat;
import java.util.Date;

import Models.HanhkhachModel;
import entities.Hanhkhach;

public class capnhatCmndvaNgaysinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanhkhachModel hanhkhachModel = new HanhkhachModel();
		Hanhkhach item = new Hanhkhach();
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse("31/5/1985");
			item = hanhkhachModel.timhanhkhachtheohoten("Tuong").get(0);
			item.setCmnd("7894655060");
			item.setNgaysinh(date);
			hanhkhachModel.Update(item);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
