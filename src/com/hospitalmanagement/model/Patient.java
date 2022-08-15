package com.hospitalmanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column
	private String name;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column
	private Character gender;
	private String address;
	@Column(name="phone_number")
	private String phoneNumber;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Integer id, String name, Date dateOfBirth, Character gender, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void copyTo(Patient patient)
	{
		patient.name = this.name;
		patient.dateOfBirth = this.dateOfBirth;
		patient.gender = this.gender;
		patient.address = this.address;
		patient.phoneNumber = this.phoneNumber;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
