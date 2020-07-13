package com.demo.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Account;
import com.demo.entities.Language;
import com.demo.entities.Role;
import com.demo.model.LanguageModel;
import com.demo.model.RoleModel;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("/account")

public class AccountAction extends ActionSupport{
	private Account account;
	private List<Language> languages;
	private List<Role> roles;
	private String keyword;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	@Action(value="index", results = { @Result( name = SUCCESS, location="/account/index.jsp")})
	public String index() {
		LanguageModel languageModel = new LanguageModel();
		RoleModel roleModel = new RoleModel();
		this.roles = roleModel.findAll();
		this.languages = languageModel.findAll();
		
		this.account = new Account();
		this.account.setUsername("abc");
		this.account.setId(123);
		this.account.setLanguages(new String[]{ "lang1","lang3" });
		this.account.setGender("m");
		this.account.setRole("r3");
		return SUCCESS;
	}
	@Action(value="save", results = { @Result(name = SUCCESS,location="/account/success.jsp")})
	public String save() {
		System.out.println("Username: " + account.getUsername());
		System.out.println("password: " + account.getPassword());
		System.out.println("description: " + account.getDescription());
		System.out.println("status: " + account.isStatus());
		System.out.println("Languages");
		for(String language : account.getLanguages()) {
			System.out.println("\t" + language);
		}
		System.out.println("Gender: " + account.getGender());
		System.out.println("Role: " + account.getRole());
		System.out.println("ID: " + account.getId());
		return SUCCESS;
	}
	@Action(value="search", results = { @Result(name = SUCCESS,location="/account/success.jsp")})
	public String search() {
		System.out.println("Keyword: " + keyword);
		return SUCCESS;
	}
}
