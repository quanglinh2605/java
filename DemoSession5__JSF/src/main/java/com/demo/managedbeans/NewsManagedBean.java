package com.demo.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "newsManagedBean")
public class NewsManagedBean {
	public String index() {
		return "news?faces-redirect=true";
	}
}
