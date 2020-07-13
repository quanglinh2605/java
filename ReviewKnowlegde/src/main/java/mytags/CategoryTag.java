package mytags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.corba.se.spi.ior.WriteContents;

public class CategoryTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException{
		JspWriter writer = getJspContext().getOut();
		List<String> categories = new ArrayList<String>();
		categories.add("category 1");
		categories.add("category 2");
		categories.add("category 3");
		categories.add("category 4");
		writer.print("<ul>");
		for (String string : categories) {
			writer.print("<li>>" + string + "</li>");
		}
		writer.print("</ul>");
	}
}
