package Presentation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.CategoryDAO;
import Models.Doc_Pro;
import Models.Professional;
import Models.dsDoc_Pro;

public class ShowProfessional extends JDialog {
	private JTextField tfPro;
	CategoryDAO dao = new CategoryDAO();
	dsDoc_Pro dsdocpro = new dsDoc_Pro();

	/**
	 * Create the dialog.
	 */
	public ShowProfessional(Object id, ShowDoctors owner, String update) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowProfessional.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(null);

		setTitle("Professional");
		setModal(true);

		if (id != null) {
			int doc_id = Integer.valueOf(String.valueOf(id));
			int i = 0;
			dsdocpro = dao.getDoctor_proByid("doc_pro_showbydoc_id", doc_id);
			Professional pro = new Professional();
			for (Doc_Pro item : dsdocpro) {
				String[] pro_id = { String.valueOf(item.getPro_id()) };
				JLabel lblPro = new JLabel("- " + dao.getPro("getProById", pro_id).getname());
				lblPro.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblPro.setBounds(20, 26 + i, 147, 20);
				getContentPane().add(lblPro);
				i += 20;
			}
		}

		if (owner.strid != null) {
			int i = 0;
			String[] pro_id = owner.strid.split(",");
			for (int j = 1; j < pro_id.length; j++) {
				String[] parameters = { String.valueOf(pro_id[j]) };
				JLabel lblPro = new JLabel("- " + dao.getPro("getProById", parameters).getname());
				lblPro.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblPro.setBounds(20, 26 + i, 147, 20);
				getContentPane().add(lblPro);
				i += 20;
			}
		}

		if (update != null) {
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] doc_id = { String.valueOf(id) };
					if (id != null) {
						dao.Action("doc_pro_delete", doc_id);
					}
					owner.strid = "";
					String[] list = tfPro.getText().split(",");
					if (tfPro.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Fill Professional Please");
					} else {
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
							dispose();
						}
					}
				}
			});
			btnAdd.setBounds(293, 218, 99, 32);
			getContentPane().add(btnAdd);
			tfPro = new JTextField();
			tfPro.setToolTipText("Cardiology, Dermatology,...");
			tfPro.setBounds(30, 218, 236, 32);
			getContentPane().add(tfPro);
			tfPro.setColumns(10);
		}
	}
}
