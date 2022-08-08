package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.util.DBConnection;

public class DoctorDAO implements DAO<Doctor, Long>, DoctorQueries {
	private Connection connection;

	private static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy/mm/dd");

	public DoctorDAO() {
		try {
			connection = DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// alt + shift + r
	private Doctor mappingDoctor(ResultSet resultSet) {
		Doctor doctor = new Doctor();
		try {
			doctor.setId(resultSet.getLong(1));
			doctor.setName(resultSet.getString(2));
			doctor.setGender(resultSet.getString(3).charAt(0));
			doctor.setPhoneNumber(resultSet.getString(4));
			doctor.setAddress(resultSet.getString(5));
			doctor.setDateOfBirth(resultSet.getDate(6));
			doctor.setDepartmentId(resultSet.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		List<Doctor> doctors = new ArrayList<>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL);

			while (resultSet.next()) {
				doctors.add(this.mappingDoctor(resultSet));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctors;
	}

	@Override
	public Doctor findById(Long id) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(SELECT_BY_ID);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return this.mappingDoctor(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Doctor update(Doctor model) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setString(1, model.getName());
			statement.setString(2, model.getGender().toString());
			statement.setString(3, model.getPhoneNumber());
			statement.setString(4, model.getAddress());
			statement.setString(5, dateFormater.format(model.getDateOfBirth()));
			statement.setInt(6, model.getDepartmentId());
			statement.setLong(7, model.getId());
			if (statement.executeUpdate() > 0) {
				return model;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Doctor insert(Doctor model) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1, model.getName());
			statement.setString(2, model.getGender().toString());
			statement.setString(3, model.getPhoneNumber());
			statement.setString(4, model.getAddress());
			statement.setString(5, dateFormater.format(model.getDateOfBirth()));
			statement.setInt(6, model.getDepartmentId());
			if (statement.executeUpdate() > 0) {
				return model;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Doctor save(Doctor model) {
		if (model.getId() == null) {
			return this.insert(model);
		} else {
			return this.update(model);
		}
	}

	@Override
	public int delete(Doctor model) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			statement.setLong(1, model.getId());

			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
