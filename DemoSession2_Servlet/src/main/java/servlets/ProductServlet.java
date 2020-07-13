package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;

@WebServlet("/product")
/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("1", "product 1 ", "2019-11-11.png", true, 12.5, 2));
		products.add(new Product("2", "product 2 ", "2019-11-11.png", false, 5, 3));
		products.add(new Product("3", "product 3 ", "2019-11-11.png", true, 7, 4));
		products.add(new Product("3", "product 4 ", "2019-11-11.png", true, 8.5, 0));
		Product product = new Product("1", "product 1 ", "2019-11-11.png", true, 12.5, 2);
		request.setAttribute("product", product);
		request.setAttribute("products", products);
		request.getRequestDispatcher("product/NewFile.jsp").forward(request, response);
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
