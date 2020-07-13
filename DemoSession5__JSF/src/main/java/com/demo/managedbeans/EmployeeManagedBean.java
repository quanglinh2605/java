package com.demo.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Employee;

@ManagedBean(name = "employeeManagedBean")
@SessionScoped
public class EmployeeManagedBean {
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public EmployeeManagedBean() {
		this.employee = new Employee();
	}
	public String register() {
		return "/employee/register?faces-redirect=true";
	}
	public String save() {
		return "/employee/success?faces-redirect=true";
	}
}

