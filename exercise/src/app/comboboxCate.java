package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.ConnectionSQL;
import models.category;
import models.dsCategory;

public class comboboxCate extends JFrame {
	private dsCategory cats = new dsCategory();
	private JLabel lblNewLabel;

	public void setcats(dsCategory value) {
		cats = value;
	}

	public dsCategory getcats() {
		return cats;
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comboboxCate frame = new comboboxCate();
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
	public comboboxCate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(44, 50, 120, 22);
		contentPane.add(comboBox);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(33, 98, 81, 30);
		contentPane.add(lblNewLabel);

		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "select * from category";
		ResultSet rs = myconn.Query(str);
		try {
			while (rs.next()) {
				category item = new category();
				item.setname(rs.getString("name"));
				item.setlabel(rs.getString("label"));
				cats.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < cats.size(); i++) {
			comboBox.addItem(cats.get(i).getname());
		}
	}
}
