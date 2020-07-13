package com.demo.controller.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Account;
import com.demo.models.AccountModels;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.bind.v2.runtime.Name;

@Namespace("/account")
public class AccountAction extends ActionSupport {
	private Account account;
	private List<Account> accounts;
	private int id;
	private String keyword;
	private String username;
	private String password;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/account/index.jsp") })
	public String index() {
		AccountModels accountModels = new AccountModels();
		this.accounts = accountModels.findAll();
		return SUCCESS;
	}

	@Action(value = "AddNew", results = { @Result(name = SUCCESS, location = "/account/add.jsp") })
	public String Addnew() {
		this.account = new Account();
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/account", "actionName", "index" }) })
	public String delete() {
		AccountModels accountModels = new AccountModels();
		account = accountModels.getbyid(id);
		accountModels.delete(account);
		return SUCCESS;
	}

	@Action(value = "edit", results = { @Result(name = SUCCESS, location = "/account/edit.jsp") })
	public String edit() {
		AccountModels accountModels = new AccountModels();
		this.account = accountModels.getbyid(this.id);
		return SUCCESS;
	}

	@Action(value = "update", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/account", "actionName", "index" }), @Result(name = ERROR, location = "/account/edit.jsp") })
	public String update() {
		if (this.account.getPassword() != null || !this.account.getPassword().isEmpty()) {
			this.account.setPassword(BCrypt.hashpw(this.account.getPassword(), BCrypt.gensalt()));
		}
		AccountModels accountModels = new AccountModels();
		if (accountModels.update(this.account)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "Save", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/account", "actionName", "index" }), @Result(name = ERROR, location = "/account/add.jsp") })
	public String Save() {
		AccountModels accountModels = new AccountModels();
		String hash = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
		account.setPassword(hash);
		boolean result = accountModels.create(account);
		if (result == true) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "search", results = { @Result(name = SUCCESS, location = "/account/index.jsp") })
	public String search() {
		AccountModels accountModels = new AccountModels();
		this.accounts = accountModels.search(keyword);
		return SUCCESS;
	}

	@Action(value = "login", results = { @Result(name = SUCCESS, location = "/account/login.jsp") })
	public String login() {
		return SUCCESS;
	}

	@Action(value = "login_process", results = { 
			@Result(name = SUCCESS, location = "/account/success.jsp"),
			@Result(name= ERROR, location = "/account/login.jsp")
	})
	public String login_process() {
		AccountModels accountModels = new AccountModels();
		if (accountModels.login(this.password, this.username)) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("username", this.username);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	@Action(value="logout", results = {
			@Result(name = SUCCESS, type="redirectAction", params = {"namespace","/account","actionName","login"})
	})
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}
}
