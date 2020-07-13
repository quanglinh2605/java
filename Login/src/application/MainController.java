package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private Label label;
	@FXML
	private TextField User;
	@FXML
	private TextField Pass;

	public void Login(ActionEvent e) {
		if (User.getText().equals("admin") && Pass.getText().equals("123456")) {
			label.setText("Login Success");
		} else {
			label.setText("Login Failed");
		}
	}
}
