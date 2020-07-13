package com.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Product;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/product")
public class ProductAction extends ActionSupport {

	private Product product;
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/product/index.jsp") })
	public String index() {
		this.product = new Product("p01", "name 1", 4.5);

		this.products = new ArrayList<Product>();
		this.products.add(new Product("p01", "name 1", 4.5));
		this.products.add(new Product("p02", "name 2", 2));
		this.products.add(new Product("p03", "name 3", 6));

		return SUCCESS;
	}

}
