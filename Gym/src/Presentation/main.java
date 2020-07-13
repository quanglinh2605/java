package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main extends JFrame {
	JLabel container = new JLabel();

	/**
	 * Create the frame.
	 */
	public main(Login owner) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1100, 600);
		getContentPane().setLayout(null);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\eclipse\\eclipse\\workspaces\\Gym\\images\\bg-gym.jpg"));
		label.setBounds(0, 0, 1100, 600);
		getContentPane().add(label);
		container.setBounds(0, 0, 1000, 700);
		label.add(container);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmMembers = new JMenuItem("Members");
		mntmMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				int empid = owner.emp_id;
				showMembers sm = new showMembers(container, empid);
				container.add(sm);
				sm.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnView.add(mntmMembers);

		JMenuItem mntmTrainers = new JMenuItem("Trainers");
		mntmTrainers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				ShowTrainer st = new ShowTrainer(container);
				container.add(st);
				st.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnView.add(mntmTrainers);

		JMenuItem mntmCourse = new JMenuItem("Course");
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				ShowCourse sc = new ShowCourse(container);
				container.add(sc);
				sc.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnView.add(mntmCourse);

		JMenuItem mntmGarbage = new JMenuItem("Garbage");
		mntmGarbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				Garbage gb = new Garbage(container);
				container.add(gb);
				gb.setVisible(true);
				container.revalidate();
				container.repaint();
			}
		});
		mnView.add(mntmGarbage);

		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);

		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				ChangePassword cp = new ChangePassword(main.this, container, owner.emp_id);
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
