package presentation;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class calendar extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendar frame = new calendar();
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
	public calendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(37, 115, 64, 30);
		getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(135, 115, 58, 30);
		getContentPane().add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(229, 115, 64, 30);
		getContentPane().add(comboBox_2);
	}
}
