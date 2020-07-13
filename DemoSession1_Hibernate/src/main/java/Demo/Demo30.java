package Demo;

import Models.ProductModel;
import entities.Product;

public class Demo30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productModel = new ProductModel();
		Product product = new Product();
		product = productModel.find(5);
		product.setName("iphone 9");
		product.setPrice(9999);
		product.setDescription("WWWWW");
		productModel.Update(product);
	}
}
