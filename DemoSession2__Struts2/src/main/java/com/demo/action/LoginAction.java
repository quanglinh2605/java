package com.demo.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Account;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/login")
public class LoginAction extends ActionSupport {
	private Account account;	
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Action(value = "index",results = {@Result(name=SUCCESS, location = "/login/index.jsp")})
	public String index() {
		return SUCCESS;
	}
	@Action(value = "login", results = 
		{
				@Result(name=SUCCESS, location = "/login/welcome.jsp"),
				@Result(name=ERROR, location = "/login/index.jsp")
		})
	public String login() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(this.account.getUsername().equalsIgnoreCase("admin") && this.account.getPassword().equalsIgnoreCase("123")) {
			session.put("username", this.account.getUsername());
			return SUCCESS;
		}
		else {
			this.errorMessage="Invalid";
			return ERROR;
		}
	}
	@Action(value = "logout", results = {@Result(name=SUCCESS,type = "redirectAction", params = {"namespace","/login","actionName","index"})})
	public String logout() {
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}
}
