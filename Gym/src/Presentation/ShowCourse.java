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
import Models.Course;
import Models.Courses;

public class ShowCourse extends JPanel {
	private JTable table;
	private CategoryDAO dao = new CategoryDAO();
	private Courses dscourse = new Courses();
	private JTextField txtSearch;
	private DefaultTableModel model;
	private Object[] column = { "STT", "Name", "Price", "Number of days", "Days a week", "Update", "Delete" };

	private boolean check = false;
	private int inrow;
	private String title;
	private int incolumn;

	/**
	 * Create the panel.
	 */
	public void addbtn() {
		table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));
	}

	public void reload() {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column > 4;
			}
		};

		model.setColumnIdentifiers(column);
		dao.GetAllCourse(2);
		dscourse = dao.getdscourse();
		int stt = 0;
		for (Course c : dscourse) {
			stt++;
			Object[] row = new Object[7];
			row[0] = String.valueOf(stt);
			row[1] = c.getname();
			row[2] = String.valueOf(c.getprice());
			row[3] = String.valueOf(c.getnumdays());
			row[4] = String.valueOf(c.getweekdays());
			row[5] = "Update";
			row[6] = "Delete";
			model.addRow(row);
		}
		table.setModel(model);
		check = false;
		table.revalidate();
		table.repaint();
	}

	/**
	 * Search by course's name new an object table models
	 */
	public void search() {
		String name = txtSearch.getText();
		if (!name.equals("")) {
			dao.GetCourseByName(name, 2);
			dscourse = dao.getdscourse();
			DefaultTableModel models = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return column > 4;
				}
			};
			models.setColumnIdentifiers(column);

			int stt = 0;
			for (Course course : dscourse) {
				stt++;

				Object[] row = new Object[7];
				row[0] = String.valueOf(stt);
				row[1] = course.getname();
				row[2] = String.valueOf(course.getprice());
				row[3] = String.valueOf(course.getnumdays());
				row[4] = String.valueOf(course.getweekdays());
				row[5] = "Update";
				row[6] = "Delete";
				models.addRow(row);
				revalidate();
				repaint();
			}

			table.setModel(models);
			check = true;
			table.revalidate();
			table.repaint();
		} else {
			reload();
			addbtn();
		}
	}

	public int getid(int index) {
		int count = 0;
		if (check) {
			String name = txtSearch.getText();
			dao.GetCourseByName(name, 2);
			dscourse = dao.getdscourse();
			for (Course course : dscourse) {
				if (count == index) {
					return course.getid();
				}
				count++;
			}
			return 0;
		} else {
			dao.GetAllCourse(2);
			;
			dscourse = dao.getdscourse();
			for (Course course : dscourse) {
				if (count == index) {
					return course.getid();
				}
				count++;
			}
			return 0;
		}
	}

	public ShowCourse(JLabel owner) {
		setBounds(150, 50, 790, 473);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 769, 333);
		add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inrow = table.getSelectedRow();
				incolumn = table.getSelectedColumn();
				title = table.getColumnName(incolumn);
				int id = getid(inrow);
				if (title.equals("Update")) {
					UpdateCourse uc = new UpdateCourse(ShowCourse.this, id);
					uc.setVisible(true);
					if (check) {
						search();
						addbtn();
					} else {
						reload();
						addbtn();
					}
				} else if (title.equals("Delete")) {
					int rep = JOptionPane.showConfirmDialog(ShowCourse.this, "Are you sure?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						dao.DeleteCourse(id);
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
		table.setRowHeight(30);
		reload();
		addbtn();
		scrollPane.setViewportView(table);

		/**
		 * New Course
		 */
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCourse nc = new NewCourse(ShowCourse.this);
				nc.setVisible(true);
				if (check) {
					search();
					addbtn();
				} else {
					reload();
					addbtn();
				}
			}
		});
		btnNew.setBounds(10, 444, 89, 23);
		add(btnNew);

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
		txtSearch.setBounds(10, 33, 147, 23);
		add(txtSearch);
		txtSearch.setColumns(10);
		/**
		 * close JPanel
		 */
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(690, 444, 89, 23);
		add(btnClose);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName.setBounds(10, 11, 147, 14);
		add(lblCourseName);
	}
}