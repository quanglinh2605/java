package com.demo.controllers.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.demo.entities.Account;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
@Namespace("/account")
public class AccountAction extends ActionSupport {
	private Account account;
	
	@VisitorFieldValidator
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@SkipValidation
	@Action(value="index", results= {@Result(name = SUCCESS, location="/account/register.jsp")})
	public String index() {
		return SUCCESS;
	}
	@Action(value = "save", results = {
			@Result(name = SUCCESS, location = "/account/success.jsp"),
			@Result(name=INPUT, location = "/account/register.jsp")})
	public String save() {
		return SUCCESS;
	}
	@Override
	public void validate() {
		if(account.getUsername().equalsIgnoreCase("abc")) {
			addFieldError("account.username", getText("errors.existing"));
		}
	}
	
}
