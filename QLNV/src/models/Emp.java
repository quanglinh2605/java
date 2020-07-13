package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import apps.Repositories;

public class Emp {
	private int empNo;

	public void setempNo(int value) {
		empNo = value;
	}

	public int getempNo() {
		return empNo;
	}

	private String Ename;

	public void setEname(String value) {
		Ename = value;
	}

	public String getEname() {
		return Ename;
	}

	private String Job;

	public void setJob(String value) {
		Job = value;
	}

	public String getJob() {
		return Job;
	}

	private Emp Mgr;

	public void setMgr(Emp value) {
		Mgr = value;
	}

	public Emp getMgr() {
		return Mgr;
	}

	private Date HireDate;

	public void setHireDate(Date value) {
		HireDate = value;
	}

	public Date getHireDate() {
		return HireDate;
	}

	private double Sal;

	public void setSal(double value) {
		Sal = value;
	}

	public double getSal() {
		return Sal;
	}

	private double Comm;

	public void setComm(double value) {
		Comm = value;
	}

	public double getComm() {
		return Comm;
	}

	private Dept MyDept = new Dept();

	public void setMyDept(Dept value) {
		MyDept = value;
	}

	public Dept getMyDept() {
		return MyDept;
	}

	public void NewInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("thong tin nhan vien");
		System.out.print("ten nhan vien: ");
		Ename = sc.nextLine();
		System.out.print("chuc vu");
		setJob(sc.nextLine());
		System.out.println("Ban co muon chon nguoi quan ly?y/n");
		String fl = sc.nextLine();
		int mgr = 0;
		if (fl == "y") {
			Repositories rep = new Repositories();
			rep.GetAllEmp();
			rep.ShowAllEmp();
			System.out.println("nhap ma nguoi quan ly dua tren danh sach");
			mgr = sc.nextInt();
			setMgr(rep.GetEmpById(mgr));
		}
		String hd = sc.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			setHireDate(format.parse(hd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("luong");
		setSal(sc.nextDouble());
		System.out.println("tro cap");
		setComm(sc.nextDouble());
		System.out.println("chon phong ban");
		Repositories rep = new Repositories();
		rep.GetAllDepts();
		rep.ShowAllDepts();
		int deptno = sc.nextInt();
		setMyDept(rep.GetDeptById(deptno));
	}

	public void Info() {
		System.out.println("thong tin nhan vien:");
		System.out.println("ma nhan vien: " + getempNo());
		System.out.println("ten nhan vien: " + getEname());
		System.out.println("Chuc vu: " + getJob());
		System.out.println("nguoi quan ly: " + Mgr.getEname());
		System.out.println("ngay vao lam: " + getHireDate());
		System.out.println("luong: " + getSal());
		System.out.println("tro cap: " + getComm());
		System.out.println("phong: " + MyDept.getDname());
	}
}
