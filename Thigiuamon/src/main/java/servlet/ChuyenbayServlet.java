package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.VeModel;
import Models.chuyenbayModel;
import entities.Chuyenbay;

@WebServlet("/chuyenbay")
public class ChuyenbayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChuyenbayServlet() {
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
		String action = request.getParameter("action");
		if (action == null) {
			doGet_List(request, response);
		} else {
			if (action.equalsIgnoreCase("list")) {
				doGet_List(request, response);
			}
			if (action.equalsIgnoreCase("edit")) {
				doGet_Edit(request, response);
			}
			if (action.equalsIgnoreCase("addVe")) {
				doGet_AddVe(request, response);
			}
			if (action.equalsIgnoreCase("viewVe")) {
				doGet_ViewVe(request, response);
			}
		}
	}

	protected void doGet_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		chuyenbayModel chuyenbayModel = new chuyenbayModel();
		request.setAttribute("chuyenbays", chuyenbayModel.findall());
		request.getRequestDispatcher("chuyenbay/index.jsp").forward(request, response);
	}

	protected void doGet_Edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		chuyenbayModel chuyenbayModel = new chuyenbayModel();
		int macb = Integer.parseInt(request.getParameter("macb"));
		request.setAttribute("chuyenbay", chuyenbayModel.getItemById(macb));
		request.getRequestDispatcher("chuyenbay/capnhat.jsp").forward(request, response);
	}

	protected void doGet_ViewVe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VeModel veModel = new VeModel();
		HttpSession session = request.getSession();
		session.setAttribute("macb", Integer.parseInt(request.getParameter("macb")));
		request.setAttribute("ves", veModel.findall(Integer.parseInt(request.getParameter("macb"))));
		request.getRequestDispatcher("ve/index.jsp").forward(request, response);
	}

	protected void doGet_AddVe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("macb", Integer.parseInt(request.getParameter("macb")));
		chuyenbayModel chuyenbayModel = new chuyenbayModel();
		int macb = Integer.parseInt(request.getParameter("macb"));
		request.setAttribute("chuyenbay", chuyenbayModel.getItemById(macb));
		request.getRequestDispatcher("ve/datve.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int macb = Integer.parseInt(request.getParameter("macb"));
		chuyenbayModel chuyenbayModel = new chuyenbayModel();
		Chuyenbay chuyenbay = chuyenbayModel.getItemById(macb);

		chuyenbay.setGiagheloai1(Long.parseLong(request.getParameter("giaghe1")));
		chuyenbay.setGiagheloai2(Long.parseLong(request.getParameter("giaghe2")));
		chuyenbay.setTencb(request.getParameter("tencb"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			chuyenbay.setNgaydi(dateFormat.parse(request.getParameter("ngaydi")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		chuyenbayModel.update(chuyenbay);
		response.sendRedirect("chuyenbay");
	}
}
