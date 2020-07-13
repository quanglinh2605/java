package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Mynum {
	private DoubleProperty number;

	public double getnum() {
		if (number != null) {
			return number.getValue();
		}
		return 0;
	}

	public void setnum(double number) {
		this.numberProperty().set(number);
	}

	public DoubleProperty numberProperty() {
		if (number == null) {
			number = new SimpleDoubleProperty(0);
		}
		return number;
	}
}
