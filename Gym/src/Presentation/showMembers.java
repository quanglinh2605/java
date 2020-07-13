package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.CategoryDAO;
import Models.Member;
import Models.Members;

public class showMembers extends JPanel {
	private JTable table;
	private JTextField tfName;
	CategoryDAO dao = new CategoryDAO();
	Members dsMem = new Members();
	Object[] columnNames = { "Id", "Name", "Phone", "Action", "Show" };
	public static int count;
	public static String data = "";
	DefaultTableModel model;

	public void addbtn() {
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonEditor(new JTextField()));
		table.getColumn("Show").setCellRenderer(new ButtonRenderer());
		table.getColumn("Show").setCellEditor(new ButtonEditor(new JTextField()));
	}

	public void Search() {
		String name = tfName.getText();
		dsMem = dao.getMembyName(name);
		DefaultTableModel models = new DefaultTableModel();
		models.setColumnIdentifiers(columnNames);
		Object[] row = new Object[5];
		for (Member c : dsMem) {
			row[0] = c.getid();
			row[1] = c.getname();
			row[2] = c.getnumPhone();
			row[3] = "Update";
			row[4] = "View";
			models.addRow(row);
			revalidate();
			repaint();
		}
		table.setModel(models);
		addbtn();
	}

	public void loadTable() {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column >= 4;
			}
		};
		model.setColumnIdentifiers(columnNames);
		dsMem = new Members();
		dao.getAllMem();
		dsMem = dao.getdsMem();
		count = 0;
		Object[] row = new Object[5];
		for (Member c : dsMem) {
			count++;
			row[0] = String.valueOf(count);
			row[1] = c.getname();
			row[2] = c.getnumPhone();
			row[3] = "Update";
			row[4] = "View";
			model.addRow(row);
			table.revalidate();
			table.repaint();
		}
		table.setModel(model);
		addbtn();
	}

	public int getId(int index) {
		int count = 0;
		for (Member mem : dsMem) {
			if (count == index) {
				return mem.getid();
			}
			count++;
		}
		return 0;
	}

	/**
	 * Create the panel.
	 */
	public showMembers(JLabel owner, int empid) {

		setBounds(150, 50, 790, 473);
		setLayout(null);

		table = new JTable();
		table.setBounds(30, 40, 200, 300);
		loadTable();
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String colname = table.getColumnName(column);
				data = (String) String.valueOf(table.getValueAt(row, 0));
				int id = getId(row);
				if (colname.equals("Action")) {
					UpdateMem um = new UpdateMem(showMembers.this);
					um.setVisible(true);
				}
				if (colname.equals("Show")) {
					View v = new View(id, empid);
					v.setVisible(true);
				}
			}
		});
		scrollPane.setBounds(27, 97, 445, 223);
		add(scrollPane);

		tfName = new JTextField();
		tfName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Search();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Search();
			}
		});

		tfName.setBounds(27, 50, 159, 22);
		add(tfName);
		tfName.setColumns(10);

		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMem nm = new NewMem(showMembers.this);
				nm.setVisible(true);
			}
		});
		btnAddMember.setBounds(261, 343, 112, 23);
		add(btnAddMember);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(383, 343, 89, 23);
		add(btnClose);

		JLabel lblMemberName = new JLabel("Member name");
		lblMemberName.setBounds(27, 11, 89, 23);
		add(lblMemberName);
	}
}
