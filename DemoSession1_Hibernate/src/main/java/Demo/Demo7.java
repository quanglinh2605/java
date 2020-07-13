package Demo;

import Models.AccountModel;
import entities.Account;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountModel account = new AccountModel();
		System.out.println("Bai 1");
		for (Account acc : account.findAll()) {
			System.out.println("id: " + acc.getId());
			System.out.println("name: " + acc.getFullname());
			System.out.println("username: " + acc.getUsername());
			System.out.println("gender: " + acc.getGender());
			System.out.println("BirthDay: " + acc.getBirthday());
			System.out.println("========================");
		}
		System.out.println("Bai 2");
		for (Account acc : account.find("Male")) {
			System.out.println("id: " + acc.getId());
			System.out.println("name: " + acc.getFullname());
			System.out.println("username: " + acc.getUsername());
			System.out.println("gender: " + acc.getGender());
			System.out.println("BirthDay: " + acc.getBirthday());
			System.out.println("Invoices: " + acc.getInvoices().size());
			System.out.println("========================");
		}
	}

}
