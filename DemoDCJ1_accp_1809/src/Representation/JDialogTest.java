package Representation;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class AddressDialog extends JDialog {
	JLabel label1 = new JLabel("Address");

	JLabel label2 = new JLabel("City");

	JLabel label3 = new JLabel("State");

	JLabel label4 = new JLabel("Zip Code");

	JTextField addressField = new JTextField();

	JTextField cityField = new JTextField();

	JTextField stateField = new JTextField();

	JTextField zipCodeField = new JTextField();

	String[] address = new String[4];

	public AddressDialog(Frame owner, boolean modal) {
		super(owner, modal);
		init();
	}

	private void init() {
		this.setTitle("Address Dialog");
		this.setLayout(new GridLayout(4, 2));
		this.add(label1);
		this.add(addressField);
		this.add(label2);
		this.add(cityField);
		this.add(label3);
		this.add(stateField);
		this.add(label4);
		this.add(zipCodeField);
	}

	public String[] getAddress() {
		address[0] = addressField.getText();

		address[1] = cityField.getText();
		address[2] = stateField.getText();
		address[3] = zipCodeField.getText();
		return address;
	}
}

public class JDialogTest extends JFrame {
	AddressDialog dialog = new AddressDialog(this, false);

	public JDialogTest(String title) {
		super(title);
		init();
	}

	public JDialogTest() {
		super();
		init();

	}

	private void init() {
		this.getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final AddressDialog dialog = new AddressDialog(this, false);
		JButton button = new JButton("Show Dialog");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dialog.setSize(250, 120);
				dialog.setVisible(true);
			}
		});
		this.getContentPane().add(button);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JDialogTest frame = new JDialogTest();
		frame.pack();
		frame.setVisible(true);
	}
}