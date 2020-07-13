package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dialogs.myDialog;

public class FrmMain extends JFrame {
	public static String noidung = "";
	private JPanel contentPane;
	private JTextField tfMainSend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
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
	public FrmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOpenDialog = new JButton("Open dialog");
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noidung = tfMainSend.getText();
				myDialog md = new myDialog(FrmMain.this);
				md.setVisible(true);
				tfMainSend.setText(noidung);
			}
		});
		btnOpenDialog.setBounds(173, 122, 126, 23);
		contentPane.add(btnOpenDialog);

		JLabel lblNoiDungFrame = new JLabel("noi dung frame");
		lblNoiDungFrame.setBounds(35, 70, 113, 23);
		contentPane.add(lblNoiDungFrame);

		tfMainSend = new JTextField();
		tfMainSend.setBounds(173, 71, 185, 23);
		contentPane.add(tfMainSend);
		tfMainSend.setColumns(10);
	}

}
