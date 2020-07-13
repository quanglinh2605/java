package com.demo.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "aboutUsManagedBean")
public class AboutUsManagedBean {
	public String index() {
		return "aboutus?faces-redirect=true";
	}
}
