package Presentation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class Calendar extends JDialog {
	private JCalendar calendar;
	private String date;

	/**
	 * Create the dialog.
	 */
	public Calendar(JTextField Date) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Calendar.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setTitle("Choose day");
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(null);
		setModal(true);
		calendar = new JCalendar();
		calendar.setBounds(10, 11, 414, 193);
		getContentPane().add(calendar);

		JButton btnCreatePlan = new JButton("Get Date");
		btnCreatePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
				date = d.format(calendar.getDate());
				Date.setText(date);
				dispose();
			}
		});
		btnCreatePlan.setBounds(329, 227, 95, 23);
		getContentPane().add(btnCreatePlan);
	}
}
