package mytags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PartnersTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		try {
			String viewPath = "../mytags/partners/index.jsp";
			PageContext pageContext = (PageContext) getJspContext();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			request.setAttribute("partners", 1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
