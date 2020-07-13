package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Customer;
import entities.Invoice;
import entities.Product;

@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvoiceServlet() {
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

		Invoice invoice = new Invoice();
		invoice.setCreated(new Date());
		invoice.setCustomer(new Customer("c01", "customer 1", "address 1", "cus1@gmail.com"));
		invoice.setName("invoice 1");
		invoice.setPayment("Cash");
		invoice.setProducts(products);

		request.setAttribute("invoice", invoice);
		request.getRequestDispatcher("invoice/index.jsp").forward(request, response);
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
