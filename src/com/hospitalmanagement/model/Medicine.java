package com.hospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	@Id
	private Integer id;
	private String name;
	private String unit;
	private String instruction;
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(Integer id, String name, String unit, String instruction) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.instruction = instruction;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", unit=" + unit + ", instruction=" + instruction + "]";
	}
	public void copyTo(Medicine other) {
		other.name = this.name;
		other.unit = this.unit;
		other.instruction = this.instruction;
		
	}
	
	
}
