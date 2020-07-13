package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demo2")
public class Demo2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo2Servlet() {
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
			// request.setAttribute("lc", "en_US");
			request.getRequestDispatcher("demo2/index.jsp").forward(request, response);
		} else {
			String countryId = request.getParameter("countryId");
			HttpSession session = request.getSession();
			session.setAttribute("lang", langId + "_" + countryId);
			response.sendRedirect("demo2");
			// request.setAttribute("lc", langId + "_" + countryId);
			// request.getRequestDispatcher("/demo2/index.jsp").forward(request, response);

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
