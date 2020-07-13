package Presentation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class Doctor_detail extends JDialog {
	String str;

	/**
	 * Create the dialog.
	 */
	public Doctor_detail(Object id, ShowDoctors owner, String check) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Doctor_detail.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 562, 174);
		getContentPane().setLayout(null);
		setModal(true);
		setTitle("Information detail");

		JButton btnQualification = new JButton("Qualification");
		btnQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowQualification sq = new ShowQualification(id, owner, str);
				sq.setVisible(true);
			}
		});
		btnQualification.setBounds(10, 49, 111, 23);
		getContentPane().add(btnQualification);

		JButton btnAchivement = new JButton("Achivement");
		btnAchivement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAchivement sa = new ShowAchivement(id, owner, str);
				sa.setVisible(true);
			}
		});
		btnAchivement.setBounds(131, 49, 128, 23);
		getContentPane().add(btnAchivement);

		JButton btnProfessional = new JButton("Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowProfessional sp = new ShowProfessional(id, owner, str);
				sp.setVisible(true);
			}
		});
		btnProfessional.setBounds(269, 49, 124, 23);
		getContentPane().add(btnProfessional);

		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ShowListWork sl = new ShowListWork(id, check);
				sl.setVisible(true);
			}
		});
		btnSchedule.setBounds(403, 49, 124, 23);
		getContentPane().add(btnSchedule);
	}
}
