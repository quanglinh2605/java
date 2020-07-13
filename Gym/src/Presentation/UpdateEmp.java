package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.CategoryDAO;
import Models.Emp;
import Models.emptype;
import Models.emptypes;

public class UpdateEmp extends JDialog {
	private JTextField tfName;
	private JTextField tfUsername;
	private int emp_id;
	CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the dialog.
	 */
	public UpdateEmp(showEmp owner) {
		setBounds(600, 300, 450, 267);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblName.setBounds(37, 21, 87, 25);
		getContentPane().add(lblName);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(37, 75, 87, 25);
		getContentPane().add(lblUsername);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblType.setBounds(37, 129, 87, 25);
		getContentPane().add(lblType);

		Emp item = new Emp();
		item = dao.getEmpbyId(owner.data);

		tfName = new JTextField();
		tfName.setBounds(143, 23, 177, 22);
		getContentPane().add(tfName);
		tfName.setColumns(10);
		tfName.setText((item.getName()));

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(143, 77, 177, 22);
		getContentPane().add(tfUsername);
		tfUsername.setText(item.getUserName());

		emptypes ds = new emptypes();
		ds = dao.getEmptype();
		JComboBox cbBType = new JComboBox();
		cbBType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbBType.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = cbBType.getSelectedIndex();
						emptypes ds = new emptypes();
						ds = dao.getEmptype();
						emp_id = Integer.valueOf(ds.get(index).getid());
					}
				});
			}
		});
		cbBType.setBounds(143, 131, 133, 25);
		for (emptype it : ds) {
			cbBType.addItem(it.getemptype());
		}
		cbBType.setSelectedIndex(item.getemptype() - 1);
		getContentPane().add(cbBType);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("") || tfUsername.equals("")) {
					JOptionPane.showMessageDialog(btnUpdate, "Fill Full Please");
				} else {
					Emp item = new Emp();
					item = dao.getEmpbyId(owner.data);
					item.setName(tfName.getText());
					item.setUserName(tfUsername.getText());
					item.setemptype(emp_id);
					try {
						boolean kq = dao.updateEmp(item);
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
				}
			}
		});
		btnUpdate.setBounds(276, 184, 89, 23);
		getContentPane().add(btnUpdate);
	}
}
