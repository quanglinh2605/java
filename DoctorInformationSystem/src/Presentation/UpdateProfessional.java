package Presentation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import DAO.CategoryDAO;

public class UpdateProfessional extends JDialog {
	private JTextField tfPro;
	CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the dialog.
	 */
	public UpdateProfessional(ProfessionalList owner, int id) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(UpdateProfessional.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 450, 120);
		getContentPane().setLayout(null);
		setModal(true);
		tfPro = new JTextField();
		tfPro.setBounds(28, 29, 226, 29);
		getContentPane().add(tfPro);
		tfPro.setColumns(10);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] name = { String.valueOf(id), tfPro.getText() };
				dao.Action("pro_update", name);
				owner.load("getProByname", "%" + "" + "%");
				dispose();
			}
		});
		btnNewButton.setBounds(286, 29, 99, 29);
		getContentPane().add(btnNewButton);
	}

}
