package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hinhvuong")
public class HinhvuongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HinhvuongServlet() {
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
		request.setAttribute("p", "../hinhvuong/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("save")) {
			doPost_dientich(request, response);
		}
	}

	protected void doPost_dientich(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (helpers.NumberHelper.isNumber(request.getParameter("canh"))) {
			double canh = Double.parseDouble(request.getParameter("canh"));
			request.setAttribute("a", canh);
			request.setAttribute("S", canh * canh);
		} else {
			request.setAttribute("err", "Canh khong hop le");
		}
		request.setAttribute("p", "../hinhvuong/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}
}