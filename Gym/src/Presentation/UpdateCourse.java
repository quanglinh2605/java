package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.CategoryDAO;
import Models.Course;
import Models.Courses;

public class UpdateCourse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtNumdays;
	private JTextField txtWeekdays;
	private CategoryDAO dao = new CategoryDAO();
	private Courses dscourse = new Courses();
	private JOptionPane jop;

	public void load(int id) {
		dao.GetCourseById(id);
		dscourse = dao.getdscourse();
		for (Course course : dscourse) {
			txtName.setText(course.getname());
			txtPrice.setText(String.valueOf(course.getprice()));
			txtNumdays.setText(String.valueOf(course.getnumdays()));
			txtWeekdays.setText(String.valueOf(course.getweekdays()));
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateCourse(JPanel owner, int id) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setTitle("Update Course");
		setModal(true);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 14, 160, 14);
		contentPanel.add(lblName);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 61, 160, 14);
		contentPanel.add(lblPrice);

		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfDays.setBounds(10, 107, 160, 14);
		contentPanel.add(lblNumberOfDays);

		JLabel lblDaysAWeek = new JLabel("Days a week");
		lblDaysAWeek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDaysAWeek.setBounds(10, 159, 160, 14);
		contentPanel.add(lblDaysAWeek);

		txtName = new JTextField();
		txtName.setBounds(180, 11, 244, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(180, 60, 244, 20);
		contentPanel.add(txtPrice);

		txtNumdays = new JTextField();
		txtNumdays.setColumns(10);
		txtNumdays.setBounds(180, 106, 244, 20);
		contentPanel.add(txtNumdays);

		txtWeekdays = new JTextField();
		txtWeekdays.setColumns(10);
		txtWeekdays.setBounds(180, 158, 244, 20);
		contentPanel.add(txtWeekdays);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String price = txtPrice.getText();
				String numdays = txtNumdays.getText();
				String weekdays = txtWeekdays.getText();
				boolean numberic = true;
				String regex = "\\d+";
				double num = 0;
				try {
					num = Double.valueOf(price);
				} catch (Exception err) {
					numberic = false;
				}
				if (name.equals("") || price.equals("") || numdays.equals("") || weekdays.equals("")) {
					jop = new JOptionPane();
					jop.showMessageDialog(UpdateCourse.this, "Please fill in all the form!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!numberic || !numdays.matches(regex) || !weekdays.matches(regex) || num <= 0) {
						jop = new JOptionPane();
						jop.showMessageDialog(UpdateCourse.this, "Try again!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if (Integer.valueOf(weekdays) > 7) {
							jop = new JOptionPane();
							jop.showMessageDialog(UpdateCourse.this, "A week have 7 days try again!", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							dao.UpdateCourse(name, num, Integer.valueOf(numdays), Integer.valueOf(weekdays), id);
							jop = new JOptionPane();
							jop.showMessageDialog(UpdateCourse.this, "Update success!", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}

					}
				}
			}
		});
		btnUpdate.setBounds(10, 216, 89, 23);
		contentPanel.add(btnUpdate);
		load(id);
	}
}
