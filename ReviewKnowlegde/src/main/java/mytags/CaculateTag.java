package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CaculateTag extends SimpleTagSupport {
	private int a;
	private int b;
	private String sign;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public void doTag() throws JspException, IOException{
		JspWriter writer = getJspContext().getOut();
		if(sign.equalsIgnoreCase("+")) {
			writer.print(a + b);
		}else if(sign.equalsIgnoreCase("-")) {
			writer.print(a - b);
		}else if(sign.equalsIgnoreCase("*")) {
			writer.print(a*b);
		}else if(sign.equalsIgnoreCase("/")) {
			writer.print(a/b);
		}
	}
}
