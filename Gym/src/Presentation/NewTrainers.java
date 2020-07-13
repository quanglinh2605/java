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
import Models.Trainer;
import Models.Trainers;

public class NewTrainers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CategoryDAO dao = new CategoryDAO();
	private JTextField txtSalary;
	private JTextField txtPhone;
	private JTextField txtName;
	private JOptionPane jop;
	private Trainers dstrainer = new Trainers();

	/**
	 * Create the dialog.
	 */
	public NewTrainers(ShowTrainer owner) {
		setBounds(200, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String salary = txtSalary.getText();
				String regrex = "\\d+";
				boolean check = true;
				double money = 0;
				try {
					money = Double.valueOf(salary);
				} catch (Exception err) {
					check = false;
				}
				if (name.equals("") || phone.equals("") || salary.equals("")) {
					jop = new JOptionPane();
					jop.showMessageDialog(NewTrainers.this, "Please fill in all the form!", "New Trainer",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (phone.matches(regrex) & check & money > 0) {
						dao.GetAllTrainer(2);
						dstrainer = dao.getdstrainer();
						int count = 0;
						for (Trainer trainer : dstrainer) {
							if (phone.equals(trainer.getnumberphone())) {
								count++;
							}
						}
						if (count == 0) {
							Trainer train = new Trainer();
							train.setname(name);
							train.setnumberphone(phone);
							train.setsalary(Double.valueOf(salary));
							dao.CreateTrainer(train);
							jop = new JOptionPane();
							jop.showMessageDialog(NewTrainers.this, "Trainer added!", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							jop = new JOptionPane();
							jop.showMessageDialog(NewTrainers.this, "This trainer has already exist!", "New Trainer",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						jop = new JOptionPane();
						jop.showMessageDialog(NewTrainers.this, "Try again!", "New Trainer", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAdd.setBounds(10, 208, 89, 23);
		contentPanel.add(btnAdd);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 26, 171, 14);
		contentPanel.add(lblName);

		JLabel lblNumberphone = new JLabel("numberphone");
		lblNumberphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberphone.setBounds(10, 80, 171, 14);
		contentPanel.add(lblNumberphone);

		JLabel lblSalary = new JLabel("salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setBounds(10, 140, 171, 14);
		contentPanel.add(lblSalary);

		txtSalary = new JTextField();
		txtSalary.setBounds(191, 137, 233, 20);
		txtSalary.setColumns(10);
		txtSalary.setDocument(new JTextFieldLimit(7));
		contentPanel.add(txtSalary);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setDocument(new JTextFieldLimit(10));
		txtPhone.setBounds(191, 77, 233, 20);
		contentPanel.add(txtPhone);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(191, 23, 233, 20);
		contentPanel.add(txtName);
	}
}
