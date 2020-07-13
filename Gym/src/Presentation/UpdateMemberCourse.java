package Presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.CategoryDAO;
import Models.Course;
import Models.Courses;
import Models.Invoice;
import Models.Member_Course;
import Models.Trainer;
import Models.Trainers;

public class UpdateMemberCourse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtstart;
	private JTextField txtend;
	private JComboBox cbCourse;
	private JComboBox cbTrainer;
	private CategoryDAO dao = new CategoryDAO();
	private Courses dscourse = new Courses();
	private Trainers dstrainer = new Trainers();
	private int trainerid = 0;
	private int courseid = 0;
	private JTextField txtPrice;
	private boolean pay = false;
	private JComboBox cbPay;
	private boolean check = false;

	public void Course() {
		dao.GetAllCourse(2);
		dscourse = dao.getdscourse();
	}

	public void Trainer() {
		dao.GetAllTrainer(2);
		dstrainer = dao.getdstrainer();
	}

	public void load(int id) {
		Member_Course mco = dao.GetMemberCourseById(id);
		courseid = mco.getcourseid().getid();
		trainerid = mco.gettrainerid().getid();
		txtstart.setText(mco.getStartdate());
		txtend.setText(mco.getEnddate());
		txtPrice.setText(String.valueOf(mco.getprice()));
		Invoice i = dao.GetInvoiceById(mco.getid());
		pay = i.getpay();
		if (pay) {
			check = true;
		} else {
			check = false;
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateMemberCourse(int id, int emp_id) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Course();
		Trainer();
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(10, 11, 128, 22);
		contentPanel.add(lblCourse);

		cbCourse = new JComboBox();
		cbCourse.setBounds(148, 13, 228, 22);
		contentPanel.add(cbCourse);
		for (Models.Course course : dscourse) {
			cbCourse.addItem(course.getname());
		}
		cbCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object select = cbCourse.getSelectedItem();
				for (Course course : dscourse) {
					if (select.toString().equals(course.getname())) {
						courseid = course.getid();
					}
				}
			}
		});
		JLabel lblTrainer = new JLabel("Trainer");
		lblTrainer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainer.setBounds(10, 44, 128, 22);
		contentPanel.add(lblTrainer);

		cbTrainer = new JComboBox();
		cbTrainer.setBounds(148, 44, 228, 22);
		contentPanel.add(cbTrainer);
		for (Trainer train : dstrainer) {
			cbTrainer.addItem(train.getname());
		}
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
		JLabel lblStartdate = new JLabel("Start date");
		lblStartdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartdate.setBounds(10, 110, 128, 22);
		contentPanel.add(lblStartdate);

		txtstart = new JTextField();
		txtstart.setEditable(false);
		txtstart.setBounds(148, 111, 183, 22);
		contentPanel.add(txtstart);
		txtstart.setColumns(10);

		JButton btnstart = new JButton("");
		btnstart.setIcon(new ImageIcon(UpdateMemberCourse.class.getResource("/img/calendar.png")));
		btnstart.setBounds(341, 110, 35, 22);
		contentPanel.add(btnstart);
		btnstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymCalendar gc = new GymCalendar(txtstart);
				gc.setVisible(true);
			}
		});
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndDate.setBounds(10, 143, 128, 22);
		contentPanel.add(lblEndDate);

		txtend = new JTextField();
		txtend.setEditable(false);
		txtend.setBounds(148, 145, 183, 22);
		contentPanel.add(txtend);
		txtend.setColumns(10);

		JButton btnend = new JButton("");
		btnend.setIcon(new ImageIcon(UpdateMemberCourse.class.getResource("/img/calendar.png")));
		btnend.setBounds(341, 145, 35, 22);
		contentPanel.add(btnend);
		btnend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GymCalendar gc = new GymCalendar(txtend);
				gc.setVisible(true);
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String start = txtstart.getText();
				String end = txtend.getText();
				if (courseid == 0 || trainerid == 0 || emp_id == 0 || start.equalsIgnoreCase("")
						|| end.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(UpdateMemberCourse.this, "Please fill all the form!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Member_Course mc = new Member_Course();
					mc.setid(id);
					mc.setcourseid(dao.GetCourseById(courseid));
					mc.setempid(dao.getEmpbyId(String.valueOf(emp_id)));
					mc.settrainerid(dao.GetTrainerById(trainerid));
					mc.setStartdate(start);
					mc.setEnddate(end);
					mc.setprice(Double.valueOf(txtPrice.getText()));
					dao.UpdateMemberCourse(mc);
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String paydate = String.valueOf(d.format(cal.getTime()));
					Invoice iv = dao.GetInvoiceById(mc.getid());
					iv.setpay(pay);
					if (!check) {
						iv.setpaydate(paydate);
					}
					dao.UpdateInvoice(iv);
					dispose();
				}
			}
		});
		btnUpdate.setBounds(10, 227, 89, 23);
		contentPanel.add(btnUpdate);

		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 77, 128, 22);
		contentPanel.add(lblNewLabel);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBounds(148, 77, 228, 22);
		contentPanel.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lblPay = new JLabel("Pay");
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPay.setBounds(10, 176, 128, 22);
		contentPanel.add(lblPay);

		cbPay = new JComboBox();
		cbPay.setBounds(148, 178, 183, 22);
		contentPanel.add(cbPay);
		String[] payment = { "not paid", "paid" };
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
		load(id);
	}
}
