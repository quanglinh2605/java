package Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class GymCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JCalendar calendar;
	private String date = "";

	/**
	 * Create the dialog.
	 */
	public GymCalendar(JTextField txt) {
		setBounds(200, 200, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		calendar = new JCalendar();
		calendar.setBounds(10, 11, 414, 206);
		contentPanel.add(calendar);

		JButton btnGet = new JButton("GetDate");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
				date = d.format(calendar.getDate());
				txt.setText(date);
				dispose();
			}
		});
		btnGet.setBounds(335, 227, 89, 23);
		contentPanel.add(btnGet);
	}
}
