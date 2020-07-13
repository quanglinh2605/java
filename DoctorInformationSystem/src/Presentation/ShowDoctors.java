package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CategoryDAO;
import Models.Doctor;
import Models.Doctors;
import Models.Professional;
import Models.Professionals;
import MyLibrary.DataSource;
import MyLibrary.LoadTable;

public class ShowDoctors extends JPanel {
	private JTable table;
	CategoryDAO dao = new CategoryDAO();
	Doctors dsDoc = new Doctors();
	String[] button = { "Update", "Delete", "Detail" };
	String[] button1 = { "Detail" };
	public static String strQua = "";
	public static String strAchi = "";
	public static String strid = "";
	private static Object id;
	private JTextField tfSearch;

	/**
	 * Create the panel.
	 */
	public void Search(String check) {
		String[] search = { "%" + tfSearch.getText() + "%", "%" + tfSearch.getText() + "%",
				"%" + tfSearch.getText() + "%" };
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column > 6;
			}
		};
		if (check.equals("admin")) {
			dao.loadData("doctor_search", button, search);
		} else
			dao.loadData("doctor_search", button1, search);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable load = new LoadTable();
		load.load(table, ds, model);
		if (check.equals("admin"))
			for (int i = 0; i < button.length; i++) {
				dao.addbtn(table, button[i]);
			}
		else
			dao.addbtn(table, button1[0]);
		table.revalidate();
		table.repaint();
	}

	public void load(String check) {
		String[] Search = { "%" + "%", "%" + "%", "%" + "%" };
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column > 6;
			}
		};
		if (check.equals("admin")) {
			dao.loadData("doctor_search", button, Search);
		} else
			dao.loadData("doctor_search", button1, Search);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable load = new LoadTable();
		load.load(table, ds, model);
		if (check.equals("admin"))
			for (int i = 0; i < button.length; i++) {
				dao.addbtn(table, button[i]);
			}
		else
			dao.addbtn(table, button1[0]);
		table.revalidate();
		table.repaint();
	}

	public void pro_search(String sp_name, String str) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column > 6;
			}
		};
		String[] pro_id = { str };
		dao.loadData(sp_name, button, pro_id);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable load = new LoadTable();
		load.load(table, ds, model);
		for (int i = 0; i < button.length; i++) {
			dao.addbtn(table, button[i]);
		}
		table.revalidate();
		table.repaint();
	}

	public ShowDoctors(Manager owner, JLabel container) {
		setLayout(null);
		setBounds(230, 100, 866, 459);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				String[] str = { String.valueOf(table.getValueAt(row, 3)), String.valueOf(table.getValueAt(row, 3)),
						String.valueOf(table.getValueAt(row, 3)) };
				Doctor item = new Doctor();
				item = dao.getDoctor("doctor_search", str);
				id = item.getid();
				String colname = table.getColumnName(col);
				if (colname.equals("Detail")) {
					strid = null;
					Doctor_detail dt = new Doctor_detail(id, ShowDoctors.this, owner.usertype);
					dt.setVisible(true);
				}
				if (colname.equals("Update")) {
					UpdateDoctor ud = new UpdateDoctor(id, ShowDoctors.this);
					ud.setVisible(true);
				}
				if (colname.equals("Delete")) {
					int check = JOptionPane.showConfirmDialog(getParent(), "Delete doctor", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (check == JOptionPane.YES_OPTION) {
						String[] doc_id = { String.valueOf(id) };
						dao.Action("doc_pro_delete", doc_id);
						dao.Action("doctor_delete", doc_id);
						Search(owner.usertype);
					} else {
						Search(owner.usertype);
					}

				}
			}
		});
		table.setBounds(30, 40, 500, 400);
		table.setRowHeight(30);

		load(owner.usertype);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 101, 816, 313);
		add(scrollPane);
		if (owner.usertype.equals("admin")) {
			JButton btnNewDoctor = new JButton("New Doctor");
			btnNewDoctor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					strAchi = "";
					strQua = "";
					strid = "";
					NewDoctor nd = new NewDoctor(ShowDoctors.this);
					nd.setVisible(true);
				}
			});
			btnNewDoctor.setBounds(25, 425, 107, 23);
			add(btnNewDoctor);
		}
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
			}
		});
		btnClose.setBounds(752, 425, 89, 23);
		add(btnClose);

		tfSearch = new JTextField("");
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Search(owner.usertype);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Search(owner.usertype);
			}
		});
		tfSearch.setBounds(25, 40, 190, 30);
		add(tfSearch);
		tfSearch.setColumns(10);

		JLabel lblName = new JLabel("Search for Name, Location, Faculty");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblName.setBounds(25, 10, 271, 30);
		add(lblName);

		if (owner.usertype.equals("admin")) {
			JButton btnShowAll = new JButton("Show all");
			btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					load(owner.usertype);
				}
			});
			btnShowAll.setBounds(318, 425, 89, 23);
			add(btnShowAll);

			JButton btnProfessionalList = new JButton("Professional List");
			btnProfessionalList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProfessionalList pl = new ProfessionalList(ShowDoctors.this);
					pl.setVisible(true);
				}
			});
			btnProfessionalList.setBounds(160, 425, 136, 23);
			add(btnProfessionalList);
		} else {
			JLabel lblProfessional = new JLabel("List Professional");
			lblProfessional.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
			lblProfessional.setBounds(586, 10, 141, 30);
			add(lblProfessional);

			JComboBox cbbPro = new JComboBox();
			Professionals dspro = new Professionals();
			dao.getAllPro("getpro");
			dspro = dao.getdsPro();
			cbbPro.addItem("All Professional");
			for (Professional item : dspro) {
				cbbPro.addItem(item.getname());
			}
			cbbPro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = cbbPro.getSelectedIndex();
					String[] proname = { String.valueOf(cbbPro.getItemAt(index)) };
					if (proname[0] == "All Professional") {
						load(owner.usertype);
					} else {
						String pro_id = String.valueOf(dao.getPro("getProByname", proname).getid());
						pro_search("doc_pro_search", pro_id);
					}
				}
			});
			cbbPro.setBounds(586, 40, 141, 30);
			add(cbbPro);
		}

	}
}
