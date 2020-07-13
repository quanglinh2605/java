package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Product;

public class ProductModel {
	List<Product> products = new ArrayList<Product>();
	public ProductModel() {
		products.add(new Product("pd01", "product 1", 3.5, 5, "image1.jpg"));
		products.add(new Product("pd02", "product 2", 2.2, 4, "image2.jpg"));
		products.add(new Product("pd03", "product 3", 4.6, 8, "image1.jpg"));
		products.add(new Product("pd04", "product 4", 7.2, 11, "image3.jpg"));
		products.add(new Product("pd05", "product 5", 3.8, 15, "image2.jpg"));
	}
	public List<Product> findAll(){
		return products;
	}
	public Product find(String id) {
		for (Product product : products) {
			if(product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}
	public List<Product> findbyPrice(double min, double max){
		List<Product> result = new ArrayList<Product>();
		for (Product product : findAll()) {
			if(product.getPrice()>min && product.getPrice()<max) {
				result.add(product);
			}
		}
		return result;
	}
}
