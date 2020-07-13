package Models;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductModel {
	public Product find() {
		return new Product("p01", "name 1","images2", 4, "category 1");
	}

	public List<Product> findall() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1","images2", 4, "category 1"));
		products.add(new Product("p02", "name 2","images1", 2, "category 2"));
		products.add(new Product("p03", "name 3","images3", 7, "category 3"));
		products.add(new Product("p04", "name 4","images1", 5, "category 2"));
		products.add(new Product("p05", "name 5","images2", 1, "category 1"));
		products.add(new Product("p06", "name 6","images3", 3, "category 3"));
		return products;
	}

	public Product find(String id) {
		for (Product product : findall()) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

	public List<String> autocomplete(String keyword) {
		List<String> strings = new ArrayList<String>();
		for (Product product : findall()) {
			if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
				strings.add(product.getName());
			}
		}
		return strings;
	}

	public List<Product> filter(String keyword) {
		List<Product> products = new ArrayList<Product>();
		for (Product product : findall()) {
			if (product.getCategory().equalsIgnoreCase(keyword)) {
				products.add(product);
			}
		}
		return products;
	}

	public List<Product> search(String keyword) {
		List<Product> products = new ArrayList<Product>();
		for (Product product : findall()) {
			if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
				products.add(product);
			}
		}
		return products;
	}
}
