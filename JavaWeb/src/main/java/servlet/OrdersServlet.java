package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.OrdersModel;
import entities.Customer;
import entities.Orders;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdersServlet() {
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
			doGet_list(request, response);
		} else {
			if (action.equalsIgnoreCase("add")) {
				doGet_add(request, response);
			}
			if (action.equalsIgnoreCase("delete")) {
				doGet_delete(request, response);
			}
			if (action.equalsIgnoreCase("list")) {
				doGet_list(request, response);
			}
		}
	}

	protected void doGet_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("orders/add.jsp").forward(request, response);
	}

	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrdersModel ordersModel = new OrdersModel();
		ordersModel.delete(ordersModel.getOrderById(id));
		response.sendRedirect("orders");
	}

	protected void doGet_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("idCus");
		request.setAttribute("orders", ordersModel.findAll(id));
		request.getRequestDispatcher("orders/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		Orders orders = new Orders();
		Customer customer = new Customer(Integer.parseInt(request.getParameter("customerId")));
		orders.setName(request.getParameter("name"));
		orders.setCustomer(customer);
		orders.setPayments(request.getParameter("payment"));
		orders.setStatus(Boolean.parseBoolean(request.getParameter("status")));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(request.getParameter("date"));
			orders.setDatecreation(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ordersModel.create(orders);
		response.sendRedirect("orders");
	}
}
