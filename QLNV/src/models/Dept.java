package models;

import java.util.Scanner;

public class Dept {
	private int DeptNo;

	public void setDeptNo(int value) {
		DeptNo = value;
	}

	public int getDeptNo() {
		return DeptNo;
	}

	private String Dname;

	public void setDname(String value) {
		Dname = value;
	}

	public String getDname() {
		return Dname;
	}

	private String Loc;

	public void setLoc(String value) {
		Loc = value;
	}

	public String getLoc() {
		return Loc;
	}

	private Emps lsEmp = new Emps();

	public void setlsEmp(Emps value) {
		lsEmp = value;
	}

	public Emps getlsEmp() {
		return lsEmp;
	}

	/**
	 * insert new information of department
	 */
	public void NewInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Department information");
		System.out.print("Dept Name");
		setDname(sc.nextLine());
		System.out.print("Location:");
		setLoc(sc.nextLine());
		System.out.println("-----------");

	}

	public void UpdateInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Department information");
		System.out.println("DeptNo:" + DeptNo);
		System.out.print("Dept Name old:" + Dname);
		setDname(sc.nextLine());
		System.out.print("Location old:" + Loc);
		setLoc(sc.nextLine());
		System.out.println("-----------");
	}

	public void Info() {
		System.out.println("department information:");
		System.out.println("Dept No:" + getDeptNo());
		System.out.println("Dept Name:" + getDname());
		System.out.println("Location:" + getLoc());
		System.out.println("-------------");
	}

}
