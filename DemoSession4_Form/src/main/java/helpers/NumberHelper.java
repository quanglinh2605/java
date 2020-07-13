package helpers;

public class NumberHelper {
	public static boolean isNumber(String s) {
		try {
			return Double.parseDouble(s) > 0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
