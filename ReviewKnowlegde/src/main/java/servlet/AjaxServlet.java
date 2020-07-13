package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Models.ProductModel;
import entities.Product;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet() {
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
			doGet_index(request, response);
		} else {
			if (action.equalsIgnoreCase("products")) {
				doGet_products(request, response);
			}
			if (action.equalsIgnoreCase("filter")) {
				doGet_filter(request, response);
			}
			if (action.equalsIgnoreCase("autocomplete")) {
				doGet_autocomplete(request, response);
			}
			if (action.equalsIgnoreCase("search")) {
				doGet_search(request, response);
			}
		}
	}

	protected void doGet_index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findall());
		request.setAttribute("p", "../ajax/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	protected void doGet_products(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.print(gson.toJson(productModel.findall()));
		writer.flush();
		writer.close();
	}

	protected void doGet_autocomplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		String term = request.getParameter("term");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.print(gson.toJson(productModel.autocomplete(term)));
		writer.flush();
		writer.close();
	}

	protected void doGet_filter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel model = new ProductModel();
		String category = request.getParameter("category");
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.print(gson.toJson(model.filter(category)));
		writer.flush();
		writer.close();
	}

	protected void doGet_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		String keyword = request.getParameter("keyword");
		List<Product> products = new ArrayList<Product>();
		products = productModel.search(keyword);
		request.setAttribute("products", products);
		request.setAttribute("p", "../ajax/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
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
