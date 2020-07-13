package com.demo.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "homeManagedBean")
public class HomeManagedBean {
	public String index() {
		return "home?faces-redirect=true";
	}
}
