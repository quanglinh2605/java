package com.demo.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Customer;
import com.demo.models.CustomerModel;

@SessionScoped
@ManagedBean(name = "customerManagedBean")
public class CustomerManagedBean {
	private List<Customer> listCus;
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getListCus() {
		return listCus;
	}

	public void setListCus(List<Customer> listCus) {
		this.listCus = listCus;
	}
	public CustomerManagedBean() {
		CustomerModel customerModel = new CustomerModel();
		this.listCus = customerModel.findAll();
	}
	public String index() {
		CustomerModel customerModel = new CustomerModel();
		this.listCus = customerModel.findAll();
		return "/index?faces-redirect = true";			
	}
	
	public String add() {
		this.customer = new Customer();
		return "/customer/add?faces-redirect=true";
	}
	public String create() {
		CustomerModel customerModel = new CustomerModel();
		boolean result = customerModel.create(customer);
		if(result) {
			this.listCus = customerModel.findAll();
			return "/index/faces-redirect=true";
		}else {
			return "/customer/add?faces-redirect=true";
		}
	}
	
	public String edit(Customer customer) {
		this.customer = customer;		
		return "/customer/edit?faces-redirect=true";
	}
	public String update() {
		CustomerModel customerModel = new CustomerModel();
		boolean result = customerModel.update(this.customer);
		if(result) {				
			return "/index?faces-redirect=true";
		}else {
			return "/customer/edit?faces-redirect=true";
		}
	}
}
