package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
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
		if (action == null) {
			doGet_Index(request, response);
		} else {
			if (action.equalsIgnoreCase("login")) {
				doGet_Login(request, response);
			}
			if (action.equalsIgnoreCase("logout")) {
				doGet_Logout(request, response);
			}
		}
	}

	protected void doGet_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/login.jsp").forward(request, response);
	}

	protected void doGet_Logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/login.jsp").forward(request, response);
	}

	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("save")) {
			doPost_Save(request, response);
		} else if (action.equalsIgnoreCase("login")) {
			doPost_Login(request, response);
		}
	}

	protected void doPost_Save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		System.out.println("username: " + username);

		String password = request.getParameter("password").trim();
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println("password: " + hash);

		String description = request.getParameter("description");
		System.out.println("description: " + description);

		String gender = request.getParameter("gender");
		System.out.println("Gender: " + gender);
		response.sendRedirect("account");

		boolean status = request.getParameter("status") != null;
		System.out.println("status: " + status);

		if (request.getParameterValues("languages") != null) {
			String[] languages = request.getParameterValues("languages");
			System.out.println("Languages: " + languages.length);
			for (String lang : languages) {
				System.out.println(lang);
			}
		}

		String role = request.getParameter("role");
		System.out.println("role: " + role);

		String id = request.getParameter("id");
		System.out.println("id: " + id);

		response.sendRedirect("account");
	}

	protected void doPost_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		if (username.equalsIgnoreCase("abc") && password.equalsIgnoreCase("123")) {
			request.setAttribute("username", username);
			request.getRequestDispatcher("account/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("err", "invalid");
			request.getRequestDispatcher("account/login.jsp").forward(request, response);
		}
	}
}