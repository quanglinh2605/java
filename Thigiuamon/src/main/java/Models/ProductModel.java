package Models;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductModel {
	private List<Product> products;

	public ProductModel() {
		products = new ArrayList<Product>();
		products.add(new Product("p01", "ti vi 1", 20, "category 1"));
		products.add(new Product("p02", "ti vi 2", 2, "category 1"));
		products.add(new Product("p03", "mobile 1", 6, "category 3"));
		products.add(new Product("p04", "mobile 2", 4, "category 2"));
		products.add(new Product("p05", "laptop 1", 9, "category 2"));
		products.add(new Product("p06", "dark mobile 1", 5, "category 3"));
	}

	public Product find(String id) {
		for (Product product : products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

	public List<Product> findall() {
		return products;
	}

	public List<String> search(String Keyword) {
		List<String> result = new ArrayList<String>();
		for (Product product : products) {
			if (product.getName().toLowerCase().contains(Keyword.toLowerCase())) {
				result.add(product.getName());
			}
		}
		return result;
	}

	public List<Product> search2(String Keyword) {
		List<Product> result = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getName().toLowerCase().contains(Keyword.toLowerCase())) {
				result.add(product);
			}
		}
		return result;
	}

	public List<Product> filter(String category) {
		List<Product> result = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getCategory().equalsIgnoreCase(category)) {
				result.add(product);
			}
		}
		return result;
	}
}
