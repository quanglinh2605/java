package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CategoryDAO;
import MyLibrary.BindingArrayList;
import MyLibrary.MyPattern;

public class NewUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JPasswordField password;
	private JComboBox comboBox;
	private int role = 0;
	private ArrayList<String> data;
	private CategoryDAO dao = new CategoryDAO();

	private boolean encrypt(String username, String password) {
		String user = Base64.getEncoder().encodeToString(username.getBytes());
		String pass = Base64.getEncoder().encodeToString(password.getBytes());
		String mypass = user + pass;
		String md5 = null;
		byte[] bytespass;
		try {
			MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
			mdEnc.update(mypass.getBytes(), 0, mypass.length());
			md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
			data = new ArrayList<String>();
			data.add(user);
			data.add(md5);
			return true;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Create the dialog.
	 */
	public NewUser() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(NewUser.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setTitle("New User");
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(43, 52, 128, 20);
		contentPanel.add(lblUsername);

		txtName = new JTextField();
		txtName.setBounds(181, 52, 201, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(43, 105, 128, 20);
		contentPanel.add(lblPassword);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRole.setBounds(43, 160, 128, 20);
		contentPanel.add(lblRole);
		String[] item = { "Admin", "Employee" };
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object select = comboBox.getSelectedItem();
				if (String.valueOf(select).equals("Employee")) {
					role = 1;
				} else {
					role = 2;
				}
			}
		});
		comboBox.setBounds(181, 160, 201, 20);
		for (int i = 0; i < item.length; i++) {
			comboBox.addItem(item[i]);
		}
		contentPanel.add(comboBox);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtName.getText();
				String pass = String.valueOf(password.getPassword());
				MyPattern pat = new MyPattern();
				if (username.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(NewUser.this, "Please fill all the form", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (pat.UsernameCheck(username)) {
						if (pat.PasswordCheck(pass)) {
							dao.LoadData("sp_GetDataUser", null);
							BindingArrayList bind = new BindingArrayList();
							Object[][] check = bind.ToNObject(dao.getdatas(), dao.getcount());
							boolean chok = true;
							for (int i = 0; i < check.length; i++) {
								for (int j = 0; j < check[i].length; j++) {
									if (username.equals(check[i][j])) {
										JOptionPane.showMessageDialog(NewUser.this, "This username has already exist",
												"ERROR", JOptionPane.ERROR_MESSAGE);
										chok = false;
									}
								}
							}

							if (chok) {
								if (encrypt(username, pass)) {
									data.add(String.valueOf(role));
									dao.Execute("sp_NewUser", data, null);
									dispose();
								} else {
									data = new ArrayList<String>();
								}
							}
						} else {
							JOptionPane.showMessageDialog(NewUser.this,
									"Please input password without special word and have length 8-20", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(NewUser.this,
								"Please input username without special word and have length 5-20", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAdd.setBounds(43, 214, 89, 23);
		contentPanel.add(btnAdd);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(293, 214, 89, 23);
		contentPanel.add(btnClose);

		JLabel lblNewLabel = new JLabel("New User");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(43, 11, 339, 20);
		contentPanel.add(lblNewLabel);

		password = new JPasswordField();
		password.setBounds(181, 105, 201, 20);
		contentPanel.add(password);
	}
}
