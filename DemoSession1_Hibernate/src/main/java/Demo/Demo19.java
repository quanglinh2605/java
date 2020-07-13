package Demo;

import Models.AccountModel;
import entities.Account;

public class Demo19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountModel account = new AccountModel();
		System.out.println("Today is birthday");
		for (Account acc : account.findcusByBirth()) {
			System.out.println("id: " + acc.getId());
			System.out.println("name: " + acc.getFullname());
			System.out.println("username: " + acc.getUsername());
			System.out.println("gender: " + acc.getGender());
			System.out.println("BirthDay: " + acc.getBirthday());
			System.out.println("========================");
		}
		System.out.println("find birthday");
		for (Account acc : account.findcusBydate(8, 3)) {
			System.out.println("id: " + acc.getId());
			System.out.println("name: " + acc.getFullname());
			System.out.println("username: " + acc.getUsername());
			System.out.println("gender: " + acc.getGender());
			System.out.println("BirthDay: " + acc.getBirthday());
			System.out.println("========================");
		}
		System.out.println("find age");
		for (Account acc : account.findbyAge("Female")) {
			System.out.println("id: " + acc.getId());
			System.out.println("name: " + acc.getFullname());
			System.out.println("username: " + acc.getUsername());
			System.out.println("gender: " + acc.getGender());
			System.out.println("BirthDay: " + acc.getBirthday());
			System.out.println("========================");
		}
	}
}
