package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			doGet_Login(request, response);
		} else {
			if (action.equalsIgnoreCase("login")) {
				doGet_Login(request, response);
			}
			if (action.equalsIgnoreCase("logout")) {
				doGet_Logout(request, response);
			}
			if (action.equalsIgnoreCase("register")) {
				doGet_Register(request, response);
			}
		}
	}

	protected void doGet_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../account/login.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	protected void doGet_Logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("account");
	}

	protected void doGet_Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../account/register.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Save")) {
			doPost_Save(request, response);
		}
		if (action.equalsIgnoreCase("login")) {
			doPost_Login(request, response);
		}
	}

	protected void doPost_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equalsIgnoreCase("abc") && password.equals("123")) {
			session.setAttribute("username", username);
			request.setAttribute("p", "../account/welcome.jsp");
			request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
		} else {
			request.setAttribute("err", "Invalid");
			request.setAttribute("p", "../account/login.jsp");
			request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
		}
	}

	protected void doPost_Save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("Username: " + username);

		String password = request.getParameter("password");
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println("password: " + hash);

		String description = request.getParameter("description");
		System.out.println("description: " + description);

		String gender = request.getParameter("gender");
		System.out.println("Gender: " + gender);

		boolean status = request.getParameter("status") != null;
		System.out.println("status: " + status);

		String[] languages = request.getParameterValues("languages");
		for (String lang : languages) {
			System.out.println(lang);
		}

		String role = request.getParameter("role");
		System.out.println("Role: " + role);

		String id = request.getParameter("id");
		System.out.println("id: " + id);

		response.sendRedirect("account");
	}
}
