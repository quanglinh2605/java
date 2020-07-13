package Presentation;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CategoryDAO;
import Models.Professional;
import MyLibrary.DataSource;
import MyLibrary.LoadTable;

public class ProfessionalList extends JDialog {
	private JTable table;
	CategoryDAO dao = new CategoryDAO();
	String[] button = { "Update", "Delete", "Search" };

	/**
	 * Create the dialog.
	 */
	public void load(String sp_name, String str) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column > 3;
			}
		};
		String[] name = { str };
		dao.loadData(sp_name, button, name);
		DataSource ds = new DataSource(dao.getcolumn(), dao.getdatas());
		LoadTable load = new LoadTable();
		load.load(table, ds, model);
		for (int i = 0; i < button.length; i++) {
			dao.addbtn(table, button[i]);
		}
		table.revalidate();
		table.repaint();
	}

	public ProfessionalList(ShowDoctors owner) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ProfessionalList.class.getResource("/images/f68d7f35b7d0538e0ac1.jpg")));
		setBounds(100, 100, 522, 312);
		getContentPane().setLayout(null);
		setTitle("Professional List");
		setModal(true);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				String[] name = { String.valueOf(table.getValueAt(row, 1)) };
				Professional item = new Professional();
				item = dao.getPro("getProByname", name);
				int id = item.getid();
				String colname = table.getColumnName(col);
				if (colname == "Update") {
					UpdateProfessional up = new UpdateProfessional(ProfessionalList.this, id);
					up.setVisible(true);
				}
				if (colname == "Delete") {
					int check = JOptionPane.showConfirmDialog(getParent(), "Delete professional", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (check == JOptionPane.YES_OPTION) {
						String[] doc_id = { String.valueOf(id) };
						dao.Action("doc_pro_deletePro", doc_id);
						dao.Action("pro_delete", doc_id);
						load("getProByname", "%" + "" + "%");
						owner.revalidate();
						owner.repaint();
					}
				}
				if (colname == "Search") {
					owner.pro_search("doc_pro_search", String.valueOf(id));
					dispose();
				}
			}
		});
		table.setBounds(30, 40, 500, 400);
		table.setRowHeight(30);

		load("getProByname", "%" + "" + "%");
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 36, 413, 213);
		getContentPane().add(scrollPane);
	}
}
