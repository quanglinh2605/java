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

public class NewCourse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtNumdays;
	private JTextField txtWeekdays;
	private JOptionPane jop;
	private Dao.CategoryDAO dao = new CategoryDAO();
	private Courses dscourse = new Courses();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public NewCourse(ShowCourse owner) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnAdd = new JButton("Add");
			btnAdd.setBounds(10, 205, 89, 23);
			btnAdd.addActionListener(new ActionListener() {
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
						jop.showMessageDialog(NewCourse.this, "Please fill in all the form!", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (!numberic || !numdays.matches(regex) || !weekdays.matches(regex) || num <= 0) {
							jop = new JOptionPane();
							jop.showMessageDialog(NewCourse.this, "Try again!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							if (Integer.valueOf(weekdays) > 7) {
								jop = new JOptionPane();
								jop.showMessageDialog(NewCourse.this, "A week have 7 days try again!", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {

								dao.GetAllCourse(2);
								dscourse = dao.getdscourse();
								int count = 0;
								for (Course course : dscourse) {
									if (name.equals(course.getname())) {
										count++;
									}
								}
								if (count == 0) {
									Course c = new Course();
									c.setname(name);
									c.setprice(Double.valueOf(price));
									c.setnumdays(Integer.valueOf(numdays));
									c.setweekdays(Integer.valueOf(weekdays));
									dao.CreateCourse(c);
									jop = new JOptionPane();
									jop.showMessageDialog(NewCourse.this, "Course added!", "Success",
											JOptionPane.INFORMATION_MESSAGE);
									dispose();
								} else {
									jop = new JOptionPane();
									jop.showMessageDialog(NewCourse.this, "This course has already exist!", "Error",
											JOptionPane.ERROR_MESSAGE);
								}
							}

						}
					}
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(btnAdd);
		}

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 158, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 70, 158, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Number of days");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 116, 158, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Days a week");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 160, 158, 14);
		contentPanel.add(lblNewLabel_3);

		txtName = new JTextField();
		txtName.setBounds(178, 25, 246, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(178, 67, 246, 20);
		contentPanel.add(txtPrice);
		txtPrice.setColumns(10);

		txtNumdays = new JTextField();
		txtNumdays.setBounds(178, 113, 246, 20);
		contentPanel.add(txtNumdays);
		txtNumdays.setColumns(10);

		txtWeekdays = new JTextField();
		txtWeekdays.setBounds(178, 157, 246, 20);
		contentPanel.add(txtWeekdays);
		txtWeekdays.setColumns(10);
	}
}
