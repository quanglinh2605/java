package com.demo.entities;

public class Role {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	
	public Role() {
		super();
	}

	public Role(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
