package app;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import models.dsProduct;
import repositories.ProBusiness;

public class jtable extends JFrame {
	private JTable table;
	private JPanel contentPane;
	dsProduct ds = new dsProduct();
	public static int idPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jtable frame = new jtable();
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
	public jtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		table = new JTable();

		table.setBounds(30, 40, 200, 300);
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Only the third column
				return column == 4;
			}
		};
		Object[] columnsname = new Object[5];
		columnsname[0] = "id";
		columnsname[1] = "name";
		columnsname[2] = "price";
		columnsname[3] = "quantity";
		columnsname[4] = "Action";
		model.setColumnIdentifiers(columnsname);
		ds = ProBusiness.GetAll();
		Object[] rowData = new Object[5];
		for (int i = 0; i < ds.size(); i++) {
			rowData[0] = ds.get(i).getid();
			rowData[1] = ds.get(i).getname();
			rowData[2] = ds.get(i).getprice();
			rowData[3] = ds.get(i).getquantity();
			rowData[4] = "delete";
			model.addRow(rowData);
		}
		contentPane.setLayout(null);
		table.setModel(model);
		/*
		 * TextArea = (JTextArea) table.getEditorComponent();
		 * TextArea.setEditable(false);
		 */

		table.setCellSelectionEnabled(true);
		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String data = null;
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				data = (String) String.valueOf(table.getValueAt(row, column));
				String columnname = table.getModel().getColumnName(table.getSelectedColumn());
				if (columnname != "Action") {

				}
			}
		});
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(22, 11, 382, 227);
		contentPane.add(sp);
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
		private String label;
		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				idPro = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				deleteRow dr = new deleteRow(jtable.this);
				dr.setVisible(true);
			}
			isPushed = false;
			return label;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}
	}
}
