package com.hospitalmanagement.dao;

public interface DoctorQueries {
	 static final String UPDATE_QUERY = "UPDATE doctor SET name=?,gender=?,phone_number=?,address=?,date_of_birth=TO_DATE(?, 'yyyy/mm/dd'),department_id=? WHERE id=?";
	 static final String INSERT_QUERY = "INSERT INTO doctor (id, name, gender, phone_number, address, date_of_birth, department_id) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'yyyy/mm/dd'), ?);";
	 static final String DELETE_QUERY = "DELETE FROM doctor WHERE id=?";
	 static final String SELECT_ALL = "SELECT id, name, gender, phone_number, address, date_of_birth, department_id FROM doctor";
	 static final String SELECT_BY_ID = "SELECT id, name, gender, phone_number, address, date_of_birth, department_id FROM doctor WHERE id=?";
}
