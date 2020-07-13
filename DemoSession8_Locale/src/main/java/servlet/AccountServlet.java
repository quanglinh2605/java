package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import Models.AccountModel;
import entities.Account;

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
			doGet_List(request, response);
		} else {
			if (action.equalsIgnoreCase("register")) {
				doGet_Register(request, response);
			}
			if (action.equalsIgnoreCase("login")) {
				doGet_Login(request, response);
			}
			if (action.equalsIgnoreCase("list")) {
				doGet_List(request, response);
			}
			if (action.equalsIgnoreCase("delete")) {
				doGet_Delete(request, response);
			}
			if (action.equalsIgnoreCase("edit")) {
				doGet_Edit(request, response);
			}
		}
	}

	protected void doGet_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/login.jsp").forward(request, response);
	}

	protected void doGet_Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/index.jsp").forward(request, response);
	}

	protected void doGet_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		request.setAttribute("accounts", accountModel.findall());
		request.getRequestDispatcher("account/listAccount.jsp").forward(request, response);
	}

	protected void doGet_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AccountModel accountModel = new AccountModel();
		Account acc = accountModel.findAccById(id);
		accountModel.deleteAcc(acc);
		response.sendRedirect("account");
	}

	protected void doGet_Edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("account", accountModel.findAccById(id));
		request.getRequestDispatcher("account/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("login")) {
			doPost_Login(request, response);
		}
		if (action.equalsIgnoreCase("register")) {
			doPost_Register(request, response);
		}
		if (action.equalsIgnoreCase("edit")) {
			doPost_Edit(request, response);
		}
	}

	protected void doPost_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = accountModel.checkLogin(username);
		HttpSession session = request.getSession();
		if (account != null) {
			if (BCrypt.checkpw(password, account.getPassword())) {
				session.setAttribute("account", account);
				request.getRequestDispatcher("account/welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Mat Khau Sai");
				request.getRequestDispatcher("account/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("err", "Tai khoan khong ton tai");
			request.getRequestDispatcher("account/login.jsp").forward(request, response);
		}
	}

	protected void doPost_Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		Account account = new Account();
		account.setUsername(request.getParameter("username").trim());
		account.setFullname(request.getParameter("fullname").trim());
		String password = request.getParameter("password").trim();
		account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		accountModel.create(account);
		response.sendRedirect("account");
	}

	protected void doPost_Edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AccountModel accountModel = new AccountModel();
		Account account = accountModel.findAccById(id);
		account.setFullname(request.getParameter("fullname").trim());
		String password = request.getParameter("password").trim();
		if (password != null) {
			account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		}
		accountModel.update(account);
		response.sendRedirect("account");
	}
}
