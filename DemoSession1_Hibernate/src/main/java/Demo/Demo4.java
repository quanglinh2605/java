package Demo;

import java.text.SimpleDateFormat;
import java.util.List;

import Models.ProductModel;
import entities.Product;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productmodel = new ProductModel();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
		List<Product> listPro = productmodel.condition2(200, 300);
		System.out.println("products: " + listPro.size());
		for (Product pro : listPro) {
			System.out.println("id: " + pro.getId());
			System.out.println("name: " + pro.getName());
			System.out.println("price: " + pro.getPrice());
			System.out.println("status: " + pro.isStatus());
			System.out.println("created:" + simpledateformat.format(pro.getCreated()));
			System.out.println("category id:" + pro.getCategory().getId());
			System.out.println("category name:" + pro.getCategory().getName());
			System.out.println("======================================");
		}
	}

}
