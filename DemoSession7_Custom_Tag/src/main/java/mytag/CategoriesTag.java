package mytag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CategoriesTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		List<String> categories = new ArrayList<String>();
		categories.add("Category 1 ");
		categories.add("Category 2 ");
		categories.add("Category 3 ");
		categories.add("Category 4 ");
		writer.print("<ul>");
		for (String category : categories) {
			writer.print("<li>" + category + "</li                                                                                          >");

		}
		writer.print("</ul>");
	}

}
