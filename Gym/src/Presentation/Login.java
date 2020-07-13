package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dao.CategoryDAO;
import Models.Emp;
import Models.Emps;

public class Login extends JDialog {
	private JTextField tfName;
	private JPasswordField pfPass;
	CategoryDAO dao = new CategoryDAO();
	Emps dsEmp = new Emps();
	public static String username = "";
	public static int emp_id;
	public static int admin_id;

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

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(500, 200, 450, 300);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(40, 11, 75, 29);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(62, 62, 87, 29);
		getContentPane().add(lblNewLabel_1);

		tfName = new JTextField();
		tfName.setBounds(172, 62, 188, 29);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(62, 122, 87, 29);
		getContentPane().add(lblPassword);

		pfPass = new JPasswordField();
		pfPass.setBounds(172, 122, 188, 29);
		getContentPane().add(pfPass);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsEmp = dao.getAllEmp();
				int k = 0;
				for (Emp item : dsEmp) {
					if (tfName.getText().equals(item.getUserName())
							&& String.valueOf(pfPass.getPassword()).equals(item.getpassword())) {
						k++;
					}
				}
				if (k == 0) {
					tfName.setText("");
					pfPass.setText("");
					JOptionPane.showMessageDialog(btnLogIn, "Username or Password is wrong");
				} else {
					username = tfName.getText();
					Emp item = new Emp();
					item = dao.getEmpbyUsername(tfName.getText());
					if (item.getstatus() == 2) {
						if (item.getemptype() == 1) {
							admin_id = item.getid();
							program pro = new program(Login.this);
							pro.setVisible(true);
							dispose();
						} else {
							emp_id = item.getid();
							main main = new main(Login.this);
							main.setVisible(true);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(btnLogIn, "You can't access");
					}
				}
			}
		});
		btnLogIn.setBounds(282, 189, 96, 29);
		getContentPane().add(btnLogIn);
	}
}
