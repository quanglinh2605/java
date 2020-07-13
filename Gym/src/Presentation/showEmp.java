package Presentation;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Dao.CategoryDAO;
import Models.Emp;
import Models.Emps;

public class showEmp extends JPanel {
	private JTextField tfName;
	private JButton btnAdd;
	private JButton btnClose;
	private JTable table;
	Object[] columnNames = { "Id", "Name", "UserName", "type", "Action", "ResetPassword" };
	CategoryDAO dao = new CategoryDAO();
	DefaultTableModel model;
	Emps dsEmp = new Emps();
	public static String data = "";

	/**
	 * Create the panel.
	 */
	public void addbtn() {
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonEditor(new JTextField()));
		table.getColumn("ResetPassword").setCellRenderer(new ButtonRenderer());
		table.getColumn("ResetPassword").setCellEditor(new ButtonEditor(new JTextField()));
	}

	public void Search() {
		String name = tfName.getText();
		dsEmp = dao.getEmpbyName(name);
		DefaultTableModel models = new DefaultTableModel();
		models.setColumnIdentifiers(columnNames);
		for (Emp item : dsEmp) {
			Object[] rowdata = { String.valueOf(item.getid()), item.getName(), item.getUserName(), item.getemptype(),
					"Update", "Reset" };
			models.addRow(rowdata);
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
				return column >= 5;
			}
		};
		model.setColumnIdentifiers(columnNames);
		dsEmp = dao.getAllEmp();
		int count = 0;
		for (Emp item : dsEmp) {
			count++;
			Object[] rowdata = { String.valueOf(count), item.getName(), item.getUserName(), item.getemptype(), "Update",
					"Reset" };
			model.addRow(rowdata);
			revalidate();
			repaint();
		}
		table.setModel(model);
		addbtn();
	}

	public showEmp(JLabel owner) {
		setLayout(null);
		setBounds(230, 100, 636, 410);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String colname = table.getColumnName(column);
				data = (String) String.valueOf(table.getValueAt(row, 0));
				if (colname.equals("Action")) {
					UpdateEmp ue = new UpdateEmp(showEmp.this);
					ue.setVisible(true);
				} else if (colname.equals("ResetPassword")) {
					int rep = JOptionPane.showConfirmDialog(showEmp.this, "Confirm Resetpassword", "Reset",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						Emp item = new Emp();
						item = dao.getEmpbyId(data);
						try {
							boolean kq = dao.resetPass(item);
							if (kq) {
								Search();
								JOptionPane.showMessageDialog(getParent(), "Reset Successful");
							}
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
					}
				} else {
					loadTable();
				}
			}
		});
		table.setBounds(30, 40, 200, 300);
		loadTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 88, 567, 240);
		add(scrollPane);

		JLabel lblEmployee = new JLabel("Employee Name");
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployee.setBounds(35, 11, 116, 26);
		add(lblEmployee);

		tfName = new JTextField();
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Search();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Search();
			}
		});
		tfName.setBounds(35, 51, 154, 26);
		add(tfName);
		tfName.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewEmp ne = new NewEmp(showEmp.this);
				ne.setVisible(true);
			}
		});
		btnAdd.setBounds(403, 354, 89, 23);
		add(btnAdd);

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(513, 354, 89, 23);
		add(btnClose);
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText((value == null) ? "" : value.toString());
		return this;
	}
}

class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	public ButtonEditor(JTextField checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);

	}
}