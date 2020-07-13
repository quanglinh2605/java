package Demo;

import java.util.Date;

import Models.ProductModel;
import entities.Category;
import entities.Product;

public class Demo29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productModel = new ProductModel();
		Product product = new Product();
		Category category = new Category();
		category.setId(2);
		product.setCategory(category);
		product.setCreated(new Date());
		product.setDescription("good");
		product.setName("apple 10");
		product.setQuantity(2);
		product.setStatus(true);
		product = productModel.create(product);
		System.out.println("id: " + product.getId());
	}
}
