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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="prescription")
public class Prescription {
	@Id
	@SequenceGenerator(name="prescription_pk")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_pk")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "health_record_id", referencedColumnName = "id")
	private HealthRecord healthRecord;
	
	@OneToMany
	@JoinColumn(name="prescription_id", referencedColumnName = "id")
	private List<PrescriptionDetail> details;

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

	public HealthRecord getHealthRecord() {
		return healthRecord;
	}

	public void setHealthRecord(HealthRecord healthRecord) {
		this.healthRecord = healthRecord;
	}

	public List<PrescriptionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<PrescriptionDetail> details) {
		this.details = details;
	}
	
	
}
