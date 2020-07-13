package com.demo.entities;

public class Item {
	private Mobile mobile;
	private int quantity;
	
	public Item() {
		super();
	}
	public Item(Mobile mobile, int quantity) {
		super();
		this.mobile = mobile;
		this.quantity = quantity;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
