package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			doGet_demo1(request, response);
		}else {
			if(action.equalsIgnoreCase("demo1")) {
				doGet_demo1(request, response);
			}
			if(action.equalsIgnoreCase("demo2")) {
				doGet_demo2(request, response);
			}
		}
		
	}
	protected void doGet_demo1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String langId = request.getParameter("langId");
		if(langId==null) {
			request.getRequestDispatcher("locale/demo1.jsp").forward(request, response);
		}else {
			String countryId = request.getParameter("countryId");
			Locale locale = new Locale(langId, countryId);
			
			int n = 123456789;
			NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
			request.setAttribute("quantity", numberFormat.format(n));
			
			NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
			request.setAttribute("percent", numberFormat2.format(n));
			
			NumberFormat numberFormat3 = NumberFormat.getPercentInstance(locale);
			request.setAttribute("currency", numberFormat3.format(n));
			
			Date today = new Date();
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
			request.setAttribute("today", dateFormat.format(today));
			
			ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.content", locale);
			request.setAttribute("msg", resourceBundle.getString("msg"));
			
			request.getRequestDispatcher("locale/demo1.jsp").forward(request, response);;
		}
	}
	protected void doGet_demo2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String langId = request.getParameter("langId");
		if(langId==null) {
			request.getRequestDispatcher("locale/demo2.jsp").forward(request, response);
		}else {
			String CountryId = request.getParameter("countryId");
			HttpSession session = request.getSession();
			session.setAttribute("locale", langId+ "_" + CountryId);
			request.getRequestDispatcher("locale/demo2.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
