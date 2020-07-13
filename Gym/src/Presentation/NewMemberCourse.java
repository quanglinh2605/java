package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.CategoryDAO;
import Models.Course;
import Models.Courses;
import Models.Emp;
import Models.Invoice;
import Models.Member;
import Models.Member_Course;
import Models.Trainer;
import Models.Trainers;

public class NewMemberCourse extends JDialog {
	private JTextField txtPrice;
	private JTextField txtNumdays;
	private Courses dscourse = new Courses();
	private Trainers dstrainer = new Trainers();
	private CategoryDAO dao = new CategoryDAO();
	private JComboBox cbCourse;
	private JComboBox cbTrainer;
	private int courseid = 0;
	private int year = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")).get(Calendar.YEAR);
	private JTextField txtDate;
	private int trainerid = 0;
	private JTextField txtEnddate;
	private JComboBox cbPay;
	private boolean pay = false;

	public void Course() {
		dao.GetAllCourse(2);
		dscourse = dao.getdscourse();
	}

	public void Trainer() {
		dao.GetAllTrainer(2);
		dstrainer = dao.getdstrainer();
	}

	public NewMemberCourse(int id, int empid) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 300);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Course");
		lblNewLabel.setBounds(53, 15, 77, 20);
		panel.add(lblNewLabel);
		Course();
		Trainer();
		cbCourse = new JComboBox();
		cbCourse.setBounds(130, 11, 221, 22);

		panel.add(cbCourse);
		for (Models.Course course : dscourse) {
			cbCourse.addItem(course.getname());
		}
		cbCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object select = cbCourse.getSelectedItem();
				for (Course course : dscourse) {
					if (select.toString().equals(course.getname())) {
						courseid = course.getid();
						txtPrice.setText(String.valueOf(course.getprice()));
					}
				}
			}
		});
		JLabel lblTrainer = new JLabel("Trainer");
		lblTrainer.setBounds(53, 43, 77, 20);
		panel.add(lblTrainer);

		cbTrainer = new JComboBox();
		cbTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object select = cbTrainer.getSelectedItem();
				for (Trainer train : dstrainer) {
					if (select.toString().equals(train.getname())) {
						trainerid = train.getid();
					}
				}
			}
		});
		cbTrainer.setBounds(130, 39, 221, 22);
		panel.add(cbTrainer);
		for (Trainer train : dstrainer) {
			cbTrainer.addItem(train.getname());
		}
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(53, 70, 77, 20);
		panel.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setBounds(130, 67, 221, 20);
		txtPrice.setEditable(false);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Start date");
		lblNewLabel_1.setBounds(53, 95, 77, 20);
		panel.add(lblNewLabel_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String price = txtPrice.getText();
				String start = txtDate.getText();
				String end = txtEnddate.getText();
				if (courseid == 0 || trainerid == 0 || price.equalsIgnoreCase("") || start.equalsIgnoreCase("")
						|| end.equalsIgnoreCase("") || empid == 0 || id == 0) {
					JOptionPane.showMessageDialog(NewMemberCourse.this, "Please fill all the forms", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Member mem = new Member();
					mem = dao.getMembyId(String.valueOf(id));
					Course c = new Course();
					c = dao.GetCourseById(courseid);
					Trainer t = new Trainer();
					t = dao.GetTrainerById(trainerid);
					Emp emp = new Emp();
					emp = dao.getEmpbyId(String.valueOf(empid));
					Member_Course mc = new Member_Course();
					mc.setmemberid(mem);
					mc.setcourseid(c);
					mc.setempid(emp);
					mc.settrainerid(t);
					mc.setStartdate(start);
					mc.setEnddate(end);
					mc.setprice(Double.valueOf(price));
					long membercourseid = dao.NewMemCourse(mc);
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String paydate = String.valueOf(d.format(cal.getTime()));
					Invoice i = new Invoice();
					i.setmembercourseid(dao.GetMemberCourseById(Integer.valueOf(String.valueOf(membercourseid))));
					i.setpay(pay);
					if (pay) {
						i.setpaydate(paydate);
					}
					dao.NewInvoice(i);
					dispose();
				}
			}
		});
		btnAdd.setBounds(53, 205, 77, 23);
		panel.add(btnAdd);
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setBounds(130, 92, 191, 20);
		panel.add(txtDate);
		txtDate.setColumns(10);

		JButton btngetdate = new JButton("");
		btngetdate.setIcon(new ImageIcon(NewMemberCourse.class.getResource("/img/calendar.png")));
		btngetdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymCalendar gc = new GymCalendar(txtDate);
				gc.setVisible(true);
			}
		});
		btngetdate.setBounds(318, 92, 33, 20);
		panel.add(btngetdate);

		txtEnddate = new JTextField();
		txtEnddate.setEditable(false);
		txtEnddate.setBounds(130, 117, 191, 20);
		panel.add(txtEnddate);
		txtEnddate.setColumns(10);

		JButton btnend = new JButton("");
		btnend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymCalendar gc = new GymCalendar(txtEnddate);
				gc.setVisible(true);
			}
		});
		btnend.setIcon(new ImageIcon(NewMemberCourse.class.getResource("/img/calendar.png")));
		btnend.setBounds(318, 117, 33, 20);
		panel.add(btnend);

		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(53, 120, 77, 20);
		panel.add(lblEndDate);

		JLabel lblPay = new JLabel("Pay");
		lblPay.setBounds(53, 149, 77, 20);
		panel.add(lblPay);
		String[] payment = { "not paid", "paid" };
		cbPay = new JComboBox();
		for (String string : payment) {
			cbPay.addItem(string);
		}
		cbPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object select = cbPay.getSelectedItem();
				if (select.toString().equals("paid")) {
					pay = true;
				} else {
					pay = false;
				}
			}
		});
		cbPay.setBounds(130, 148, 221, 20);

		panel.add(cbPay);
		getContentPane().setLayout(groupLayout);
	}
}
