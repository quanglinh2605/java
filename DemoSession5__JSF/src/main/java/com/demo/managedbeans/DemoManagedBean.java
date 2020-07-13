package com.demo.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Product;
import com.demo.models.ProductModel;

@SessionScoped
@ManagedBean(name = "demoManagedBean")
public class DemoManagedBean {
	private double max;
	private double min;
	private List<Product> products;
	
	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private Product product;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DemoManagedBean() {
		ProductModel productModel = new ProductModel();
		this.products = productModel.findAll();
	}
	
	private int age;
	private String username;
	private double price;
	private boolean status;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String index2() {
		this.products = new ProductModel().findAll();
		this.product = new ProductModel().find("pd01");
		this.age=20;
		this.username="abc";
		this.price = 4.5;
		this.status = true;
		return "index2?faces-redirect=true";
	}
	
	public String index3(int id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "index3?faces-redirect=true";
	}
	
	public String details(Product product) {
		this.product = product;
		return "details?faces-redirect=true";
	}
	
	public String searchbyPrice() {
		ProductModel productModel = new ProductModel();
		this.products = productModel.findbyPrice(this.min, this.max);
		return "products?faces-redirect=true";
	}
}
