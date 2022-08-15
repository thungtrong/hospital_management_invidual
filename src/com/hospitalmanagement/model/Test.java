package com.hospitalmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	@Id
	private Integer id;
	@Column(name="test_name")
	private String testName;
	@Column(name="normal_result")
	private String normalResult;
	@Column(name="description")
	private String description;
	
	public Test(Integer id, String testName, String normalResult, String description) {
		super();
		this.id = id;
		this.testName = testName;
		this.normalResult = normalResult;
		this.description = description;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getNormalResult() {
		return normalResult;
	}
	public void setNormalResult(String normalResult) {
		this.normalResult = normalResult;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", testName=" + testName + ", normalResult=" + normalResult + ", description="
				+ description + "]";
	}
	
	public void copyTo(Test other)
	{
		other.testName = this.testName;
		other.normalResult = this.normalResult;
		other.description = this.description;
	}
}
