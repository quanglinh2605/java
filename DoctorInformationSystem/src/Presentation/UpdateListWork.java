package Presentation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.CategoryDAO;
import Models.Work;

public class UpdateListWork extends JDialog {
	private JTextField tfStart;
	private JTextField tfEnd;
	CategoryDAO dao = new CategoryDAO();
	private JTextField tfDate;

	/**
	 * Create the dialog.
	 */
	public UpdateListWork(Object id, String[] str, ShowListWork owner) {
		setTitle("Update Work");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(UpdateListWork.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 433, 244);
		getContentPane().setLayout(null);
		setModal(true);

		Work item = new Work();
		item = dao.GetWork("work_search", str);
		String oldDate = item.getdate();
		String start = item.getStartTime().substring(0, 5);
		String end = item.getEndTime().substring(0, 5);

		JLabel lblEvent = new JLabel("Event");
		lblEvent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEvent.setBounds(49, 82, 55, 30);
		getContentPane().add(lblEvent);

		JTextField tfEvent = new JTextField(item.getevent());
		tfEvent.setBounds(133, 83, 195, 30);
		getContentPane().add(tfEvent);
		tfEvent.setColumns(10);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(49, 123, 55, 30);
		getContentPane().add(lblTime);

		tfStart = new JTextField(start);
		tfStart.setToolTipText("00:00 - 23:59");
		tfStart.setColumns(10);
		tfStart.setBounds(133, 126, 70, 27);
		getContentPane().add(tfStart);

		JLabel label = new JLabel("To");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(220, 128, 29, 21);
		getContentPane().add(label);

		tfEnd = new JTextField(end);
		tfEnd.setToolTipText("00:00 - 23:59\r\n");
		tfEnd.setColumns(10);
		tfEnd.setBounds(259, 126, 69, 27);
		getContentPane().add(tfEnd);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfDate.getText().equals("") || tfStart.getText().equals("") || tfEnd.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Fill full information please !!!");
				} else {
					String[] para = { tfDate.getText(), tfEvent.getText(), tfStart.getText(), tfEnd.getText(), oldDate,
							String.valueOf(id) };
					Work check = new Work();
					String[] str = { tfDate.getText(), String.valueOf(id) };
					check = dao.GetWork("work_search", str);
					if (check.getdate() == null || tfDate.getText().equals(oldDate)) {
						dao.Action("work_update", para);
						owner.load(id, "");
						dispose();

					} else {
						JOptionPane.showMessageDialog(getParent(), "This work has exist already");
					}
				}
			}
		});
		btnSave.setBounds(286, 164, 89, 30);
		getContentPane().add(btnSave);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(49, 41, 55, 30);
		getContentPane().add(lblDate);

		tfDate = new JTextField(item.getdate());
		tfDate.setColumns(10);
		tfDate.setBounds(133, 42, 155, 30);
		getContentPane().add(tfDate);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = new Calendar(tfDate);
				cal.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(UpdateListWork.class.getResource("/images/calendar.png")));
		button.setBounds(286, 40, 42, 32);
		getContentPane().add(button);
	}
}
