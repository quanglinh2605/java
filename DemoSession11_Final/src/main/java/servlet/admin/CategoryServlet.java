package servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Category;
import models.CategoryModel;

@WebServlet("/admin/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
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
			if (action.equalsIgnoreCase("list")) {
				doGet_list(request, response);
			}
			if (action.equalsIgnoreCase("add")) {
				doGet_add(request, response);
			}
			if (action.equalsIgnoreCase("update")) {
				doGet_update(request, response);
			}
			if (action.equalsIgnoreCase("delete")) {
				doGet_delete(request, response);
			}
		}
	}

	protected void doGet_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryModel categoryModel = new CategoryModel();
		request.setAttribute("categories", categoryModel.findall());
		request.getRequestDispatcher("category/index.jsp").forward(request, response);
	}

	protected void doGet_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("category/add.jsp").forward(request, response);
	}

	protected void doGet_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryModel categoryModel = new CategoryModel();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("category", categoryModel.find(id));
		request.getRequestDispatcher("category/update.jsp").forward(request, response);
	}

	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryModel categoryModel = new CategoryModel();
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			if (categoryModel.delete(categoryModel.find(id))) {
				request.setAttribute("msg", "done");
			} else {
				request.setAttribute("err", "Failed");
			}
		} catch (Exception e) {

		}
		request.setAttribute("categories", categoryModel.findall());
		request.getRequestDispatcher("category/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			doPost_add(request, response);
		}
		if (action.equalsIgnoreCase("update")) {
			doPost_update(request, response);
		}
	}

	protected void doPost_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		CategoryModel categoryModel = new CategoryModel();
		Category category = new Category();
		category.setName(name);
		categoryModel.create(category);
		response.sendRedirect("category?action=list");
	}

	protected void doPost_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryModel categoryModel = new CategoryModel();
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = categoryModel.find(id);
		category.setName(request.getParameter("name"));
		categoryModel.update(category);
		response.sendRedirect("category?action=list");
	}
}
