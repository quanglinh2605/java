package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.VeModel;
import entities.Chuyenbay;
import entities.Ve;

@WebServlet("/ve")
public class VeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VeServlet() {
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
			if (action.equalsIgnoreCase("list")) {
				doGet_List(request, response);
			}
			if (action.equalsIgnoreCase("delete")) {
				doGet_Delete(request, response);
			}
		}
	}

	protected void doGet_List(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VeModel vemodel = new VeModel();
		HttpSession session = request.getSession();
		int macb = (int) session.getAttribute("macb");
		request.setAttribute("ves", vemodel.findall(macb));
		request.getRequestDispatcher("ve/index.jsp").forward(request, response);
	}

	protected void doGet_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VeModel vemodel = new VeModel();
		int mave = Integer.parseInt(request.getParameter("mave"));
		vemodel.delete(vemodel.getItemById(mave));
		response.sendRedirect("ve");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int macb = Integer.parseInt(request.getParameter("macb"));
		VeModel veModel = new VeModel();
		Chuyenbay chuyenbay = new Chuyenbay(macb);
		Ve ve = new Ve();
		ve.setChuyenbay(chuyenbay);
		ve.setCmnd(request.getParameter("cmnd"));
		ve.setGiaghe(Integer.parseInt(request.getParameter("giaghe")));
		ve.setHotenhanhkhach(request.getParameter("hoten"));
		ve.setLoaighe(Integer.parseInt(request.getParameter("loaighe")));
		veModel.create(ve);
		response.sendRedirect("ve");
	}

}
