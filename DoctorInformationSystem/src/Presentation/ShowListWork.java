package Presentation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CategoryDAO;
import MyLibrary.DataSource;
import MyLibrary.LoadTable;

public class ShowListWork extends JDialog {
	private JTable table;
	private JTextField tfDate;
	private JLabel lblDate;
	CategoryDAO dao = new CategoryDAO();
	String[] button = { "Update", "Delete" };
	String[] button1 = null;

	/**
	 * Create the dialog.
	 */
	public void load(Object id, String check) {
		DefaultTableModel models = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column > 3;
			}
		};
		String[] paras = { "%" + tfDate.getText() + "%", String.valueOf(id) };
		if (check.equals("admin")) {
			dao.loadData("work_search", button, paras);
		} else
			dao.loadData("work_search", button1, paras);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable load = new LoadTable();
		load.load(table, ds, models);
		if (check.equals("admin"))
			for (int i = 0; i < button.length; i++)
				dao.addbtn(table, button[i]);
		table.revalidate();
		table.repaint();
	}

	public ShowListWork(Object id, String check) {
		setTitle("List Work");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowListWork.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(200, 200, 646, 393);
		getContentPane().setLayout(null);
		setModal(true);

		tfDate = new JTextField("");
		tfDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				load(id, check);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				load(id, check);
			}
		});
		tfDate.setBounds(31, 11, 139, 29);
		getContentPane().add(tfDate);
		tfDate.setColumns(10);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = table.getSelectedColumn();
				String colname = table.getColumnName(col);
				String[] str = { String.valueOf(table.getValueAt(table.getSelectedRow(), 1)), String.valueOf(id) };
				if (colname.equals("Update")) {
					UpdateListWork ul = new UpdateListWork(id, str, ShowListWork.this);
					ul.setVisible(true);
					load(id, check);
				}
				if (colname.equals("Delete")) {
					dao.Action("work_delete", str);
					load(id, check);
				}
			}
		});
		table.setBounds(30, 40, 500, 400);
		table.setRowHeight(30);

		load(id, check);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 61, 564, 226);
		getContentPane().add(scrollPane);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(180, 11, 66, 29);
		getContentPane().add(lblDate);

		if (check.equals("admin")) {
			JButton btnAddWork = new JButton("Add work");
			btnAddWork.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewWork cal = new NewWork(id, ShowListWork.this);
					cal.setVisible(true);
				}
			});
			btnAddWork.setBounds(31, 308, 89, 23);
			getContentPane().add(btnAddWork);
		}
	}
}
