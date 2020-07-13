package com.demo.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.demo.entities.Employee;

@SessionScoped
@ManagedBean(name = "ajaxManagedBean")
public class AjaxManagedBean {
	private String result1 = "";
	private String result2="";
	private String fullname = "";
	private int a;
	private int result3;
	private String firstname="";
	private String lastname = "";
	private Employee employee = new Employee();
	private String result4;
	private List<Employee> list = new ArrayList<Employee>();
	private int chieudai;
	private int chieurong;
	private int kq;
	private double minprice;
	private double maxprice;	

	public double getMinprice() {
		return minprice;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}

	public double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}

	public int getChieudai() {
		return chieudai;
	}
	public void setChieudai(int chieudai) {
		this.chieudai = chieudai;
	}
	public int getChieurong() {
		return chieurong;
	}
	public void setChieurong(int chieurong) {
		this.chieurong = chieurong;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getResult4() {
		return result4;
	}
	public void setResult4(String result4) {
		this.result4 = result4;
	}
	public int getResult3() {
		return result3;
	}
	public void setResult3(int result3) {
		this.result3 = result3;
	}
	public String getResult1() {
		return result1;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String index() {
		return "/ajax/index?faces-redirect=true";
	}
	public void demo1() {
		this.result1 = "hello";
	}
	public void demo2() {
		this.result2 = "hi " + this.fullname;
	}
	public void chuvi() {
		this.result3 = this.a*4;
	}
	public void dientich() {
		this.result3 = this.a*this.a;
	}
	public void demo4() {
		this.result4 = this.firstname +" " + this.lastname;
	}
	public void demo5() {
		this.employee = new Employee("abc","123","http://google.com","a@gmail.com",22);
	}
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public void demo6() {
		this.list.add(new Employee("acc1","123","http://google.com","a@gmail.com",22));
		this.list.add(new Employee("acc2","123","http://google.com","a@gmail.com",23));
		this.list.add(new Employee("acc3","123","http://google.com","a@gmail.com",24));
	}
	public int getKq() {
		return kq;
	}
	public void setKq(int kq) {
		this.kq = kq;
	}
	public void chuviHCN() {
		this.kq = (this.chieudai + this.chieurong)*2;
	}
	public void dientichHCN() {
		this.kq = this.chieudai * this.chieurong;
	}
	public void sum() {
		System.out.println(this.maxprice + this.minprice);
	}
}
