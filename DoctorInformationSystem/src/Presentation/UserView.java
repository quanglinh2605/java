package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CategoryDAO;
import MyLibrary.DataSource;
import MyLibrary.LoadTable;

public class UserView extends JPanel {

	private JTable table;
	private CategoryDAO dao = new CategoryDAO();
	private JTextField txtSearch;
	private JLabel lblFilter;
	private String[] button = { "Update", "Delete", "Reset" };
	private int[] btn = { 3, 4, 5 };

	public void search() {
		String key = txtSearch.getText();
		dao.SearchData("sp_GetDataUser", button, key);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable loadtbl = new LoadTable();
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column > 2;
			}
		};
		loadtbl.load(table, ds, model);
		loadtbl.addbtn(table, btn);
		table.revalidate();
		table.repaint();
	}

	/**
	 * Create User panel
	 */
	public UserView(Manager boss, JLabel owner) {
		setLayout(null);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		txtSearch.setBounds(35, 40, 128, 20);
		add(txtSearch);
		txtSearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 71, 556, 243);
		add(scrollPane);
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column > 2;
			}
		};
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String name = String.valueOf(table.getModel().getValueAt(row, 1));
				String script = Base64.getEncoder().encodeToString(name.getBytes());
				if (table.getModel().getColumnName(column).equals("Update")) {
					UpdateUser uu = new UpdateUser(script);
					uu.setVisible(true);
					search();
				}
				if (table.getModel().getColumnName(column).equals("Delete")) {
					int rep = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Delete", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						dao.Execute("sp_DeleteUser", null, script);
						search();
					}
				}
				if (table.getModel().getColumnName(column).equals("Reset")) {
					int rep = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Reset Password",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						String s1 = "12345678";
						String s2 = Base64.getEncoder().encodeToString(s1.getBytes());
						String mypass = script + s2;
						String md5 = null;
						try {
							MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
							mdEnc.update(mypass.getBytes(), 0, mypass.length());
							md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string

						} catch (NoSuchAlgorithmException err) {
							// TODO Auto-generated catch block
							err.printStackTrace();

						}
						ArrayList<String> params = new ArrayList<String>();
						params.add(md5);
						dao.Execute("sp_ResetPassword", params, script);
						search();
					}
				}
			}
		});
		table.setRowHeight(30);
		dao.LoadData("sp_GetDataUser", button);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable loadtbl = new LoadTable();
		loadtbl.load(table, ds, model);

		loadtbl.addbtn(table, btn);

		scrollPane.setViewportView(table);
		lblFilter = new JLabel("Username, Role");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilter.setBounds(35, 11, 152, 20);
		add(lblFilter);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser nu = new NewUser();
				nu.setVisible(true);
				search();
			}
		});
		btnNew.setBounds(35, 341, 89, 23);
		add(btnNew);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(502, 341, 89, 23);
		add(btnClose);

	}
}
