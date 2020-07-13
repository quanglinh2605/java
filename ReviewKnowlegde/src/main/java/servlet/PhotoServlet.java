package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("size", "120x100");
		request.setAttribute("width", "120");
		request.setAttribute("height", "100");
		request.setAttribute("p", "../photo/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String size = request.getParameter("size");
		String width = size.split("x")[0];
		String height = size.split("x")[1];
		request.setAttribute("width", width);
		request.setAttribute("height", height);
		request.setAttribute("size", size);
		request.setAttribute("p", "../photo/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}
}
