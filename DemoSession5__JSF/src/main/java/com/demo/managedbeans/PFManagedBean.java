package com.demo.managedbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "pFManagedBean")
public class PFManagedBean {
	private Date birthday;
	private String detail;
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String index() {
		return "/primefaces/index?faces-redirect=true";
	}
	public String save() {
		System.out.println(this.birthday);
		System.out.println(this.detail);
		return "/primefaces/success?faces-redirect=true";
	}
}
