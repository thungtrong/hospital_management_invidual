package com.hospitalmanagement.model;

public class Illness {
	private Integer id;
	private String name;
	private String description;
	public Illness() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Illness(Integer id, String name, String description) {
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
		return "Illness [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	public void copyTo(Illness illness)
	{
		illness.name = this.name;
		illness.description = this.description;
	}
	
}
