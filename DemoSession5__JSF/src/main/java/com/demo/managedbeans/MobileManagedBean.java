package com.demo.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Mobile;
import com.demo.entities.Student;
import com.demo.models.MobileModel;
import com.demo.models.StudentModel;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

@SessionScoped
@ManagedBean(name = "mobileManagedBean")
public class MobileManagedBean {
	private List<Mobile> mobiles = new ArrayList<Mobile>();
	private Mobile mobile;
	private int id;
	private String keyword;
	private double min;
	private double max;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public List<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}
	public String index() {
		MobileModel mobileModel = new MobileModel();
		this.mobiles = mobileModel.findAll();
		return "/mobile/index?faces-redirect=true";
	}
	public String index2() {
		return "/mobile/index2?faces-redirect=true";
	}
	public String index3() {
		return "/mobile/index3?faces-redirect=true";
	}
	public void find() {
		MobileModel mobileModel = new MobileModel();
		this.mobile = mobileModel.getbyid(this.id);
	}
	public void searchName() {
		MobileModel mobileModel = new MobileModel();
		this.mobiles = mobileModel.search(this.keyword);
	}
	public void searchPrice() {
		MobileModel mobileModel = new MobileModel();
		this.mobiles = mobileModel.search(this.min, this.max);
	}
}
