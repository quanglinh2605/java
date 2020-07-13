package com.demo.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.demo.entities.Student;
import com.demo.models.StudentModel;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/student")
public class StudentAction extends ActionSupport {

	private List<Student> students;
	private String id;
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/student/index.jsp") })
	public String index() {
		StudentModel studentModel = new StudentModel();
		this.students = studentModel.findAll();
		return SUCCESS;
	}

	@Action(value = "detail", results = { @Result(name = SUCCESS, location = "/student/detail.jsp") })
	public String details() {
		StudentModel studentModel = new StudentModel();
		this.student = studentModel.find(this.id);
		return SUCCESS;
	}

}
