package com.demo.entities;

public class Language {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	
	public Language() {
		super();
	}

	public Language(String id, String name) {
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
