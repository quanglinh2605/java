package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HiTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer= getJspContext().getOut();
		writer.print("<b style='color:red'>--Hi Dog Bitch--</b>");
	}

	
	
	
}
