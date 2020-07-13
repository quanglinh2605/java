package Demo;

import Models.ProductModel;
import entities.Product;

public class Demo31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductModel productModel = new ProductModel();
		Product product = new Product();
		product = productModel.find(6);
		if (productModel.Delete(product)) {
			System.out.println("delete Success");
		} else {
			System.out.println("Can't Delete");
		}
	}
}
