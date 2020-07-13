package com.demo.controllers.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/test")
public class TestAction extends ActionSupport{
	@Action(value ="index", results = {@Result(name=SUCCESS,location = "/test/index.jsp")})
	public String index() {
		return SUCCESS;
	}
}
