package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductModel;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
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
			doGet_home(request, response);
		} else {
			if (action.equalsIgnoreCase("home")) {
				doGet_home(request, response);
			} else if (action.equalsIgnoreCase("category")) {
				doGet_category(request, response);
			} else if (action.equalsIgnoreCase("detail")) {
				doGet_detail(request, response);
			}
		}
	}

	protected void doGet_detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("product", productModel.find(id));
		request.getRequestDispatcher("home/detail.jsp").forward(request, response);
	}

	protected void doGet_home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.featured(3));
		request.setAttribute("news", productModel.newProduct(3));
		request.getRequestDispatcher("home/index.jsp").forward(request, response);
	}

	protected void doGet_category(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		String category = request.getParameter("category");
		request.setAttribute("products", productModel.cateProduct(category));
		request.getRequestDispatcher("home/index.jsp").forward(request, response);
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
