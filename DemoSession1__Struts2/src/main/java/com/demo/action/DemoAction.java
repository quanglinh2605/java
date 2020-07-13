package com.demo.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/demo")
public class DemoAction extends ActionSupport {

	private int age;
	private double price;
	private String username;

	// Query String
	private int id1;
	private String id2;
	private String id3;

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/demo/index.jsp") })
	public String index() {
		return SUCCESS;
	}

	@Action(value = "demo2", results = { @Result(name = SUCCESS, location = "/demo/index2.jsp") })
	public String demo2() {
		this.age = 20;
		this.price = 4.5;
		this.username = "abc";
		return SUCCESS;
	}

	@Action(value = "demo3", results = { @Result(name = SUCCESS, location = "/demo/index.jsp") })
	public String demo3() {
		System.out.println("id1: " + this.id1);
		return SUCCESS;
	}

	@Action(value = "demo4", results = { @Result(name = SUCCESS, location = "/demo/index.jsp") })
	public String demo4() {
		System.out.println("id1: " + this.id1);
		System.out.println("id2: " + this.id2);
		System.out.println("id3: " + this.id3);
		return SUCCESS;
	}

	@Action(value = "demo5", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/product", "actionName", "index" }) })
	public String demo5() {
		return SUCCESS;
	}

	@Action(value = "demo6", results = { @Result(name = SUCCESS, location = "/demo/demo6.jsp") })
	public String demo6() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("username", "acc1");
		session.put("age", 20);
		session.put("product", new Product("p01", "name 1", 123));
		return SUCCESS;
	}

	@Action(value = "demo7", results = { @Result(name = SUCCESS, location = "/demo/demo6.jsp") })
	public String demo7() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}

}
