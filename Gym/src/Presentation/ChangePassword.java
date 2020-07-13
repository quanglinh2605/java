package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Dao.CategoryDAO;
import Models.Emp;
import Models.Emps;

public class ChangePassword extends JPanel {
	private JPasswordField pfCurrent;
	private JPasswordField pfNew;
	private JPasswordField pfAgain;
	Emps dsEmp = new Emps();
	CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the panel.
	 */
	public ChangePassword(JFrame owner, JLabel container, int id) {
		setLayout(null);

		setBounds(300, 100, 500, 271);

		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentPassword.setBounds(39, 32, 112, 23);
		add(lblCurrentPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewPassword.setBounds(39, 96, 91, 23);
		add(lblNewPassword);

		JLabel lblAgainNewPassword = new JLabel("Again New Password");
		lblAgainNewPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgainNewPassword.setBounds(39, 163, 134, 23);
		add(lblAgainNewPassword);

		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emp item = new Emp();
				item = dao.getEmpbyId(String.valueOf(id));
				if (String.valueOf(pfCurrent.getPassword()).equals(item.getpassword())) {
					if (String.valueOf(pfNew.getPassword()).equals(String.valueOf(pfAgain.getPassword()))) {
						item.setpassword(String.valueOf(pfNew.getPassword()));
						try {
							boolean kq = dao.updateEmp(item);
							if (kq) {
								JOptionPane.showMessageDialog(btnChange, "Changed Success");
								owner.dispose();
								Login lg = new Login();
								lg.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(btnChange, "Can't Change");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(btnChange, "Confirm Pass Wrong");
					}
				} else {
					JOptionPane.showMessageDialog(btnChange, "Wrong Password");
				}
			}
		});
		btnChange.setBounds(260, 215, 89, 23);
		add(btnChange);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
			}
		});
		btnCancel.setBounds(359, 215, 89, 23);
		add(btnCancel);

		pfCurrent = new JPasswordField();
		pfCurrent.setBounds(183, 33, 194, 23);
		add(pfCurrent);

		pfNew = new JPasswordField();
		pfNew.setBounds(183, 97, 194, 23);
		add(pfNew);

		pfAgain = new JPasswordField();
		pfAgain.setBounds(183, 163, 194, 23);
		add(pfAgain);
	}
}
