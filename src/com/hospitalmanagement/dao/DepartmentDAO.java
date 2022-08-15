package com.hospitalmanagement.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Department;
import com.hospitalmanagement.util.HibernateUtil;

public class DepartmentDAO implements DAO<Department, Integer>{
	private SessionFactory sessionFactory;
	
	public DepartmentDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Department> findAll() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> list = criteria.list();
		
		session.close();
		return list;
	}

	@Override
	public Department findById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Department department = (Department) session.get(Department.class, id);
		
		session.close();
		return department;
	}

	@Override
	public Department update(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Department model = (Department) session.get(Department.class, department.getId());
		if (model == null)
		{
			session.close();
			return null;
		}
		department.copyTo(model);
		
		transaction.commit();
		session.close();
		return model;
	}

	@Override
	public Department insert(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		session.close();
		
		return department;
	}

	@Override
	public Department save(Department department) {
		if (department.getId() == null)
		{
			return this.insert(department);
		} else 
			return this.update(department);
	}

	@Override
	public int delete(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Department model = (Department) session.get(Department.class, department.getId());
		if (model == null)
		{
			session.close();
			return 0;
		} 
		session.delete(model);
		
		transaction.commit();
		session.close();
		return 1;
	}
	
	
}
