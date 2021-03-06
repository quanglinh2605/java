package entities;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private int id;
	private String name;
	private List<Province> provinces = new ArrayList<Province>();

	public Country() {
		super();
	}

	public Country(int id, String name, List<Province> provinces) {
		super();
		this.id = id;
		this.name = name;
		this.provinces = provinces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

}
