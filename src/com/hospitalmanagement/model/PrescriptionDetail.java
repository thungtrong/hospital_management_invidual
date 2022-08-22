package com.hospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="prescription_detail")
public class PrescriptionDetail {
	@Id
	@SequenceGenerator(name="prescription_detai_pk")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_detai_pk")
	private Long id;
	@ManyToOne
	@JoinColumn(name="medicine_id")
	private Medicine medicine;
	private Integer quantity;
	public PrescriptionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrescriptionDetail(Long id, Medicine medicine, Integer quantity) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
