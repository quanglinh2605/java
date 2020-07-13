package Demo;

import java.util.List;

import Models.ProductModel;
import entities.ProductEntity;

public class Demo23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productmodel = new ProductModel();
		List<ProductEntity> listPro = productmodel.findallEntity();
		System.out.println("products: " + listPro.size());
		for (ProductEntity pro : listPro) {
			System.out.println("id: " + pro.getId());
			System.out.println("name: " + pro.getName());
			System.out.println("price: " + pro.getPrice());
			System.out.println("description: " + pro.getDescription());
			System.out.println("======================================");
		}
	}

}
