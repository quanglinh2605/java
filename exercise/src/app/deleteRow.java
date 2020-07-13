package app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.product;
import repositories.ProBusiness;

public class deleteRow extends JDialog {
	ProBusiness pro = new ProBusiness();

	/**
	 * Create the dialog.
	 */
	public deleteRow(jtable owner) {
		super(owner, "xoa hang", true);
		setBounds(100, 100, 308, 213);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete row ?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(94, 21, 112, 46);
		getContentPane().add(lblNewLabel);

		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product cur = new product();
				cur = pro.getProductById(owner.idPro);
				try {
					boolean kq = pro.deleteRow(cur);
					if (kq == true) {
						JOptionPane.showMessageDialog(btnYes, "xoa thanh cong");
						dispose();
						owner.setVisible(true);
					} else {
						System.out.println("xoa that bai");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();

				}
			}
		});
		btnYes.setBounds(33, 88, 89, 23);
		getContentPane().add(btnYes);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				owner.setVisible(true);
			}
		});
		btnCancel.setBounds(161, 88, 89, 23);
		getContentPane().add(btnCancel);
	}
}
