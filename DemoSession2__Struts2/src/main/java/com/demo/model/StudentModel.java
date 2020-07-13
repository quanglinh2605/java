package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Student;

public class StudentModel {

	private List<Student> students;

	public StudentModel() {
		students = new ArrayList<Student>();
		students.add(new Student("st01", "Mike", 6.7, "good"));
		students.add(new Student("st02", "Peter", 8.9, "good"));
		students.add(new Student("st03", "Henry", 7.4, "good"));
	}

	public List<Student> findAll() {
		return students;
	}

	public Student find(String id) {
		for (Student student : students) {
			if (student.getId().equalsIgnoreCase(id)) {
				return student;
			}
		}
		return null;
	}
	
	public List<Student> Search(String keyword){
		List<Student> list = new ArrayList<Student>();
		for(Student student : students) {
			if(student.getName().contains(keyword)) {
				list.add(student);
			}
		}
		return list;
	}
}
