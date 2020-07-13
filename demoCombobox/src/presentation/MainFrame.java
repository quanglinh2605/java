package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DeptBusiness;
import models.Dept;
import models.Depts;

public class MainFrame extends JFrame {
	private JComboBox cbpDept;
	private JPanel contentPane;
	private JLabel lblid;
	Depts dsDept = new Depts();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbpDept = new JComboBox();
		DeptBusiness deptb = new DeptBusiness();
		dsDept = deptb.LoadAll();
		dsDept = DeptBusiness.LoadAll();
		for (Dept item : dsDept) {
			cbpDept.addItem(item.getDname());
		}
		cbpDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbpDept.getSelectedIndex();
				lblid.setText(String.valueOf(dsDept.get(index).getDeptNo()));
			}
		});
		cbpDept.setBounds(72, 57, 125, 22);
		contentPane.add(cbpDept);

		lblid = new JLabel("");
		lblid.setBounds(72, 107, 68, 22);
		contentPane.add(lblid);
	}

}
