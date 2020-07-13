package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class NewEmp extends JDialog {
	private JTextField tfName;
	private JTextField tfUsername;
	private JTextField tfPass;
	private int emp_id = 0;
	private JComboBox cmbEmp;
	emptypes ds = new emptypes();
	CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the panel.
	 */
	public NewEmp(showEmp owner) {
		getContentPane().setLayout(null);
		setBounds(600, 300, 500, 329);
		setModal(true);
		JLabel lblNewEmployee = new JLabel("New Employee");
		lblNewEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewEmployee.setBounds(35, 21, 125, 31);
		getContentPane().add(lblNewEmployee);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(55, 63, 62, 23);
		getContentPane().add(lblName);

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(55, 110, 89, 23);
		getContentPane().add(lblUserName);

		JLabel lblPassWord = new JLabel("Pass word");
		lblPassWord.setBounds(55, 156, 62, 23);
		getContentPane().add(lblPassWord);

		JLabel lblEmployeeType = new JLabel("Employee type");
		lblEmployeeType.setBounds(55, 205, 105, 23);
		getContentPane().add(lblEmployeeType);

		tfName = new JTextField();
		tfName.setBounds(177, 63, 147, 22);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(177, 110, 147, 22);
		getContentPane().add(tfUsername);

		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(177, 156, 147, 22);
		getContentPane().add(tfPass);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("") || tfUsername.getText().equals("") || tfPass.getText().equals("")
						|| emp_id == 0) {
					JOptionPane.showMessageDialog(btnAdd, "Fill Full Information Please!!!");
				} else {
					int k = 0;
					for (Emp item : owner.dsEmp) {
						if (item.getName().equals(tfName.getText())
								|| item.getUserName().equals(tfUsername.getText())) {
							k++;
						}
					}
					if (k != 0) {
						JOptionPane.showMessageDialog(btnAdd, "Member Information is existed");
					} else {
						Emp item = new Emp();
						item.setName(tfName.getText());
						item.setUserName(tfUsername.getText());
						item.setpassword(tfPass.getText());
						item.setemptype(emp_id);
						dao.CreateEmp(item);
						owner.loadTable();
						JOptionPane.showMessageDialog(btnAdd, "Add Successful");
						dispose();
					}
				}
			}
		});
		btnAdd.setBounds(284, 245, 89, 31);
		getContentPane().add(btnAdd);

		cmbEmp = new JComboBox();
		ds = dao.getEmptype();
		for (emptype item : ds) {
			cmbEmp.addItem(item.getemptype());
		}
		cmbEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cmbEmp.getSelectedIndex();
				emp_id = Integer.valueOf(ds.get(index).getid());
			}
		});
		cmbEmp.setBounds(177, 205, 147, 23);
		getContentPane().add(cmbEmp);

	}
}
