package com.hospitalmanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="doctor")
@NamedQueries({
	@NamedQuery(
			name="findDoctorsByDepartment",
			query = "from Doctor where department.id=?"
			)
})
@Inheritance
public class Doctor extends Person{
	@Id
	@SequenceGenerator(name = "sequence_doctor_pk", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence_doctor_pk")
	private Long id;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name="doctor_department_id_fk")
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(Long id, String name, Character gender, String phoneNumber, String address, Date dateOfBirth) {
		super(name, gender, phoneNumber, address, dateOfBirth);
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", gender=" + gender
				+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", department="+ department.getName()+"]";
	}
	
	
}
