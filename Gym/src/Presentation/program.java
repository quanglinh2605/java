package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class program extends JFrame {
	JLabel container = new JLabel();
	public static String name;

	/**
	 * Create the frame.
	 */
	public program(Login owner) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1100, 600);
		getContentPane().setLayout(null);
		name = owner.username;
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\eclipse\\eclipse\\workspaces\\Gym\\images\\bg-gym.jpg"));
		label.setBounds(0, 0, 1100, 600);
		getContentPane().add(label);
		container.setBounds(0, 0, 1000, 700);
		label.add(container);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnEmployee = new JMenu("View");
		menuBar.add(mnEmployee);

		JMenuItem mntmInvoice = new JMenuItem("Invoice");
		mntmInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				showInvoice si = new showInvoice(container);
				container.add(si);
				si.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnEmployee.add(mntmInvoice);

		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				showEmp se = new showEmp(container);
				container.add(se);
				se.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnEmployee.add(mntmEmployee);

		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);

		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				ChangePassword cp = new ChangePassword(program.this, container, owner.admin_id);
				container.add(cp);
				cp.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnAccount.add(mntmChangePassword);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		mnAccount.add(mntmLogOut);
	}
}
