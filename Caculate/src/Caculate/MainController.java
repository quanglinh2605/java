package Caculate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label result;
	private long num1;
	private String operator = "";
	private Model model = new Model();

	@FXML
	public void processNumbers(ActionEvent e) {
		result.setText("");
		String value = ((Button) e.getSource()).getText();
		result.setText(result.getText() + value);
	}

	@FXML
	public void processOperators(ActionEvent e) {
		String value = ((Button) e.getSource()).getText();
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			operator = value;
			num1 = Long.parseLong(result.getText());
			result.setText("");
		} else {
			if (operator.isEmpty())
				return;
			long number2 = Long.parseLong(result.getText());
			float output = model.caculate(num1, number2, operator);
			result.setText(String.valueOf(output));
			operator = "";
		}
	}
}
