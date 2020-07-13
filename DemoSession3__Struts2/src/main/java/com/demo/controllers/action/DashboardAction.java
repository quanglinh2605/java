package com.demo.controllers.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin/dashboard")
public class DashboardAction extends ActionSupport {
	@Action(value="index", results = {@Result(name = SUCCESS, type = "tiles", location = "admin.dashboard.index")})
	public String index() {
		return SUCCESS;
	}
}
