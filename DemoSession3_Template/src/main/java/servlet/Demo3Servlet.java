package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo3")
public class Demo3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("menu1")) {
			doGet_Menu1(request, response);
		} else if (action.equalsIgnoreCase("menu2")) {
			doGet_Menu2(request, response);
		} else {
			doGet_Menu3(request, response);
		}
	}

	protected void doGet_Menu1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("a", 123);
		request.getRequestDispatcher("demo3/menu1.jsp").forward(request, response);
	}

	protected void doGet_Menu2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("username", "abc");
		request.getRequestDispatcher("demo3/menu2.jsp").forward(request, response);
	}

	protected void doGet_Menu3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("demo3/menu3.jsp").forward(request, response);
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
