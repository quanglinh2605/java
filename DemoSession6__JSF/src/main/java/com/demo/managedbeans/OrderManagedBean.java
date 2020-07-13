package com.demo.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Order;
import com.demo.models.OrderModel;

@SessionScoped
@ManagedBean(name = "orderManagedBean")
public class OrderManagedBean {
	private Order order;
	private List<Order> orders;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String index() {
		OrderModel model = new OrderModel();
		this.orders = model.findAll();
		return "orders/index?faces-redirect=true";
	}
	public String add(int id) {
		this.order = new Order();		
		this.order.setCustomerId(id);		
		return "/orders/add?faces-redirect=true";
	}
	public String create() {
		OrderModel model = new OrderModel();
		boolean result = model.create(this.order);
		if(result) {
			this.orders = model.getbyCusId(this.order.getCustomerId());
			return "/orders/index?faces-redirect=true";
		}else {
			return "/orders/add?faces-redirect=true";
		}
	}
	public String delete(Order order, int cusId) {
		OrderModel orderModel = new OrderModel();
		orderModel.delete(order);
		this.orders = orderModel.getbyCusId(cusId);
		return "/orders/index?faces-redirect=true";
		
	}
	public String viewOrders(int cusId) {
		OrderModel orderModel = new OrderModel();
		this.id = cusId;
		this.orders = orderModel.getbyCusId(cusId);
		return "/orders/index?faces-redirect=true";			
	}
}
