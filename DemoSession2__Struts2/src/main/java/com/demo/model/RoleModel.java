package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Language;
import com.demo.entities.Role;

public class RoleModel {
	private List<Role> roles;
	public RoleModel() {
		roles = new ArrayList<Role>();
		roles.add(new Role("r1", "Role 1"));
		roles.add(new Role("r2", "Role 2"));
		roles.add(new Role("r3", "Role 3"));
		roles.add(new Role("r4", "Role 4"));
		roles.add(new Role("r5", "Role 5"));
	}
	public List<Role> findAll(){
		return roles;
	}
}
