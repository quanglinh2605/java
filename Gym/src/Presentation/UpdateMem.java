package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import Dao.CategoryDAO;
import Models.Member;

public class UpdateMem extends JDialog {
	private JTextField tfName;
	private JTextField tfPhone;
	private JButton btnUpdate;
	CategoryDAO dao = new CategoryDAO();

	class JTextFieldLimit extends PlainDocument {
		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateMem(showMembers owner) {
		setBounds(600, 300, 403, 262);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(48, 40, 82, 24);
		getContentPane().add(lblName);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(48, 100, 101, 24);
		getContentPane().add(lblPhoneNumber);
		Member item = new Member();
		item = dao.getMembyId(owner.data);

		tfName = new JTextField();
		tfName.setBounds(156, 43, 174, 21);
		getContentPane().add(tfName);
		tfName.setColumns(10);
		tfName.setText(item.getname());

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(156, 103, 174, 21);
		tfPhone.setDocument(new JTextFieldLimit(10));
		getContentPane().add(tfPhone);
		tfPhone.setText(item.getnumPhone());

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("") || tfPhone.getText().equals("")) {
					JOptionPane.showMessageDialog(btnUpdate, "Fill full Information Please !!!");
				} else {
					String regex = "\\d+";
					if (tfPhone.getText().matches(regex)) {

						Member item = new Member();
						item = dao.getMembyId(owner.data);
						item.setname(tfName.getText());
						item.setnumPhone(tfPhone.getText());
						try {
							boolean kq = dao.updateMem(item);
							if (kq) {
								owner.Search();
								JOptionPane.showMessageDialog(btnUpdate, "Updated Sucessful");
								dispose();
							} else {
								JOptionPane.showMessageDialog(btnUpdate, "Can't Update");
							}
						} catch (SQLException ez) {
							ez.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(btnUpdate, "Wrong Number Phone");
					}
				}
			}
		});
		btnUpdate.setBounds(290, 165, 89, 23);
		getContentPane().add(btnUpdate);
	}
}
