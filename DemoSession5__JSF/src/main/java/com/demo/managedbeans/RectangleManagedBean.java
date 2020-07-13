package com.demo.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "rectangleManagedBean")
@SessionScoped
public class RectangleManagedBean {
	private int chieudai;
	private int chieurong;
	private String action;
	private int kq;
	public RectangleManagedBean() {
		this.setAction("chuvi");
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getKq() {
		return kq;
	}
	public void setKq(int kq) {
		this.kq = kq;
	}
	public String result() {
		if(action.equalsIgnoreCase("chuvi")) {
			this.kq = (this.chieudai+this.chieurong)*2;
		}
		if(action.equalsIgnoreCase("dientich")) {
			this.kq = this.chieudai * this.chieurong;
		}
		return "rectangle?faces-redirect=true";
	}
}
