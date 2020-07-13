package com.demo.controllers.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/news")
public class NewsAction extends ActionSupport {
	@Action(value="index", results = {@Result(name = SUCCESS, type = "tiles", location = "news.index")})
	public String index() {
		return SUCCESS;
	}	
}
