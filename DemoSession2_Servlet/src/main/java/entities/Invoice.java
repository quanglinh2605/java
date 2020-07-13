package entities;

import java.util.Date;
import java.util.List;

public class Invoice {
	private String id;
	private String name;
	private Date created;
	private String payment;
	private Customer customer;
	private List<Product> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Invoice() {
		super();
	}

	public Invoice(String id, String name, Date created, String payment, Customer customer, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.payment = payment;
		this.customer = customer;
		this.products = products;
	}

}
