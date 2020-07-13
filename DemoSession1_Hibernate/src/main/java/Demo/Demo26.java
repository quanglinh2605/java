package Demo;

import org.mindrot.jbcrypt.BCrypt;

public class Demo26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hash = "$2a$10$u6q5kVshNlG7cf4Jlq379edN5oFL2I91LI.uhpKeeXhPbz83mCZSS";
		String password1 = "123456";
		String pass2 = "654321";
		if (BCrypt.checkpw(pass2, hash)) {
			System.out.println("Correct Pass");
		} else {
			System.out.println("Wrong Pass");
		}
		if (BCrypt.checkpw(password1, hash)) {
			System.out.println("Correct Pass");
		} else {
			System.out.println("Wrong Pass");
		}
	}
}
