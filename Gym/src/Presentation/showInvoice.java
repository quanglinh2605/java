package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.CategoryDAO;
import Models.Invoice;
import Models.Invoices;
import Models.Member_Course_List;

public class showInvoice extends JPanel {
	private JTable table;
	Invoices dsInv = new Invoices();
	DefaultTableModel model = new DefaultTableModel();
	CategoryDAO dao = new CategoryDAO();
	private JTextField tfName;
	Object[] columnames = { "ID", "Course", "Name", "Price", "Pay", "PayDate" };
	Member_Course_List dsMC = new Member_Course_List();

	/**
	 * Create the panel.
	 */
	public void Search(String name) {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		model.setColumnIdentifiers(columnames);
		dsInv = dao.getInvoiceByName(name);
		for (Invoice i : dsInv) {
			String paid;
			if (i.getpay()) {
				paid = "Paid";
			} else
				paid = "Not paid";
			Object[] rowdata = { i.getmembercourseid().getid(), i.getmembercourseid().getcourseid().getname(),
					i.getmembercourseid().getmemberid().getname(), i.getmembercourseid().getprice(), paid,
					i.getpaydate() };
			model.addRow(rowdata);
			revalidate();
			repaint();
		}
		table.setModel(model);
	}

	public showInvoice(JLabel owner) {
		setLayout(null);
		setBounds(230, 100, 636, 410);
		table = new JTable();
		table.setBounds(30, 40, 200, 300);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnames);
		dsInv = dao.getAllInv();
		for (Invoice i : dsInv) {
			String paid;
			if (i.getpay()) {
				paid = "Paid";
			} else
				paid = "Not paid";
			Object[] rowdata = { i.getmembercourseid().getid(), i.getmembercourseid().getcourseid().getname(),
					i.getmembercourseid().getmemberid().getname(), i.getmembercourseid().getprice(), paid,
					i.getpaydate() };
			model.addRow(rowdata);
			revalidate();
			repaint();
		}
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 75, 583, 243);
		add(scrollPane);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(203, 11, 69, 20);
		add(lblName);

		tfName = new JTextField();
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = tfName.getText();
				Search(name);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String name = tfName.getText();
				Search(name);
			}
		});
		tfName.setBounds(32, 11, 146, 20);
		add(tfName);
		tfName.setColumns(10);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(526, 353, 89, 23);
		add(btnClose);
	}
}
