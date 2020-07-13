package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CalculateTag extends SimpleTagSupport {

	private double a;
	private double b;
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		if (sign.equalsIgnoreCase("+")) {
			writer.print(a + b);
		} else if (sign.equalsIgnoreCase("-")) {
			writer.print(a - b);
		} else if (sign.equalsIgnoreCase("x")) {
			writer.print(a * b);
		} else if (sign.equalsIgnoreCase("/")) {
			writer.print(a / b);
		}

	}

}
