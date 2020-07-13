package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hinhtron")
public class HinhtronServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HinhtronServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../hinhtron/index.jsp");
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
		if (helpers.NumberHelper.isNumber(request.getParameter("bankinh"))) {
			double bankinh = Double.parseDouble(request.getParameter("bankinh"));
			double dientich = bankinh * bankinh * Math.PI;
			request.setAttribute("r", bankinh);
			request.setAttribute("S", dientich);
		} else {
			request.setAttribute("err", "ban kinh khong hop le");
		}
		request.setAttribute("p", "../hinhtron/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}
}
