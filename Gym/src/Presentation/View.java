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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.CategoryDAO;
import Models.Member_Course;
import Models.Member_Course_List;
import implement.ButtonEditor;
import implement.ButtonRenderer;

public class View extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private JTable table;
	private Object[] column = { "STT", "Course", "Trainer", "Startdate", "Endate", "Price", "Update" };
	private Member_Course_List dsmemcourse = new Member_Course_List();
	private DefaultTableModel model;
	private CategoryDAO dao = new CategoryDAO();

	/**
	 * Create the View dialog.
	 * 
	 * @author Giang
	 */
	public void addbtn() {
		table.getColumn("Update").setCellRenderer(new ButtonRenderer());
		table.getColumn("Update").setCellEditor(new ButtonEditor(new JTextField()));
	}

	public int getid(int index, int id) {
		int count = 0;

		String name = txtSearch.getText();
		dao.GetMemberCourseByMemIdAndName(name, id);
		dsmemcourse = dao.getdsmemcourse();
		for (Member_Course mc : dsmemcourse) {
			if (count == index) {
				return mc.getid();
			}
			count++;
		}
		return 0;
	}

	public void search(String name, int id) {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column == 6;
			}
		};
		model.setColumnIdentifiers(column);
		dao.GetMemberCourseByMemIdAndName(name, id);
		dsmemcourse = dao.getdsmemcourse();
		int stt = 0;
		for (Member_Course mc : dsmemcourse) {
			stt++;
			Object[] row = new Object[7];
			row[0] = stt;
			row[1] = mc.getcourseid().getname();
			row[2] = mc.gettrainerid().getname();
			row[3] = mc.getStartdate();
			row[4] = mc.getEnddate();
			row[5] = mc.getprice();
			row[6] = "Update";
			model.addRow(row);
		}
		table.setModel(model);
		addbtn();
		table.revalidate();
		table.repaint();
	}

	public void load(int id) {
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column == 6;
			}
		};
		model.setColumnIdentifiers(column);
		dao.GetMemberCourseBymemid(id);
		dsmemcourse = dao.getdsmemcourse();
		int stt = 0;
		for (Member_Course mc : dsmemcourse) {
			stt++;
			Object[] row = new Object[7];
			row[0] = stt;
			row[1] = mc.getcourseid().getname();
			row[2] = mc.gettrainerid().getname();
			row[3] = mc.getStartdate();
			row[4] = mc.getEnddate();
			row[5] = mc.getprice();
			row[6] = "Update";
			model.addRow(row);
		}
		table.setModel(model);
		addbtn();
		table.revalidate();
		table.repaint();
	}

	public View(int id, int empid) {
		setBounds(100, 100, 900, 600);
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(contentPanel,
				GroupLayout.PREFERRED_SIZE, 884, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE).addGap(0)));

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = txtSearch.getText();
				search(name, id);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String name = txtSearch.getText();
				search(name, id);
			}
		});
		txtSearch.setColumns(10);

		JLabel lblNewLabel = new JLabel("Filter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewCourse = new JButton("New Course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMemberCourse nmc = new NewMemberCourse(id, empid);
				nmc.setVisible(true);
			}
		});

		JButton btnClose = new JButton("Close");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(btnNewCourse)
										.addPreferredGap(ComponentPlacement.RELATED, 706, Short.MAX_VALUE)
										.addComponent(btnClose))
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGap(8)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblNewLabel).addGap(15)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE).addGap(29)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(btnNewCourse)
								.addComponent(btnClose))
						.addContainerGap()));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int inrow = table.getSelectedRow();
				int incolumn = table.getSelectedColumn();
				String title = table.getColumnName(incolumn);
				if (title.equals("Update")) {
					UpdateMemberCourse umc = new UpdateMemberCourse(getid(inrow, id), empid);
					umc.setVisible(true);
					search(txtSearch.getText(), id);
				}
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
		load(id);
	}
}
