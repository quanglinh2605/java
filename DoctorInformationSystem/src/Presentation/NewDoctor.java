package Presentation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.CategoryDAO;
import Models.Doctor;
import Models.Professional;
import MyLibrary.JTextFieldLimit;

public class NewDoctor extends JDialog {
	private JTextField tfName;
	private JTextField tfContact;
	private JTextField tfExp;
	private JTextField tfLoc;
	private JTextField tfFal;
	String Gender = "Male";
	String[] gender = { "Male", "Female", "Other" };
	Object id;
	CategoryDAO dao = new CategoryDAO();
	String str;
	private JTextField tfAchi;
	private JTextField tfQua;
	private JTextField tfPro;

	/**
	 * Create the dialog.
	 */
	public NewDoctor(ShowDoctors owner) {
		setTitle("Add Doctor");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(NewDoctor.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 450, 408);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 24, 68, 21);
		getContentPane().add(lblName);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(41, 56, 68, 21);
		getContentPane().add(lblContact);

		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setBounds(41, 88, 68, 21);
		getContentPane().add(lblExperience);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(41, 120, 68, 21);
		getContentPane().add(lblLocation);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(41, 184, 68, 21);
		getContentPane().add(lblGender);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(41, 152, 68, 21);
		getContentPane().add(lblFaculty);

		tfName = new JTextField();
		tfName.setBounds(139, 24, 188, 21);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		tfContact = new JTextField();
		tfContact.setColumns(10);
		tfContact.setBounds(139, 56, 188, 21);
		getContentPane().add(tfContact);
		tfContact.setDocument(new JTextFieldLimit(10));
		tfExp = new JTextField();
		tfExp.setColumns(10);
		tfExp.setBounds(139, 88, 188, 21);
		getContentPane().add(tfExp);

		tfLoc = new JTextField();
		tfLoc.setColumns(10);
		tfLoc.setBounds(139, 120, 188, 21);
		getContentPane().add(tfLoc);

		tfFal = new JTextField();
		tfFal.setColumns(10);
		tfFal.setBounds(139, 152, 188, 21);
		getContentPane().add(tfFal);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.strQua = tfQua.getText();
				owner.strAchi = tfAchi.getText();
				if (tfContact.getText().equals("") || tfExp.getText().equals("") || tfFal.getText().equals("")
						|| Gender.equals("") || tfLoc.getText().equals("") || tfName.getText().equals("")
						|| tfAchi.getText().equals("") || tfQua.getText().equals("") || tfPro.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Fill Full Information Please!!!");
				} else {
					String regex = "\\d+";
					if (tfContact.getText().matches(regex)) {
						String[] search = { tfName.getText() };
						int check = Integer.valueOf(String.valueOf(dao.returnval("row_count", search)[0]));
						if (check != 0) {
							JOptionPane.showMessageDialog(getParent(), "Doctor information is exist");

						} else {
							String[] list = tfPro.getText().split(",");
							Professional pro = new Professional();
							for (String item : list) {
								String[] name = { item.trim() };
								pro = dao.getPro("getProByname", name);
								if (pro.getname() == null) {
									dao.Action("pro_insert", name);
									pro = dao.getPro("getProByname", name);
									owner.strid = owner.strid + "," + String.valueOf(pro.getid());
								} else {
									owner.strid = owner.strid + "," + String.valueOf(pro.getid());
								}
							}
							String[] para = { tfContact.getText(), owner.strQua, tfExp.getText(), owner.strAchi,
									tfName.getText(), tfLoc.getText(), Gender, tfFal.getText() };
							dao.Action("doctor_insert", para);
							String[] paras = { tfName.getText(), tfFal.getText(), tfLoc.getText() };
							Doctor item = dao.getDoctor("doctor_search", paras);
							owner.load("admin");
							String[] pro_id = owner.strid.split(",");
							for (int i = 1; i < pro_id.length; i++) {
								String[] parameters = { String.valueOf(item.getid()), String.valueOf(pro_id[i]) };
								dao.Action("doc_pro_insert", parameters);
							}
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(getParent(), "Contact is wrong");
					}
				}
			}

		});

		btnAdd.setBounds(238, 322, 89, 23);
		getContentPane().add(btnAdd);

		JComboBox cbbGender = new JComboBox();
		for (String item : gender) {
			cbbGender.addItem(item);
		}
		cbbGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbbGender.getSelectedIndex();
				Gender = gender[index];
			}
		});
		cbbGender.setBounds(141, 183, 76, 22);
		getContentPane().add(cbbGender);

		JLabel lblShowachivement = new JLabel("Achivement");
		lblShowachivement.setBounds(41, 222, 89, 21);
		getContentPane().add(lblShowachivement);

		tfAchi = new JTextField();
		tfAchi.setColumns(10);
		tfAchi.setBounds(139, 222, 188, 21);
		getContentPane().add(tfAchi);

		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setBounds(41, 254, 89, 21);
		getContentPane().add(lblQualification);

		tfQua = new JTextField();
		tfQua.setToolTipText("Surgeon, Analyst, Dietician,...");
		tfQua.setColumns(10);
		tfQua.setBounds(139, 254, 188, 21);
		getContentPane().add(tfQua);

		JLabel lblProfessional = new JLabel("Professional");
		lblProfessional.setBounds(41, 286, 89, 21);
		getContentPane().add(lblProfessional);

		tfPro = new JTextField();
		tfPro.setToolTipText("Cardiology, Dermatology,...");
		tfPro.setColumns(10);
		tfPro.setBounds(139, 286, 188, 21);
		getContentPane().add(tfPro);
	}
}
