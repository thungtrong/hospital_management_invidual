package com.hospitalmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="test_form")
public class TestForm {
	@Id
	@SequenceGenerator(name="sequence_test_form_pk", allocationSize = 1)
	@GeneratedValue(generator = "sequence_test_form_pk", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "test")
	private List<TestFormDetail> results;

	public TestForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestForm(Long id, Date creationDate, Patient patient, List<TestFormDetail> details) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.patient = patient;
		this.results = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<TestFormDetail> getDetails() {
		return results;
	}

	public void setDetails(List<TestFormDetail> details) {
		this.results = details;
	}
	
	
}
