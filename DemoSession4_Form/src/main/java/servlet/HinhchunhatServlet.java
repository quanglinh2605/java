package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hinhchunhat")
public class HinhchunhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HinhchunhatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../hinhchunhat/index.jsp");
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
		if (helpers.NumberHelper.isNumber(request.getParameter("chieudai"))
				&& helpers.NumberHelper.isNumber(request.getParameter("chieurong"))) {
			double chieudai = Double.parseDouble(request.getParameter("chieudai"));
			double chieurong = Double.parseDouble(request.getParameter("chieurong"));
			request.setAttribute("cd", chieudai);
			request.setAttribute("cr", chieurong);
			request.setAttribute("S", chieudai * chieurong);
		} else {
			request.setAttribute("err", "canh khong hop le");
		}
		request.setAttribute("p", "../hinhchunhat/index.jsp");
		request.getRequestDispatcher("hinhchunhat/index.jsp").forward(request, response);
	}

}
