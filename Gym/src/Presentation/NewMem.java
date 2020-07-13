package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class NewMem extends JDialog {
	private JTextField tfName;
	private JTextField tfNumPhone;
	CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the dialog.
	 */
	class JTextFieldLimit extends PlainDocument {
		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
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

	public NewMem(showMembers owner) {
		setBounds(600, 300, 350, 205);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(35, 23, 63, 23);
		getContentPane().add(lblName);

		JLabel lblNumberPhone = new JLabel("Number Phone");
		lblNumberPhone.setBounds(35, 64, 89, 23);
		getContentPane().add(lblNumberPhone);

		tfName = new JTextField();
		tfName.setBounds(154, 23, 153, 22);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		tfNumPhone = new JTextField();
		tfNumPhone.setBounds(154, 64, 153, 23);
		getContentPane().add(tfNumPhone);
		tfNumPhone.setColumns(10);
		tfNumPhone.setDocument(new JTextFieldLimit(10));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("") || tfNumPhone.equals("")) {
					JOptionPane.showMessageDialog(btnAdd, "Full Fill Please!!!");
				} else {
					String regex = "\\d+";
					if (tfNumPhone.getText().matches(regex)) {

						int k = 0;
						for (Member item : owner.dsMem) {
							if (tfName.getText().equals(item.getname())) {
								k++;
							}
						}
						if (k == 0) {
							Member mem = new Member();
							mem.setname(tfName.getText());
							mem.setnumPhone(tfNumPhone.getText());
							dao.CreateMem(mem);
							owner.loadTable();
							JOptionPane.showMessageDialog(btnAdd, "Added successfully");
							dispose();
						} else {
							JOptionPane.showMessageDialog(btnAdd, "Member Information is existed");
						}
					} else {
						JOptionPane.showMessageDialog(btnAdd, "Number phone wrong");
					}
				}
			}
		});
		btnAdd.setBounds(218, 116, 89, 23);
		getContentPane().add(btnAdd);
	}

}
