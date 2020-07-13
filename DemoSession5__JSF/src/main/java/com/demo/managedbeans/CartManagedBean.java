package com.demo.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Item;
import com.demo.entities.Mobile;
import com.demo.entities.Student;
import com.demo.models.MobileModel;
import com.demo.models.StudentModel;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

@SessionScoped
@ManagedBean(name = "cartManagedBean")
public class CartManagedBean {
	private List<Item> cart = new ArrayList<Item>();	
	
	public List<Item> getCart() {
		return cart;
	}

	public void setCart(List<Item> cart) {
		this.cart = cart;
	}
	
	public String buy(Mobile mobile) {
		int index = exists(mobile, this.cart);
		if(index == -1) {
			this.cart.add(new Item(mobile,1));
		}else {
			int quantity = this.cart.get(index).getQuantity()+1;
			this.cart.get(index).setQuantity(quantity);
		}
		return "/cart/index?faces-redirect=true"; 
	}	
	public String index(Mobile mobile) {
		return "/cart/index?faces-redirect=true";
	}
	
	public String remove(int index) {
		this.cart.remove(index);
		return "/cart/index?faces-redirect=true";
	}
	
	public String update() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String[] quantities = request.getParameterValues("quantity");
		int i = 0;
		for(String quantity: quantities) {
			int count = Integer.parseInt(quantity);
			this.cart.get(i).setQuantity(count);
			i++;
		}
		return "/cart/index?faces-redirect=true";
	}
	
	public double total() {
		double s = 0;
		for(Item item: this.cart) {
			s += item.getMobile().getPrice() * item.getQuantity();
		}
		return s;
	}
	
	private int exists(Mobile mobile, List<Item> cart) {
		for(int i = 0; i < cart.size();i++) {
			if(cart.get(i).getMobile().getId()==mobile.getId()) {
				return i;
			}
		}
		return -1;
	}
}
