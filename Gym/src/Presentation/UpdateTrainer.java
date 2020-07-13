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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import Dao.CategoryDAO;
import Models.Trainer;
import Models.Trainers;

public class UpdateTrainer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtSalary;
	private CategoryDAO dao = new CategoryDAO();
	private Trainers dstrainer = new Trainers();
	private JOptionPane jop = new JOptionPane();

	/**
	 * Create the dialog.
	 */
	public void load(int id) {
		dao.GetTrainerById(id);
		dstrainer = dao.getdstrainer();
		for (Trainer trainer : dstrainer) {
			txtName.setText(trainer.getname());
			txtPhone.setText(trainer.getnumberphone());
			txtSalary.setText(String.valueOf(trainer.getsalary()));
		}
	}

	public UpdateTrainer(JPanel owner, int id) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 27, 156, 18);
		contentPanel.add(lblName);

		JLabel lblNumberPhone = new JLabel("Number phone");
		lblNumberPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberPhone.setBounds(10, 81, 156, 18);
		contentPanel.add(lblNumberPhone);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setBounds(10, 140, 156, 18);
		contentPanel.add(lblSalary);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
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
					jop.showMessageDialog(UpdateTrainer.this, "Please fill in all the form!", "New Trainer",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (phone.matches(regrex) & check & money >= 0) {

						dao.UpdateTrainer(name, phone, money, id);
						jop.showMessageDialog(UpdateTrainer.this, "Update success!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
					} else {
						jop = new JOptionPane();
						jop.showMessageDialog(UpdateTrainer.this, "Try again!", "New Trainer",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnUpdate.setBounds(10, 195, 89, 23);
		contentPanel.add(btnUpdate);

		txtName = new JTextField();
		txtName.setBounds(176, 28, 248, 21);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(176, 82, 248, 20);
		contentPanel.add(txtPhone);

		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(176, 141, 248, 20);
		txtSalary.setDocument(new JTextFieldLimit(7));
		contentPanel.add(txtSalary);
		load(id);
	}
}

class JTextFieldLimit extends PlainDocument {
	private int limit;

	JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	JTextFieldLimit(int limit, boolean upper) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}
