package Demo;

import java.text.SimpleDateFormat;

import Models.InvoiceModel;
import entities.Invoice;

public class Demo20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat();
		InvoiceModel invoicemodel = new InvoiceModel();
		System.out.println("cau 3");
		for (Invoice item : invoicemodel.findAll()) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("cau 4");
		for (Invoice item : invoicemodel.SearchInvoicebyPaymentandDate("Cash", 2013, 5)) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("cau 5");
		for (Invoice item : invoicemodel.SearchInvoiceNewinCurrentYear("Kim Ngan", 2)) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
	}
}
