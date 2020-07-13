package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.employeeModel;

@WebServlet("/employee")
public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public employeeServlet() {
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
		if (action.equalsIgnoreCase("list")) {
			doGet_list(request, response);
		} else if (action.equalsIgnoreCase("details")) {
			doGet_Details(request, response);
		}
	}

	protected void doGet_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeModel employeeModel = new employeeModel();
		request.setAttribute("employees", employeeModel.findall());
		request.getRequestDispatcher("employee/index.jsp").forward(request, response);
	}

	protected void doGet_Details(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		employeeModel employeeModel = new employeeModel();
		request.setAttribute("employee", employeeModel.find(id));
		request.getRequestDispatcher("employee/details.jsp").forward(request, response);
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
