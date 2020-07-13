package Demo;

import Models.AccountModel;

public class Demo27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountModel accountModel = new AccountModel();
		if (accountModel.Login("Linh", "123456") != null) {
			System.out.println("Login Sucessful");
		} else {
			System.out.println("login Failed");
		}
	}
}
