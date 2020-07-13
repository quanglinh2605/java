package Caculate;

public class Model {
	public float caculate(long num1, long num2, String operater) {
		switch (operater) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return 0;
		}
	}
}
