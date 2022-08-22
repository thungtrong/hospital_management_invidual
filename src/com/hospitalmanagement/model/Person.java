package com.hospitalmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Person {
	protected String name; 
	protected Character gender;
	@Column(name = "phone_number")
	protected String phoneNumber;
	protected String address;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	protected Date dateOfBirth;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, Character gender, String phoneNumber, String address, Date dateOfBirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
