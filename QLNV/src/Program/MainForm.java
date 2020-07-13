package Program;

import java.sql.SQLException;
import java.util.Scanner;

import apps.Repositories;
import models.Dept;

public class MainForm {
	public static void main(String[] args) {
		Repositories rep = new Repositories();
		int task = 0;
		while (task != 20) {
			System.out.println("chon chuc nang");
			System.out.println("1.Tao phong ban");
			System.out.println("2.danh sach phong ban");
			System.out.println("3.Chinh sua thong tin phong ban");
			System.out.println("4.xoa phong ban");
			System.out.println("20.Thoat chuong trinh");
			// ------------
			Scanner sc = new Scanner(System.in);
			task = sc.nextInt();
			switch (task) {
			case 1:
				rep.CreateDept();
				break;
			case 2:
				rep.GetAllDepts();// get all from database
				rep.ShowAllDepts();// show list dept
				break;
			case 3:
				// b1: xay dung ham lay ra phong ban
				System.out.println("nhap ma phong can tim");
				int deptno = sc.nextInt();
				Dept currentDept = rep.GetDeptById(deptno);
				// b2: xay dung ham chinh sua thong tin phong ban trong database
				currentDept.UpdateInfo();
				try {
					boolean result = rep.UpdateDept(currentDept);
					if (result == true) {
						System.out.println("cap nhat thong tin thanh cong");
						currentDept = rep.GetDeptById(deptno);
						currentDept.Info();
					} else {
						System.out.println("cap nhat thong tin that bai");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("nhap ma phong ban can xoa");
				int madept = sc.nextInt();
				Dept curdept = new Dept();
				curdept = rep.GetDeptById(madept);
				try {
					boolean kq = rep.DeleteDept(curdept);
					if (kq == true) {
						System.out.println("xoa thanh cong");
						rep.GetAllDepts();
						rep.ShowAllDepts();
					} else {
						System.out.println("xoa that bai");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	}
}
