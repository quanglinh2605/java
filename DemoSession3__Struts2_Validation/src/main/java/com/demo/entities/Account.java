package com.demo.entities;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class Account {
	private String username;
	private String password;
	private String email;
	
	@RequiredStringValidator(key="errors.required", trim = true)
	@StringLengthFieldValidator(maxLength = "15", minLength = "8", key = "errors.rangestring", trim=true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@EmailValidator(key = "errors.email")
	@RequiredStringValidator(key="error.required", trim = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@RequiredStringValidator(key = "errors.required", trim = true)
	@StringLengthFieldValidator(maxLength = "6", minLength = "3", key = "errors.rangestring", trim = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
