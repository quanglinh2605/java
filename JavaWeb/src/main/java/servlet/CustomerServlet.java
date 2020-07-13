package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.CustomerModel;
import Models.OrdersModel;
import entities.Customer;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
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
			if (action.equalsIgnoreCase("add")) {
				doGet_Add(request, response);
			}
			if (action.equalsIgnoreCase("edit")) {
				doGet_Edit(request, response);
			}
			if (action.equalsIgnoreCase("addorder")) {
				doGet_Addorder(request, response);
			}
			if (action.equalsIgnoreCase("vieworder")) {
				doGet_Vieworder(request, response);
			}
			if (action.equalsIgnoreCase("list")) {
				doGet_List(request, response);
			}
		}
	}

	protected void doGet_Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("customer/addCustomer.jsp").forward(request, response);
	}

	protected void doGet_Edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerModel customerModel = new CustomerModel();
		Customer customer = customerModel.getCusById(id);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("customer/editCustomer.jsp").forward(request, response);
	}

	protected void doGet_Addorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("idCus", request.getParameter("id"));
		String id = request.getParameter("id");
		request.setAttribute("idCus", id);
		request.getRequestDispatcher("orders/add.jsp").forward(request, response);
	}

	protected void doGet_Vieworder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		String id = request.getParameter("id");
		request.setAttribute("orders", ordersModel.findAll(id));
		request.getRequestDispatcher("orders/index.jsp").forward(request, response);
	}

	protected void doGet_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerModel customerModel = new CustomerModel();
		request.setAttribute("customers", customerModel.findAll());
		request.getRequestDispatcher("customer/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			doPost_add(request, response);
		}
		if (action.equalsIgnoreCase("edit")) {
			doPost_edit(request, response);
		}
	}

	protected void doPost_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerModel customerModel = new CustomerModel();
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String date = request.getParameter("birthday");
		try {
			customer.setBirthday(format.parse(date));
		} catch (Exception e) {
		}
		customer.setPhone(request.getParameter("phone"));
		customerModel.create(customer);
		response.sendRedirect("customer");
	}

	protected void doPost_edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerModel customerModel = new CustomerModel();
		Customer customer = customerModel.getCusById(id);
		customer.setId(id);
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		String date = request.getParameter("birthday");
		try {
			customer.setBirthday(format.parse(date));
		} catch (Exception e) {
		}
		customer.setPhone(request.getParameter("phone"));
		customerModel.update(customer);
		response.sendRedirect("customer");
	}
}
