package models;

import java.util.ArrayList;
import java.util.List;

import entities.employee;

public class employeeModel {
	private List<employee> employees;

	public employeeModel() {
		employees = new ArrayList<employee>();
		employees.add(new employee("e01", "name 1", "address 1", "123", "a@gmail.com", 200));
		employees.add(new employee("e02", "name 2", "address 2", "456", "b@gmail.com", 300));
		employees.add(new employee("e03", "name 3", "address 3", "789", "c@gmail.com", 400));
		employees.add(new employee("e04", "name 4", "address 4", "865", "d@gmail.com", 500));
	}

	public List<employee> findall() {
		return employees;
	}

	public employee find(String id) {
		for (employee emp : employees) {
			if (emp.getId().equals(id)) {
				return emp;
			}
		}
		return null;
	}
}
