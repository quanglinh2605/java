package Presentation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CategoryDAO;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JLabel container;
	CategoryDAO dao = new CategoryDAO();
	public static String usertype = "";

	/**
	 * Create the frame.
	 */
	public Manager(Login log) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Manager.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1100, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		usertype = dao.GetUsertypeById(log.usertype).getname();

		if (usertype.equals("admin")) {
			JMenuItem mntmUser = new JMenuItem("User");
			mntmUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					container.removeAll();
					UserView uv = new UserView(Manager.this, container);
					container.add(uv);
					uv.setBounds(230, 50, 900, 600);
					container.revalidate();
					container.repaint();
				}
			});
			mnView.add(mntmUser);
		}
		JMenuItem mntmDoctor = new JMenuItem("Doctor");
		mntmDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				ShowDoctors sd = new ShowDoctors(Manager.this, container);
				container.add(sd);
				sd.setBounds(120, 50, 900, 600);
				container.revalidate();
				container.repaint();
			}
		});
		mnView.add(mntmDoctor);

		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);

		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp = new ChangePassword(log.userid, Manager.this);
				cp.setVisible(true);
			}
		});
		mnAccount.add(mntmChangePassword);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		mnAccount.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		container = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(container,
				GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(container,
				GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
