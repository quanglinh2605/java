package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.CategoryDAO;
import Models.Trainer;
import Models.Trainers;

public class ShowTrainer extends JPanel {
	private CategoryDAO dao = new CategoryDAO();
	private Trainers trs = new Trainers();
	private DefaultTableModel model;
	private Object[] column = { "STT", "Name", "Phone", "Salary", "Update", "Delete" };

	private int inrow;
	private String title;
	private int incolumn;
	private JTextField txtSearch;
	private JTable tableTrainer;
	private boolean check = false;

	/**
	 * Create the panel.
	 */

	/*
	 * restart new table
	 */
	public void reload() {

		dao.GetAllTrainer(2);
		trs = dao.getdstrainer();
		int stt = 0;
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column > 3;
			}
		};
		model.setColumnIdentifiers(column);
		for (Trainer train : trs) {
			stt++;
			Object[] row = new Object[6];
			row[0] = String.valueOf(stt);
			row[1] = train.getname();
			row[2] = train.getnumberphone();
			row[3] = String.valueOf(train.getsalary());
			row[4] = "Update";
			row[5] = "Delete";
			model.addRow(row);
		}

		tableTrainer.setModel(model);
		check = false;
		revalidate();
		repaint();
	}

	public void search() {
		String name = txtSearch.getText();
		int stt = 0;
		if (name != "") {
			dao.GetTrainerByName(name, 2);
			trs = dao.getdstrainer();
			tableTrainer.removeAll();
			DefaultTableModel models = new DefaultTableModel() {
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return column > 3;
				}
			};
			models.setColumnIdentifiers(column);
			for (Trainer train : trs) {
				stt++;
				Object[] row = new Object[7];
				row[0] = String.valueOf(stt);
				row[1] = train.getname();
				row[2] = train.getnumberphone();
				row[3] = String.valueOf(train.getsalary());
				row[4] = "Update";
				row[5] = "Delete";
				models.addRow(row);
			}

			tableTrainer.setModel(models);
			check = true;
			revalidate();
			repaint();
		}
	}

	public int getid(int index) {
		int count = 0;
		if (check) {
			String name = txtSearch.getText();
			dao.GetTrainerByName(name, 2);
			trs = dao.getdstrainer();
			for (Trainer train : trs) {
				if (count == index) {
					return train.getid();
				}
				count++;
			}
			return 0;
		} else {
			dao.GetAllTrainer(2);
			trs = dao.getdstrainer();
			for (Trainer train : trs) {
				if (count == index) {
					return train.getid();
				}
				count++;
			}
			return 0;
		}
	}

	/*
	 * Search by trainer's name new an object table models
	 */
	public void addbtn() {
		tableTrainer.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		tableTrainer.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
		tableTrainer.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		tableTrainer.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
	}

	public ShowTrainer(JLabel owner) {
		super();
		setBounds(150, 50, 790, 473);
		setLayout(null);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				search();
				addbtn();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				search();
				addbtn();
			}
		});
		txtSearch.setBounds(10, 36, 128, 20);
		add(txtSearch);
		txtSearch.setColumns(10);

		JLabel Filter = new JLabel("Trainer Name");
		Filter.setFont(new Font("Tahoma", Font.BOLD, 14));
		Filter.setBounds(10, 11, 128, 14);
		add(Filter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 769, 323);
		add(scrollPane);

		tableTrainer = new JTable();
		tableTrainer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inrow = tableTrainer.getSelectedRow();
				incolumn = tableTrainer.getSelectedColumn();
				title = tableTrainer.getColumnName(incolumn);
				int id = getid(inrow);
				if (title.equals("Update")) {
					UpdateTrainer ut = new UpdateTrainer(ShowTrainer.this, id);
					ut.setVisible(true);
					if (check) {
						search();
						addbtn();
					} else {
						reload();
						addbtn();
					}
				} else if (title.equals("Delete")) {
					int rep = JOptionPane.showConfirmDialog(ShowTrainer.this, "Are you sure?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						dao.DeleteTrainer(id);
						if (check) {
							search();
							addbtn();
						} else {
							reload();
							addbtn();
						}
					}
				}
			}
		});
		tableTrainer.setRowHeight(30);
		scrollPane.setViewportView(tableTrainer);

		JButton btnClose = new JButton("CLose");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(690, 432, 89, 23);
		add(btnClose);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTrainers t = new NewTrainers(ShowTrainer.this);
				t.setVisible(true);
				if (check) {
					search();
					addbtn();
				} else {
					reload();
					addbtn();
				}
			}
		});
		btnNew.setBounds(10, 432, 89, 23);
		add(btnNew);
		reload();
		addbtn();
		setVisible(true);
	}
}
