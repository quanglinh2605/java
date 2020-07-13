package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.ProductModel;
import entities.Product;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet() {
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
		HttpSession session = request.getSession();

		session.setAttribute("age", 20);
		session.setAttribute("name", "abc");

		ProductModel productModel = new ProductModel();
		session.setAttribute("product", productModel.find());
		session.setAttribute("products", productModel.findall());

		request.getRequestDispatcher("demo/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username = session.getAttribute("name").toString();
		int age = Integer.parseInt(session.getAttribute("age").toString());

		System.out.println("Username: " + username);
		System.out.println("age: " + age);

		System.out.println("Product Info");
		Product product = (Product) session.getAttribute("product");
		System.out.println("int id: " + product.getId());
		System.out.println("name: " + product.getName());
		System.out.println("price: " + product.getPrice());

		System.out.println("Product List");
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.getAttribute("products");
		for (Product pro : products) {
			System.out.println("int id: " + pro.getId());
			System.out.println("name: " + pro.getName());
			System.out.println("price: " + pro.getPrice());
			System.out.println("---------------------------");
		}
	}
}
