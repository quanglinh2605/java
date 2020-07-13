package com.demo.entities;

public class Student {

	private String id;
	private String name;
	private double score;
	private String description;

	public String getId() {
		return id;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student(String id, String name, double score, String description) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.description = description;
	}

	public Student() {
		super();
	}

}
