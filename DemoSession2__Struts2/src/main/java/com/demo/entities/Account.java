package com.demo.entities;

public class Account {
	private int id;
	private String username;
	private String password;
	private String description;
	private boolean status;
	private String[] languages;
	private String gender;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Account(int id,String username, String password,String gender, String description, boolean status, String[] langguages) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.description = description;
		this.status = status;
		this.languages = langguages;
		this.gender = gender;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public Account() {
		super();
	}
}
