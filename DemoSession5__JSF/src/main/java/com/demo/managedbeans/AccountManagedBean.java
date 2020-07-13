package com.demo.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Account;
import com.demo.entities.Language;
import com.demo.entities.Role;
import com.demo.models.LanguageModel;
import com.demo.models.RoleModel;

@ManagedBean(name = "accountManagedBean")
@SessionScoped
public class AccountManagedBean {
	public Account account;
	public List<Language> languages;
	public List<Role> roles;
	private String keyword;
	private String username;
	private String password;
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountManagedBean() {
		LanguageModel languageModel = new LanguageModel();
		RoleModel model = new RoleModel();
		this.roles = model.findAll();
		this.languages = languageModel.findAll();
		this.account = new Account();
		this.account.setUsername("abc123");
		this.account.setStatus(true);
		this.account.setGender("f");
		this.account.setLanguages(new String[] {"lang1","lang3"});
		this.account.setId(123);
	}
	public String save() 
	{
		System.out.println("username: " + this.account.getUsername());
		System.out.println("password: " + this.account.getPassword());
		System.out.println("description: " + this.account.getDescription());
		System.out.println("Status: " + this.account.isStatus());
		System.out.println("languages");
		for (String lang : this.account.getLanguages()) {
			System.out.println("\t" + lang);
		}
		System.out.println("gender:" + this.account.getGender());
		System.out.println("role: " + this.account.getRole());
		System.out.println("ID: " + this.account.getId());
		return"success?faces-redirect=true";
	}
	public String search() {
		System.out.println("keyword: " + this.keyword);
		return "result?faces-redirect=true";
	}
	public String process_login() {
		if(this.username.equalsIgnoreCase("admin")&&this.password.equalsIgnoreCase("123")) {			
			return "success?faces-redirect=true";	
		}else {
			this.errorMessage="invalid";
			return "Login?faces-redirect=true";
		}		
	}
	public String login() {
		return "Login?faces-redirect=true";
	}
}