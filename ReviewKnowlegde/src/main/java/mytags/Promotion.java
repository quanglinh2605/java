package mytags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import entities.Product;

public class Promotion extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		try {
			List<Product> products = new ArrayList<Product>();
			products.add(new Product("p01 ","name1","thum1.jpg",200,"cateory1"));
			products.add(new Product("p02 ","name2","thum2.jpg",200,"cateory2"));
			products.add(new Product("p03 ","name3","thum3.jpg",200,"cateory3"));
			
			PageContext pageContext = (PageContext) getJspContext();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String viewtag= "../tags/product/index.jsp";
			request.setAttribute("products", products);
			request.getRequestDispatcher(viewtag);		
			pageContext.include(viewtag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
