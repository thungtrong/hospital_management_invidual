package com.hospitalmanagement.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_detail")
public class TestFormDetail {
	@Id
	@SequenceGenerator(name="test_detail_pk")
	@GeneratedValue(generator = "test_detail_pk", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "test_id", referencedColumnName = "id")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name="test_form_id", referencedColumnName = "id")
	private TestForm testForm;
	
	private String result;

	public TestFormDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestFormDetail(Long id, Test test, TestForm testForm, String result) {
		super();
		this.id = id;
		this.test = test;
		this.testForm = testForm;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TestForm getTestForm() {
		return testForm;
	}

	public void setTestForm(TestForm testForm) {
		this.testForm = testForm;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
