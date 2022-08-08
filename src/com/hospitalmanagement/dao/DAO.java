package com.hospitalmanagement.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, ID> {
	List<T> findAll();
	
	T findById(ID id);
	
	T update(T model);
	
	T insert(T model);
	
	T save(T model);
	
	int delete(T model);
}
