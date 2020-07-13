package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.CategoryDAO;
import MyLibrary.Encrypt;
import MyLibrary.MyPattern;

public class ChangePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField currentpsw;
	private JPasswordField newpsw;
	private JPasswordField confirmpsw;
	private CategoryDAO dao = new CategoryDAO();
	private ArrayList<String> arr;

	private void change(int id, String password) {
		arr = new ArrayList<String>();
		arr.add(password);
		arr.add(String.valueOf(id));
		dao.Execute("sp_ChangePassword", arr, null);
	}

	/**
	 * Create the dialog.
	 */
	public ChangePassword(int id, JFrame own) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChangePassword.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Current Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 53, 132, 20);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 114, 132, 20);
		contentPanel.add(lblNewLabel_1);

		currentpsw = new JPasswordField();
		currentpsw.setBounds(190, 53, 197, 20);
		contentPanel.add(currentpsw);

		newpsw = new JPasswordField();
		newpsw.setBounds(190, 114, 197, 20);
		contentPanel.add(newpsw);

		confirmpsw = new JPasswordField();
		confirmpsw.setBounds(190, 175, 197, 20);
		contentPanel.add(confirmpsw);

		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(48, 175, 132, 20);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(10, 11, 197, 24);
		contentPanel.add(lblNewLabel_3);

		JButton btnChange = new JButton("Apply");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curpwd = String.valueOf(currentpsw.getPassword());
				String newpwd = String.valueOf(newpsw.getPassword());
				String conpwd = String.valueOf(confirmpsw.getPassword());
				String uid = String.valueOf(id);
				Object[] object = dao.GetAData("sp_GetUserName", uid);
				String user = String.valueOf(object[0]);
				Encrypt en = new Encrypt();
				String[] str = { String.valueOf(id), en.md5(user + en.encode(curpwd)) };
				MyPattern mp = new MyPattern();
				Object obj[] = dao.CheckLogin("sp_CheckPass", str, 1);
				if (Integer.valueOf(String.valueOf(obj[0])) > 0) {
					if (mp.PasswordCheck(newpwd) && mp.PasswordCheck(conpwd)) {
						if (newpwd.equals(conpwd)) {
							change(id, en.md5(user + en.encode(newpwd)));
							dispose();
							own.dispose();
							Login log = new Login();
							log.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(ChangePassword.this, "Password didn't match", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(ChangePassword.this,
								"Please input password without special word and have length 8-20", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(ChangePassword.this, "Wrong Password", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnChange.setBounds(10, 227, 89, 23);
		contentPanel.add(btnChange);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPanel.add(btnClose);
	}
}
