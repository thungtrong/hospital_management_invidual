package com.hospitalmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Test;
import com.hospitalmanagement.model.Test;
import com.hospitalmanagement.util.HibernateUtil;

public class TestDAO implements DAO<Test, Integer>{
private SessionFactory sessionFactory;
	
	public TestDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Test> findAll() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Test.class);
		List<Test> list = criteria.list();
		
		session.close();
		return list;
	}

	@Override
	public Test findById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Test test = (Test) session.get(Test.class, id);
		
		session.close();
		return test;
	}

	@Override
	public Test update(Test test) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Test model = (Test) session.get(Test.class, test.getId());
		if (model == null)
		{
			session.close();
			return null;
		}
		test.copyTo(model);
		
		transaction.commit();
		session.close();
		return model;
	}

	@Override
	public Test insert(Test test) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(test);
		transaction.commit();
		session.close();
		
		return test;
	}

	@Override
	public Test save(Test test) {
		if (test.getId() == null)
		{
			return this.insert(test);
		} else 
			return this.update(test);
	}

	@Override
	public int delete(Test test) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Test model = (Test) session.get(Test.class, test.getId());
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
