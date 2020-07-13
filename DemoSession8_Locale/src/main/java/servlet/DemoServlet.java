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

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String langId = request.getParameter("langId");
		if (langId == null) {
			request.getRequestDispatcher("Demo/index.jsp").forward(request, response);
		} else {
			String countryId = request.getParameter("countryId");
			Locale locale = new Locale(langId, countryId);
			// Dinh dang so
			int n = 1234567;
			NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
			System.out.println("Number: " + numberFormat.format(n));
			request.setAttribute("number", numberFormat.format(n));
			// Dinh dang tien te
			NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
			request.setAttribute("currency", numberFormat2.format(n));
			System.out.println("Currency: " + numberFormat2.format(n));

			// Dinh dang phan tram
			NumberFormat numberFormat3 = NumberFormat.getPercentInstance(locale);
			double percent = 13.14;
			request.setAttribute("percent", numberFormat3.format(percent));
			System.out.println("percent: " + percent);
			// Dinh dang thoi gian
			Date today = new Date();
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.println("date: " + dateFormat.format(today));
			request.setAttribute("date", dateFormat.format(today));

			// Dinh dang noi dung
			ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.content", locale);
			String msg = resourceBundle.getString("msg");
			System.out.println("msg: " + msg);
			request.setAttribute("msg", msg);

			request.getRequestDispatcher("Demo/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
