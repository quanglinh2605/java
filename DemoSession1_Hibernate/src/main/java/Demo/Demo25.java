package Demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;

import Models.AccountModel;
import entities.Account;
import entities.Role;

public class Demo25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountModel accountModel = new AccountModel();
		Account account = new Account();
		try {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date date = format.parse("08/04/1999");
			account.setUsername("Linh");
			account.setFullname("Vo Thi Ngoc Diem");
			account.setGender("Female");
			account.setPassword(BCrypt.hashpw("123456", BCrypt.gensalt()));
			account.setBirthday(date);

			// Them role vao account

			Set<Role> roles = new HashSet<Role>();
			roles.add(new Role(1));
			roles.add(new Role(2));
			roles.add(new Role(3));
			account.setRoles(roles);
			account = accountModel.create(account);
			if (account == null) {
				System.out.println("Failed");
			} else {
				System.out.println("New ID: " + account.getId());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
