package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.ProductModel;
import entities.Item;
import entities.Product;

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
			doGet_index(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_buy(request, response);
			}
			if (action.equalsIgnoreCase("view")) {
				doGet_List(request, response);
			}
			if (action.equalsIgnoreCase("remove"))
				doGet_remove(request, response);
		}
	}

	protected void doGet_index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		HttpSession session = request.getSession();
		session.setAttribute("products", productModel.findall());
		request.setAttribute("p", "../cart/index.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	protected void doGet_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../cart/listcart.jsp");
		request.getRequestDispatcher("templates/mytemplate.jsp").forward(request, response);
	}

	protected void doGet_remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = Integer.parseInt(request.getParameter("index"));
		cart.remove(index);
		response.sendRedirect("cart?action=view");
	}

	protected void doGet_buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		String id = request.getParameter("id");
		Product product = productModel.find(id);
		HttpSession session = request.getSession();
		if (product != null) {
			if (session.getAttribute("cart") == null) {
				List<Item> cart = new ArrayList<Item>();
				cart.add(new Item(product, 1));
				session.setAttribute("cart", cart);
			} else {
				@SuppressWarnings("unchecked")
				List<Item> cart = (List<Item>) session.getAttribute("cart");
				int index = isExist(id, cart);
				if (index != -1) {
					int newQuantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(newQuantity);
				} else {
					cart.add(new Item(product, 1));
				}
			}
		}
		response.sendRedirect("cart?action=view");
	}

	public int isExist(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		String[] quantities = request.getParameterValues("quantity");
		for (int i = 0; i < quantities.length; i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		response.sendRedirect("cart?action=view");
	}

}
