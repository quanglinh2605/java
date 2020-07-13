package Representation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Repositories;
import models.vattu;

public class FormVattu extends JFrame {

	private JPanel contentPane;
	private JTextField txttenVT;
	private JTextField txtgia;
	private JTextField txtdvt;
	private JTextField txtslton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVattu frame = new FormVattu();
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
	public FormVattu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNhapThongTin = new JLabel("nhap thong tin vat tu");
		lblNhapThongTin.setBounds(141, 11, 177, 14);
		contentPane.add(lblNhapThongTin);

		JLabel lblTenVatTu = new JLabel("ten vat tu");
		lblTenVatTu.setBounds(27, 39, 48, 14);
		contentPane.add(lblTenVatTu);

		JLabel lblGia = new JLabel("gia");
		lblGia.setBounds(27, 69, 48, 14);
		contentPane.add(lblGia);

		JLabel lblDonViTinh = new JLabel("don vi tinh");
		lblDonViTinh.setBounds(27, 101, 69, 14);
		contentPane.add(lblDonViTinh);

		JLabel lblNewLabel = new JLabel("so luong ton");
		lblNewLabel.setBounds(27, 133, 69, 14);
		contentPane.add(lblNewLabel);

		txttenVT = new JTextField();
		txttenVT.setBounds(132, 36, 130, 17);
		contentPane.add(txttenVT);
		txttenVT.setColumns(10);

		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(132, 66, 130, 17);
		contentPane.add(txtgia);

		txtdvt = new JTextField();
		txtdvt.setColumns(10);
		txtdvt.setBounds(132, 98, 130, 17);
		contentPane.add(txtdvt);

		txtslton = new JTextField();
		txtslton.setColumns(10);
		txtslton.setBounds(132, 130, 130, 17);
		contentPane.add(txtslton);

		JButton btnShow = new JButton("add");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenVT = txttenVT.getText();
				double gia = Double.valueOf(txtgia.getText());
				String dvt = txtdvt.getText();
				int slton = Integer.valueOf(txtslton.getText());
				Repositories rep = new Repositories();
				vattu newItem = new vattu();
				newItem.settenVT(tenVT);
				newItem.setgia(gia);
				newItem.setdvt(dvt);
				newItem.setslton(slton);
				rep.createVT(newItem);
			}
		});
		btnShow.setBounds(27, 169, 89, 23);
		contentPane.add(btnShow);
	}
}
