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

public class ShowAchivement extends JDialog {
	CategoryDAO dao = new CategoryDAO();
	Doctors dsDoc = new Doctors();
	private JTextField tfAchi;

	/**
	 * Create the dialog.
	 */
	public ShowAchivement(Object id, ShowDoctors owner, String update) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowAchivement.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(null);

		if (id == null || update != null) {
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					owner.strAchi = tfAchi.getText();
					dispose();
				}
			});
			btnAdd.setBounds(293, 218, 99, 32);
			getContentPane().add(btnAdd);
			tfAchi = new JTextField();
			tfAchi.setBounds(30, 218, 236, 32);
			getContentPane().add(tfAchi);
			tfAchi.setColumns(10);
		}
		setModal(true);
		setTitle("Achivement");
		if (id != null && update == null) {
			String[] doc_id = { String.valueOf(id) };
			dao.getDoctor_detail("doctor_detail", doc_id);
			dsDoc = dao.getdsDoctor();
			int i = 0;
			for (Doctor item : dsDoc) {
				owner.strAchi = item.getachivement();
				if (owner.strAchi.equals(""))
					return;
				else {
					String[] list = owner.strAchi.split(",");
					for (String it : list) {
						JLabel lblAchi = new JLabel("- " + it.trim());
						lblAchi.setFont(new Font("Tahoma", Font.PLAIN, 13));
						lblAchi.setBounds(20, 26 + i, 147, 20);
						getContentPane().add(lblAchi);
						i += 20;
					}
				}
			}
		}
		if (owner.strAchi != null) {
			int i = 0;
			if (owner.strAchi.equals(""))
				return;
			else {
				String[] list = owner.strAchi.split(",");
				for (String it : list) {
					JLabel lblAchi = new JLabel("- " + it.trim());
					lblAchi.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblAchi.setBounds(20, 26 + i, 147, 20);
					getContentPane().add(lblAchi);
					i += 20;
				}
			}
		}
	}
}
