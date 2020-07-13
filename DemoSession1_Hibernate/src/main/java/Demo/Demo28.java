package Demo;

import java.util.Date;

import Models.InvoiceModel;
import Models.PaymentModel;
import entities.Account;
import entities.Invoice;
import entities.InvoiceDetail;
import entities.InvoiceDetailId;

public class Demo28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvoiceModel invoiceModel = new InvoiceModel();
		PaymentModel payment = new PaymentModel();

		Invoice invoice = new Invoice();
		invoice.setAccount(new Account(2));
		invoice.setCreated(new Date());
		invoice.setName("hoa don ban hang Onlie");
		invoice.setPayment("Cash");
		invoice = invoiceModel.create(invoice);
		System.out.println("Invoice Id: " + invoice.getId());

		// Tao cac chi tiet hoa don
		InvoiceDetail invoiceDetail1 = new InvoiceDetail();
		invoiceDetail1.setId(new InvoiceDetailId(invoice.getId(), 2));
		invoiceDetail1.setPrice(100);
		invoiceDetail1.setQuantity(2);
		payment.create(invoiceDetail1);

		InvoiceDetail invoiceDetail2 = new InvoiceDetail();
		invoiceDetail2.setId(new InvoiceDetailId(invoice.getId(), 3));
		invoiceDetail2.setPrice(70);
		invoiceDetail2.setQuantity(5);
		payment.create(invoiceDetail2);

		InvoiceDetail invoiceDetail3 = new InvoiceDetail();
		invoiceDetail3.setId(new InvoiceDetailId(invoice.getId(), 5));
		invoiceDetail3.setPrice(150);
		invoiceDetail3.setQuantity(2);
		payment.create(invoiceDetail3);
	}
}
