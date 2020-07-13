package com.demo.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Student;
import com.demo.models.StudentModel;

@SessionScoped
@ManagedBean(name = "studentManagedBean")
public class StudentManagedBean {
	private List<Student> students;
	private Student student;
	private String keyword;
	private String username;
	private String password;
	
	

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String index() {
		StudentModel model = new StudentModel();
		this.students = model.findAll();
		return "/student/index?faces-redirect=true";
	}
	public String add() {
		this.student = new Student();
		return "/student/add?faces-redirect=true";
	}
	public String create() {
		StudentModel studentModel = new StudentModel();
		this.student.setPassword(BCrypt.hashpw(this.student.getPassword(), BCrypt.gensalt()));
		boolean result = studentModel.create(this.student);
		if(result) {
			this.students = studentModel.findAll();			
			return "/student/index?faces-redirect=true";
		}else {
			return "/student/add?faces-redirect=true";
		}
	}
	public String edit(Student student) {
		this.student = student;
		return "/student/edit?faces-redirect=true";
	}
	public String update() {
		StudentModel studentModel = new StudentModel();
		if(this.student.getPassword()!="") {
			this.student.setPassword(BCrypt.hashpw(this.student.getPassword(), BCrypt.gensalt()));
		}else {
			this.student.setPassword(studentModel.getbyid(this.student.getId()).getPassword());
		}
		if(studentModel.update(this.student)) {
			this.students = studentModel.findAll();
			return "/student/index?faces-redirect=true";
		}else {
			return "/student/edit?faces-redirect=true";
		}
	}
	public String delete(Student student) {
		StudentModel studentModel = new StudentModel();
		studentModel.delete(student);
		this.students = studentModel.findAll();
		return "/student/index?faces-redirect=true";
	}
	public String search() {
		StudentModel studentModel = new StudentModel();
		this.students = studentModel.search(this.keyword);
		return "/student/index?faces-redirect=true";
	}
	public String login() {
		StudentModel studentModel = new StudentModel();
		if(studentModel.login(this.password, this.username)) {
			return "/student/success?faces-redirect=true";
		}
		return "/student/index?faces-redirect=true";
	}
}
