package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CategoryDAO;
import Models.User;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private CategoryDAO dao = new CategoryDAO();
	public static int usertype = 0;
	private final String sp = "sp_GetLogin";
	private String[] paras = new String[2];
	public static int userid = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void run() {
		if (Log(sp, txtUsername.getText(), String.valueOf(txtPassword.getPassword()))) {
			String user = Base64.getEncoder().encodeToString(txtUsername.getText().getBytes());
			User u = dao.GetUserInform(user);
			if (u.getusertype().getid() == 1) {
				usertype = u.getusertype().getid();
				userid = u.getid();
				Manager m = new Manager(Login.this);
				m.setVisible(true);
				dispose();
			} else {
				usertype = u.getusertype().getid();
				userid = u.getid();
				Manager m = new Manager(Login.this);
				m.setVisible(true);
				dispose();
			}
		} else {
			JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean Log(String sp, String username, String password) {
		String user = Base64.getEncoder().encodeToString(username.getBytes());
		String pass = Base64.getEncoder().encodeToString(password.getBytes());
		String mypass = user + pass;
		String md5 = null;
		try {
			MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
			mdEnc.update(mypass.getBytes(), 0, mypass.length());
			md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		String[] signin = { user, md5 };
		Object[] obj = dao.CheckLogin(sp, signin, 1);
		if (Integer.valueOf(String.valueOf(obj[0])) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(49, 71, 105, 20);
		contentPanel.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					run();
				}
			}
		});
		txtUsername.setBounds(164, 71, 184, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(49, 141, 105, 20);
		contentPanel.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					run();
				}
			}
		});
		txtPassword.setBounds(164, 141, 184, 20);
		contentPanel.add(txtPassword);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 11, 193, 24);
		contentPanel.add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		btnLogin.setBounds(177, 212, 89, 23);
		contentPanel.add(btnLogin);
	}
}
