package mytags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import models.CategoryModel;

public class CategoriesTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		try {
			String viewPath = "../mytags/categories/index.jsp";
			PageContext pageContext = (PageContext) getJspContext();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			CategoryModel categoryModel = new CategoryModel();
			request.setAttribute("categories", categoryModel.findall());

			request.getRequestDispatcher(viewPath);
			pageContext.include(viewPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
