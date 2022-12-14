package com.hospitalmanagement.model;

import java.util.List;

// mapping use xml
public class Department {
	private Integer id;
	private String name;
	private String description;
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(Integer id)
	{
		this.id = id;
	}
	
	public Department(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	
	
	
}
