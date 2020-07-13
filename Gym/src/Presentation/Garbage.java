package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Business.CategoryBusiness;
import Dao.CategoryDAO;
import Models.Course;
import Models.Courses;
import Models.Trainer;
import Models.Trainers;

public class Garbage extends JPanel {
	private JTextField txtSearch;
	private JTable table;
	private JTextField txtSearch1;
	private JTable table1;
	private CategoryBusiness buss = new CategoryBusiness();
	private Object[] TrainerColumn = { "STT", "Name", "Phone", "Salary", "Delete" };
	private Object[] CourseColumn = { "STT", "Name", "Price", "Total days", "Days a week", "Delete" };
	private Trainers dstrainer = new Trainers();
	private DefaultTableModel modelTrainer;
	private Courses dscourse = new Courses();
	private DefaultTableModel modelCourse;

	private int inrow;
	private int incolumn;
	private CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the panel.
	 */
	public void addbtn(JTable table, int column) {
		table.getColumnModel().getColumn(column).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(column).setCellEditor(new ButtonEditor(new JTextField()));
	}

	public void TrainerReload() {
		buss.GetGarbageTrainer();
		dstrainer = buss.getdstrainer();
		int stt = 0;
		modelTrainer = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5;
			}
		};
		modelTrainer.setColumnIdentifiers(TrainerColumn);
		for (Trainer train : dstrainer) {
			stt++;
			Object[] row = new Object[5];
			row[0] = stt;
			row[1] = train.getname();
			row[2] = train.getnumberphone();
			row[3] = train.getsalary();
			row[4] = "Delete";
			modelTrainer.addRow(row);
		}
		table.setModel(modelTrainer);
		table.revalidate();
		table.repaint();
	}

	public int getid(int index, String title) {
		int count = 0;
		String name = txtSearch.getText();
		switch (title) {
		case "course":
			buss.SearchGarbage(name, "course");
			dscourse = buss.getdscourse();
			for (Course course : dscourse) {
				if (count == index) {
					return course.getid();
				}
				count++;
			}
			return 0;
		case "trainer":
			buss.SearchGarbage(name, "trainer");
			dstrainer = buss.getdstrainer();
			for (Trainer train : dstrainer) {
				if (count == index) {
					return train.getid();
				}
				count++;
			}
			return 0;
		default:
			return 0;
		}

	}

	public void Search(String name, String panel) {
		int stt = 0;
		switch (panel) {
		case "trainer":
			buss.SearchGarbage(name, panel);
			modelTrainer = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 5;
				}
			};
			modelTrainer.setColumnIdentifiers(TrainerColumn);
			dstrainer = buss.getdstrainer();
			for (Trainer train : dstrainer) {
				stt++;
				Object[] row = new Object[5];
				row[0] = stt;
				row[1] = train.getname();
				row[2] = train.getnumberphone();
				row[3] = train.getsalary();
				row[4] = "Delete";
				modelTrainer.addRow(row);
			}
			table.setModel(modelTrainer);
			table.revalidate();
			table.repaint();
			break;
		case "course":
			buss.SearchGarbage(name, panel);
			dscourse = buss.getdscourse();
			modelCourse = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 6;
				}
			};
			modelCourse.setColumnIdentifiers(CourseColumn);
			for (Course course : dscourse) {
				stt++;
				Object[] row = new Object[6];
				row[0] = stt;
				row[1] = course.getname();
				row[2] = course.getprice();
				row[3] = course.getnumdays();
				row[4] = course.getweekdays();
				row[5] = "Delete";
				modelCourse.addRow(row);
			}
			table1.setModel(modelCourse);
			table1.revalidate();
			table1.repaint();
			break;
		default:
			break;
		}
	}

	public void CourseReload() {
		buss.GetGarbageCourse();
		dscourse = buss.getdscourse();
		int stt = 0;
		modelCourse = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 6;
			}
		};
		modelCourse.setColumnIdentifiers(CourseColumn);
		for (Course course : dscourse) {
			stt++;
			Object[] row = new Object[6];
			row[0] = stt;
			row[1] = course.getname();
			row[2] = course.getprice();
			row[3] = course.getnumdays();
			row[4] = course.getweekdays();
			row[5] = "Delete";
			modelCourse.addRow(row);
		}
		table1.setModel(modelCourse);
		table1.revalidate();
		table1.repaint();
	}

	public Garbage(JLabel owner) {
		setBounds(150, 50, 790, 411);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 11, 740, 322);

		JPanel panelTrainer = new JPanel();
		tabbedPane.addTab("Trainer", null, panelTrainer, null);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inrow = table.getSelectedRow();
				incolumn = table.getSelectedColumn();
				String title = table.getColumnName(incolumn);
				int id = getid(inrow, "trainer");
				if (title.equals("Delete")) {
					int rep = JOptionPane.showConfirmDialog(Garbage.this, "Are you sure?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						dao.Delete(id, "trainer");

						Search(txtSearch.getText(), "trainer");
						addbtn(table, 4);
					}
				}
			}
		});
		table.setRowHeight(30);

		setLayout(null);
		TrainerReload();
		addbtn(table, 4);
		scrollPane.setViewportView(table);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				String name = txtSearch.getText();
				Search(name, "trainer");
				addbtn(table, 4);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String name = txtSearch.getText();
				Search(name, "trainer");
				addbtn(table, 4);
			}
		});
		txtSearch.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panelTrainer = new GroupLayout(panelTrainer);
		gl_panelTrainer.setHorizontalGroup(gl_panelTrainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTrainer.createSequentialGroup().addContainerGap(295, Short.MAX_VALUE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(36)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE).addGap(10))
				.addGroup(gl_panelTrainer.createSequentialGroup().addGap(10).addComponent(scrollPane).addGap(15)));
		gl_panelTrainer.setVerticalGroup(gl_panelTrainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTrainer.createSequentialGroup().addGap(11)
						.addGroup(gl_panelTrainer.createParallelGroup(Alignment.LEADING, false).addComponent(lblName)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addGap(11)));
		panelTrainer.setLayout(gl_panelTrainer);

		JPanel panelCourse = new JPanel();
		tabbedPane.addTab("Course", null, panelCourse, null);

		JScrollPane scrollPane1 = new JScrollPane();

		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inrow = table1.getSelectedRow();
				incolumn = table1.getSelectedColumn();
				String title = table1.getColumnName(incolumn);
				int id = getid(inrow, "course");
				if (title.equals("Delete")) {
					int rep = JOptionPane.showConfirmDialog(Garbage.this, "Are you sure?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (rep == JOptionPane.YES_OPTION) {
						dao.Delete(id, "course");
						Search(txtSearch1.getText(), "course");
						addbtn(table1, 5);
					}
				}
			}
		});
		table1.setRowHeight(30);
		CourseReload();
		addbtn(table1, 5);
		scrollPane1.setViewportView(table1);

		txtSearch1 = new JTextField();
		txtSearch1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				String name = txtSearch1.getText();
				Search(name, "course");
				addbtn(table1, 5);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String name = txtSearch1.getText();
				Search(name, "course");
				addbtn(table1, 5);
			}
		});
		txtSearch1.setColumns(10);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panelCourse = new GroupLayout(panelCourse);
		gl_panelCourse.setHorizontalGroup(gl_panelCourse.createParallelGroup(Alignment.LEADING).addGroup(gl_panelCourse
				.createSequentialGroup()
				.addGroup(gl_panelCourse.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelCourse.createSequentialGroup().addContainerGap()
								.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addGap(32).addComponent(txtSearch1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCourse.createSequentialGroup().addGap(10).addComponent(scrollPane1,
								GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
				.addGap(10)));
		gl_panelCourse.setVerticalGroup(gl_panelCourse.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCourse.createSequentialGroup().addGap(11)
						.addGroup(gl_panelCourse.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGap(11).addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addGap(11)));
		panelCourse.setLayout(gl_panelCourse);
		add(tabbedPane);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.removeAll();
				owner.revalidate();
				owner.repaint();
			}
		});
		btnClose.setBounds(659, 363, 89, 23);
		add(btnClose);
	}
}