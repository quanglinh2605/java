package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Models.OrdersModel;
import entities.Orders;

@WebServlet("/ticket")
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
			doGet_index(request, response);
		} else {
			if (action.equalsIgnoreCase("index")) {
				doGet_index(request, response);
			} else if (action.equalsIgnoreCase("add")) {
				doGet_add(request, response);
			} else if (action.equalsIgnoreCase("search")) {
				doGet_search(request, response);
			} else if (action.equalsIgnoreCase("update")) {
				doGet_update(request, response);
			}
		}
	}

	protected void doGet_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrdersModel ordersModel = new OrdersModel();
		request.setAttribute("ticket", ordersModel.find(id));
		request.getRequestDispatcher("ticket/update.jsp").forward(request, response);
	}

	protected void doGet_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String priority = request.getParameter("priority");
		OrdersModel ordersModel = new OrdersModel();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.print(gson.toJson(ordersModel.findByPriority(priority)));
		writer.flush();
		writer.close();
	}

	protected void doGet_index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		request.setAttribute("tickets", ordersModel.findall());
		request.getRequestDispatcher("ticket/index.jsp").forward(request, response);
	}

	protected void doGet_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ticket/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String priority = request.getParameter("priority");
		if (action.equalsIgnoreCase("add")) {
			doPost_add(request, response);
		}
		if (action.equalsIgnoreCase("update")) {
			doPost_update(request, response);
		}
		if (action.equalsIgnoreCase("search")) {
			doPost_search(request, response);
		}
		if (action.equalsIgnoreCase("finddate")) {
			doPost_finddate(request, response);
		}
	}

	protected void doPost_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		Orders orders = new Orders();
		try {
			orders.setTitle(request.getParameter("title"));
			orders.setPriority(request.getParameter("priority"));
			orders.setStatus(request.getParameter("status"));
			orders.setDescription(request.getParameter("description"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = request.getParameter("created");
			Date date = format.parse(dateString);
			orders.setCreated(date);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		ordersModel.create(orders);
		response.sendRedirect("ticket");
	}

	protected void doPost_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String priority = request.getParameter("priority");
		OrdersModel ordersModel = new OrdersModel();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		writer.print(gson.toJson(ordersModel.findByPriority(priority)));
		writer.flush();
		writer.close();
	}

	protected void doPost_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrdersModel ordersModel = new OrdersModel();
		Orders orders = ordersModel.find(id);
		orders.setStatus(request.getParameter("status"));
		orders.setDescription(request.getParameter("description"));
		orders.setPriority(request.getParameter("priority"));
		orders.setTitle(request.getParameter("title"));
		String dateString = request.getParameter("created");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			orders.setCreated(dateFormat.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ordersModel.update(orders);
		response.sendRedirect("ticket");
	}

	protected void doPost_finddate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		List<Orders> orders = new ArrayList<Orders>();
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			orders = ordersModel.FindByDates(dateFormat.parse(start), dateFormat.parse(end));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("tickets", orders);
		request.getRequestDispatcher("ticket/index.jsp").forward(request, response);
	}
}
