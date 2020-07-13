package Demo;

import Models.ProductModel;
import entities.Product;

public class Demo22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productModel = new ProductModel();
		Product product = productModel.find(5);
		if (product == null) {
			System.out.println("Not found");
		} else {
			System.out.println("\tid: " + product.getId());
			System.out.println("\tname: " + product.getName());
			System.out.println("\tprice: " + product.getPrice());
		}
	}
}
