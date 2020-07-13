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
import Models.Doc_Pro;
import Models.Doctor;
import Models.dsDoc_Pro;
import MyLibrary.JTextFieldLimit;

public class UpdateDoctor extends JDialog {
	private JTextField tfName;
	private JTextField tfContact;
	private JTextField tfExp;
	private JTextField tfLoc;
	private JTextField tfFal;
	public static String strQua = "";
	public static String strAchi = "";
	public static String strid = "";
	CategoryDAO dao = new CategoryDAO();
	String str = "update";
	String Gender;
	String[] gender = { "Male", "Female", "Other" };

	/**
	 * Create the dialog.
	 */
	public UpdateDoctor(Object id, ShowDoctors owner) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(UpdateDoctor.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setTitle("Update Doctor");
		setBounds(100, 100, 450, 324);
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

		String[] doc_id = { String.valueOf(id) };
		Doctor item = new Doctor();
		item = dao.getDoctor("getDoctorById", doc_id);
		tfName = new JTextField(item.getname());
		tfName.setBounds(139, 24, 188, 21);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		tfContact = new JTextField();
		tfContact.setColumns(10);
		tfContact.setDocument(new JTextFieldLimit(10));
		tfContact.setBounds(139, 56, 188, 21);
		tfContact.setText(item.getcontact());
		getContentPane().add(tfContact);

		tfExp = new JTextField(item.getexperience());
		tfExp.setColumns(10);
		tfExp.setBounds(139, 88, 188, 21);
		getContentPane().add(tfExp);

		tfLoc = new JTextField(item.getloc());
		tfLoc.setColumns(10);
		tfLoc.setBounds(139, 120, 188, 21);
		getContentPane().add(tfLoc);

		Gender = item.getgender();

		tfFal = new JTextField(item.getfaculty());
		tfFal.setColumns(10);
		tfFal.setBounds(139, 152, 188, 21);
		getContentPane().add(tfFal);

		JButton btnQualification = new JButton("Qualification");
		btnQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowQualification sq = new ShowQualification(id, owner, str);
				sq.setVisible(true);
			}
		});
		btnQualification.setBounds(41, 216, 106, 23);
		getContentPane().add(btnQualification);

		JButton btnAchivement = new JButton("Achivement");
		btnAchivement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAchivement sa = new ShowAchivement(id, owner, str);
				sa.setVisible(true);
			}
		});

		btnAchivement.setBounds(157, 216, 125, 23);
		getContentPane().add(btnAchivement);

		JButton btnProfessional = new JButton("Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowProfessional sp = new ShowProfessional(id, owner, str);
				sp.setVisible(true);
			}
		});
		btnProfessional.setBounds(292, 216, 106, 23);
		getContentPane().add(btnProfessional);
		dao.getDoctor_detail("doctor_detail", doc_id);
		owner.strAchi = dao.getdsDoctor().get(0).getachivement();
		owner.strQua = dao.getdsDoctor().get(0).getqualification();
		owner.strid = "";
		dsDoc_Pro ds = new dsDoc_Pro();
		ds = item.getList();
		for (Doc_Pro it : ds) {
			owner.strid = owner.strid + "," + String.valueOf(it.getPro_id());
		}
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regex = "\\d+";
				if (tfContact.getText().matches(regex)) {
					String[] search = { tfName.getText() };
					String[] para = { tfContact.getText(), owner.strQua, tfExp.getText(), owner.strAchi,
							tfName.getText(), tfLoc.getText(), Gender, tfFal.getText(), String.valueOf(id) };
					dao.Action("doctor_update", para);
					dao.Action("doc_pro_delete", doc_id);
					owner.Search("admin");
					String[] pro_id = owner.strid.split(",");
					for (int i = 1; i < pro_id.length; i++) {
						String[] parameters = { String.valueOf(id), String.valueOf(pro_id[i]) };
						dao.Action("doc_pro_insert", parameters);
					}
					dispose();

				} else {
					JOptionPane.showMessageDialog(getParent(), "Only Fill Number");
				}
			}
		});
		btnUpdate.setBounds(270, 251, 89, 23);
		getContentPane().add(btnUpdate);

		JComboBox cbbGender = new JComboBox();
		for (int i = 0; i < gender.length; i++) {
			cbbGender.addItem(gender[i]);
			if (gender[i].equals(Gender)) {
				cbbGender.setSelectedIndex(i);
			}
		}
		cbbGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbbGender.getSelectedIndex();
				Gender = gender[index];
			}
		});
		cbbGender.setBounds(139, 183, 68, 22);
		getContentPane().add(cbbGender);
	}
}
