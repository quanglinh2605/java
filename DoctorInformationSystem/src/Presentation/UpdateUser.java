package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CategoryDAO;
import MyLibrary.BindingArrayList;
import MyLibrary.Encrypt;
import MyLibrary.MyPattern;

public class UpdateUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private CategoryDAO dao = new CategoryDAO();
	private JComboBox<String> comboBox;
	private int role = 0;
	Encrypt en = new Encrypt();
	private ArrayList<String> data = new ArrayList<String>();

	private void LoadData(String name) {
		Object[] data = dao.GetAData("sp_GetUserByUsername", name);
		if (data[1].equals("admin")) {
			comboBox.addItem("Admin");
			comboBox.addItem("Employee");
			role = 2;
		} else {
			comboBox.addItem("Employee");
			comboBox.addItem("Admin");
			role = 1;
		}
	}

	/**
	 * Create the Update User.
	 */
	public UpdateUser(String name) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(UpdateUser.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 79, 110, 20);
		contentPanel.add(lblNewLabel);

		txtUsername = new JTextField();
		txtUsername.setBounds(165, 79, 203, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);

		comboBox = new JComboBox<String>();
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
		comboBox.setBounds(165, 156, 203, 22);
		contentPanel.add(comboBox);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				MyPattern pat = new MyPattern();
				if (username.equals("")) {
					JOptionPane.showMessageDialog(UpdateUser.this, "Please fill all the form", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (pat.UsernameCheck(username)) {
						dao.LoadData("sp_GetDataUser", null);
						BindingArrayList bind = new BindingArrayList();
						Object[][] check = bind.ToNObject(dao.getdatas(), dao.getcount());
						boolean chok = true;
						for (int j = 0; j < check[1].length; j++) {
							if (username.equals(check[1][j])) {
								JOptionPane.showMessageDialog(UpdateUser.this, "This username has already exist",
										"ERROR", JOptionPane.ERROR_MESSAGE);
								chok = false;
							}
						}
						if (username.equals(name)) {
							chok = true;
						}
						if (chok) {
							data.add(en.encode(username));
							data.add(String.valueOf(role));
							dao.Execute("sp_UpdateUser", data, name);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(UpdateUser.this,
								"Please input username without special word and have length 5-20", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnUpdate.setBounds(10, 227, 89, 23);
		contentPanel.add(btnUpdate);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPanel.add(btnClose);

		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 156, 110, 20);
		contentPanel.add(lblNewLabel_2);

		JLabel lblUpdateUser = new JLabel("Update User");
		lblUpdateUser.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblUpdateUser.setBounds(10, 11, 208, 20);
		contentPanel.add(lblUpdateUser);
		LoadData(name);
	}
}
