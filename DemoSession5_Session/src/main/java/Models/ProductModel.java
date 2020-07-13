package Models;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductModel {
	public Product find() {
		return new Product("p01", "name 1", 4);
	}

	public List<Product> findall() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1", 4));
		products.add(new Product("p02", "name 2", 2));
		products.add(new Product("p03", "name 3", 7));
		return products;
	}

	public Product find(String id) {
		for (Product product : findall()) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}
}
