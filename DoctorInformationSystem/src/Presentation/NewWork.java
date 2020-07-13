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

public class NewWork extends JDialog {
	private JTextField tfEvent;
	private JTextField tfStart;
	private JTextField tfEnd;
	private JButton btnSave;
	CategoryDAO dao = new CategoryDAO();
	private JLabel lblDate;
	private JTextField tfDate;
	private JButton btnNewButton;

	/**
	 * Create the dialog.
	 */
	public NewWork(Object id, ShowListWork owner) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(NewWork.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setTitle("New Work");
		setBounds(100, 100, 450, 233);
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEvent.setBounds(51, 70, 69, 21);
		getContentPane().add(lblEvent);

		tfEvent = new JTextField();
		tfEvent.setBounds(140, 65, 192, 32);
		getContentPane().add(tfEvent);
		tfEvent.setColumns(10);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(51, 114, 69, 21);
		getContentPane().add(lblTime);

		tfStart = new JTextField();
		tfStart.setToolTipText("00:00-23:59");
		tfStart.setBounds(140, 108, 70, 27);
		getContentPane().add(tfStart);
		tfStart.setColumns(10);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTo.setBounds(229, 110, 24, 21);
		getContentPane().add(lblTo);

		tfEnd = new JTextField();
		tfEnd.setToolTipText("00:00-23:59");
		tfEnd.setBounds(263, 108, 69, 27);
		getContentPane().add(tfEnd);
		tfEnd.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfDate.getText().equals("") || tfStart.getText().equals("") || tfEnd.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Fill full information please !!!");
				} else {
					String[] para = { String.valueOf(id), tfDate.getText(), tfEvent.getText(), tfStart.getText(),
							tfEnd.getText() };
					Work check = new Work();
					String[] str = { tfDate.getText(), String.valueOf(id) };
					check = dao.GetWork("work_search", str);
					if (check.getdate() == null) {
						dao.Action("work_insert", para);
						owner.load(id, "");
						dispose();
					} else {
						JOptionPane.showMessageDialog(getParent(), "This work has exist already");
					}
				}
			}
		});
		btnSave.setBounds(306, 151, 89, 32);
		getContentPane().add(btnSave);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(51, 28, 69, 21);
		getContentPane().add(lblDate);

		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(140, 22, 150, 32);
		getContentPane().add(tfDate);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = new Calendar(tfDate);
				cal.setVisible(true);
				cal.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(NewWork.class.getResource("/images/calendar.png")));
		btnNewButton.setBounds(289, 22, 42, 32);
		getContentPane().add(btnNewButton);
	}
}
