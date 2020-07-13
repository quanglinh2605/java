package servlet.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.Category;
import entities.Product;
import models.CategoryModel;
import models.ProductModel;

@WebServlet("/admin/product")
@MultipartConfig(

		fileSizeThreshold = 1024 * 1024 * 10, // 10 MB

		maxFileSize = 1024 * 1024 * 50, // 50 MB

		maxRequestSize = 1024 * 1024 * 100 // 100 MB

)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "assets/user/upload";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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
			} else if (action.equalsIgnoreCase("add")) {
				doGet_add(request, response);
			} else if (action.equalsIgnoreCase("update")) {
				doGet_update(request, response);
			} else if (action.equalsIgnoreCase("delete")) {
				doGet_delete(request, response);
			}
		}
	}

	protected void doGet_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findall());
		request.getRequestDispatcher("product/index.jsp").forward(request, response);
	}

	protected void doGet_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryModel categoryModel = new CategoryModel();
		request.setAttribute("categories", categoryModel.findall());
		request.getRequestDispatcher("product/add.jsp").forward(request, response);
	}

	protected void doGet_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("product", productModel.find(id));
		request.getRequestDispatcher("product/update.jsp").forward(request, response);
	}

	protected void doGet_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
			if (productModel.delete(productModel.find(id))) {
				request.setAttribute("msg", "done");
			} else {
				request.setAttribute("err", "Failed");
			}
		} catch (Exception e) {

		}
		request.setAttribute("products", productModel.findall());
		request.getRequestDispatcher("product/index.jsp").forward(request, response);
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
		String photo = uploadFile(request);
		System.out.println("photo: " + photo);
		ProductModel productModel = new ProductModel();
		Category category = new Category(Integer.parseInt(request.getParameter("category")));

		Product product = new Product();
		product.setCategory(category);
		product.setCreated(new Date());
		product.setDescription(request.getParameter("description"));
		product.setName(request.getParameter("name"));
		product.setPhoto(photo);
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		boolean status = request.getParameter("status") != null;
		product.setStatus(status);
		boolean featured = request.getParameter("featured") != null;
		product.setStatus(featured);
		productModel.create(product);

		response.sendRedirect("product?action=list");
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

	private String uploadFile(HttpServletRequest request) {

		String fileName = "";

		try {

			Part filePart = request.getPart("photo");

			fileName = getFileName(filePart);

			String applicationPath = request.getServletContext()

					.getRealPath("");

			System.out.println("application path: " + applicationPath);

			String basePath = applicationPath + File.separator + UPLOAD_DIR

					+ File.separator;

			System.out.println("basePath: " + basePath);

			InputStream inputStream = null;

			OutputStream outputStream = null;

			try {

				File outputFilePath = new File(basePath + fileName);

				inputStream = filePart.getInputStream();

				outputStream = new FileOutputStream(outputFilePath);

				int read = 0;

				final byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {

					outputStream.write(bytes, 0, read);

				}

			} catch (Exception ex) {

				ex.printStackTrace();

				fileName = "";

			} finally {

				if (outputStream != null) {

					outputStream.close();

				}

				if (inputStream != null) {

					inputStream.close();

				}

			}

		} catch (Exception e) {

			fileName = "";

		}

		return fileName;

	}

	private String getFileName(Part part) {

		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {

			if (content.trim().startsWith("filename")) {

				return content.substring(content.indexOf('=') + 1).trim()

						.replace("\"", "");

			}

		}

		return null;

	}
}
