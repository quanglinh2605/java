package Demo;

import Models.AccountModel;
import Models.PaymentModel;

public class Demo21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentModel paymentmodel = new PaymentModel();
		AccountModel accountmodel = new AccountModel();
		System.out.println("cau 1:");
		System.out.println("Tong tien cua hoa don la:" + paymentmodel.totalPrice(1));
		System.out.println("Tong tien cua Chi Ngan trong nam 2019 la: " + paymentmodel.totalPriceOfaCus(4, 2019));
		System.out.println("so hoa don cua thang 11 nam 2019 la: " + paymentmodel.countInvoice(11, 2019));
		System.out.println("tong hoa don lap theo hinh thuc thanh toan Cash la: " + paymentmodel.totalPrice("Cash"));
		if (accountmodel.findByUsername("Ngoc") != null) {
			System.out.println("tai khoan hong nhung co ton tai");
		} else {
			System.out.println("tai khoan hong nhung chua ton tai");
		}
	}
}
