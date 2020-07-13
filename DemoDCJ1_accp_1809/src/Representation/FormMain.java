package Representation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormMain extends JFrame {

	private JPanel contentPane;
	private JButton btnShow;
	private JPanel panel;
	private JTextField txtNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnShow = new JButton("show");
		btnShow.setBounds(64, 39, 57, 23);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				int num = Integer.valueOf(txtNumber.getText());
				for (int i = 1; i <= num; i++) {
					JButton buttonCount = new JButton();
					Random rd = new Random();
					buttonCount.setText(String.valueOf(rd));
					panel.add(buttonCount);
				}
				panel.revalidate();
				panel.repaint();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnShow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 110, 311, 125);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel Number = new JLabel("number");
		Number.setBounds(64, 14, 37, 14);
		contentPane.add(Number);

		txtNumber = new JTextField();
		txtNumber.setBounds(131, 11, 96, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);

		JLabel lblKetQua = new JLabel("ket qua");
		lblKetQua.setBounds(64, 73, 36, 14);
		contentPane.add(lblKetQua);
	}
}
