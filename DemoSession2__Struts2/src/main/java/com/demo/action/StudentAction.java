package com.demo.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Account;
import com.demo.entities.Student;
import com.demo.model.StudentModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private String keyword;
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Action(value = "index", results = {@Result(name = SUCCESS,location = "/student/index.jsp")})
	public String index() {
		StudentModel studentModel = new StudentModel();
		this.students = studentModel.findAll();
		return SUCCESS;
	}
	
	@Action(value="search",results = {@Result(name = SUCCESS,location = "/student/index.jsp")})
	public String search() {
		StudentModel studentModel = new StudentModel();
		this.students = studentModel.Search(keyword);
		return SUCCESS;
	}
}
