package mytags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PartnersTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		try {
			List<String> partners = new ArrayList<String>();
			partners.add("Partners 1 ");
			partners.add("Partners 2 ");
			partners.add("Partners 3 ");
			partners.add("Partners 4 ");
			PageContext pageContext = (PageContext) getJspContext();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String viewtag= "../tags/partners/index.jsp";
			request.setAttribute("partners", partners);
			request.getRequestDispatcher(viewtag);		
			pageContext.include(viewtag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
