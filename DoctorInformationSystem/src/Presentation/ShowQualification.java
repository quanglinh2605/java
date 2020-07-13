package Presentation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.CategoryDAO;
import Models.Doctor;
import Models.Doctors;

public class ShowQualification extends JDialog {
	CategoryDAO dao = new CategoryDAO();
	Doctors dsDoc = new Doctors();
	private JTextField tfQua;

	/**
	 * Create the dialog.
	 */
	public ShowQualification(Object id, ShowDoctors owner, String update) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowQualification.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(null);

		if (id == null || update != null) {
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					owner.strQua = tfQua.getText();
					dispose();
				}
			});
			btnAdd.setBounds(293, 218, 99, 32);
			getContentPane().add(btnAdd);

			tfQua = new JTextField();
			tfQua.setBounds(30, 218, 236, 32);
			tfQua.setToolTipText("Surgeon, Analyst, Dietician,...");
			getContentPane().add(tfQua);
			tfQua.setColumns(10);
		}
		setModal(true);
		setTitle("Qualification");
		if (id != null && update == null) {
			int i = 0;
			String[] doc_id = { String.valueOf(id) };
			dao.getDoctor_detail("doctor_detail", doc_id);
			dsDoc = dao.getdsDoctor();
			for (Doctor item : dsDoc) {
				owner.strQua = item.getqualification();
				if (owner.strQua.equals(""))
					return;
				else {
					String[] list = owner.strQua.split(",");
					for (String it : list) {
						JLabel lblQua = new JLabel("- " + it.trim());
						lblQua.setFont(new Font("Tahoma", Font.PLAIN, 13));
						lblQua.setBounds(20, 26 + i, 147, 20);
						getContentPane().add(lblQua);
						i += 20;
					}
				}
			}
		}
		if (owner.strQua != null) {
			int i = 0;
			if (owner.strQua.equals(""))
				return;
			else {
				String[] list = owner.strQua.split(",");
				for (String it : list) {
					JLabel lblQua = new JLabel("- " + it.trim());
					lblQua.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblQua.setBounds(20, 26 + i, 147, 20);
					getContentPane().add(lblQua);
					i += 20;
				}
			}
		}
	}
}
