package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Item;
import entities.Product;
import paypal.PayPalResult;
import paypal.PayPalSucess;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
			if (action.equalsIgnoreCase("Checkout")) {
				doGet_CheckOut(request, response);
			}
		}
	}

	protected void doGet_CheckOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PayPalResult result = PayPalSucess.getPayPal(request);
		System.out.println("Customer Info");
		System.out.println("First Name: " + result.getFirst_name());
		System.out.println("Last Name: " + result.getLast_name());
		System.out.println("Country: " + result.getAddress_country());
		System.out.println("City: " + result.getAddress_city());
		System.out.println("Email: " + result.getPayer_email());
		request.getRequestDispatcher("cart/thanks.jsp").forward(request, response);
	}

	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Item> cart = new ArrayList<Item>();
		cart.add(new Item(new Product(1, "name 1", 4, "image1.jpg"), 2));
		cart.add(new Item(new Product(2, "name 2", 2, "image2.jpg"), 4));
		cart.add(new Item(new Product(3, "name 3", 3, "image3.jpg"), 3));
		cart.add(new Item(new Product(4, "name 4", 7, "image1.jpg"), 2));
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("cart/index.jsp").forward(request, response);
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
