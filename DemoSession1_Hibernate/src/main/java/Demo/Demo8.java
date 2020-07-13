package Demo;

import java.text.SimpleDateFormat;

import Models.InvoiceModel;
import entities.Invoice;

public class Demo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat();
		InvoiceModel invoicemodel = new InvoiceModel();
		System.out.println("bai 1/ a)\n");
		for (Invoice item : invoicemodel.findAll()) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("bai 1 b)\n");
		for (Invoice item : invoicemodel.findByPayment("Cash")) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("bai 1 c)\n");
		for (Invoice item : invoicemodel.findByGender("Male")) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("bai 1 d)\n");
		for (Invoice item : invoicemodel.findInvoice("Nguyen Tan Dung", "Cash")) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
		System.out.println("bai 1 e)\n");
		for (Invoice item : invoicemodel.SearchInvoice("Nga")) {
			System.out.println("id: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("payment: " + item.getPayment());
			System.out.println("createDate: " + format.format(item.getCreated()));
			System.out.println("Customer: " + item.getAccount().getUsername());
			System.out.println("==================");
		}
	}
}
