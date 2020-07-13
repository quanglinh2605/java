package repositories;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class example extends JFrame {

	private ImageIcon image1;
	private JButton b1;
	private JTextField userName;
	private static String password = "";
	private JPanel backGround;

	example() {
		setLayout(new FlowLayout());
		// creating username textbox
		userName = new JTextField("");
		userName.setText("Username");
		userName.setForeground(Color.GRAY);
		userName.setColumns(10);
		getContentPane().add(userName);
		// creating password textbox
		JPasswordField passWord = new JPasswordField(10);
		passWord.setEchoChar('*');
		passWord.addActionListener(new AL());
		getContentPane().add(passWord);
		// adding the button and the label to the panel
		b1 = new JButton("something");
		getContentPane().add(b1);
		// getting the image and displaying to the label
	}

	public static void main(String[] Args) {
		// Creating the interface
		example gui = new example();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("The Co-operative");
		try {
			gui.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("bg-gym.jpg")))));

		} catch (IOException e) {
			System.out.println("image doesn't exist");
		}
	}

	static class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPasswordField input = (JPasswordField) e.getSource();
			char[] passy = input.getPassword();
			String p = new String(passy);
			if (p.equals(password)) {
				JOptionPane.showMessageDialog(null, "Correct");

			} else {
				JOptionPane.showMessageDialog(null, "Incorrect");
			}
		}
	}
}
