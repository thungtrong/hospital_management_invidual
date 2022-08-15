package com.hospitalmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Illness;
import com.hospitalmanagement.model.Illness;
import com.hospitalmanagement.util.HibernateUtil;

public class IllnessDAO implements DAO<Illness, Integer>{
	private SessionFactory sessionFactory;
	
	public IllnessDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Illness> findAll() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Illness.class);
		List<Illness> list = criteria.list();
		
		session.close();
		return list;
	}

	@Override
	public Illness findById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Illness illness = (Illness) session.get(Illness.class, id);
		
		session.close();
		return illness;
	}

	@Override
	public Illness update(Illness illness) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Illness model = (Illness) session.get(Illness.class, illness.getId());
		if (model == null)
		{
			session.close();
			return null;
		}
		illness.copyTo(model);
		
		transaction.commit();
		session.close();
		return model;
	}

	@Override
	public Illness insert(Illness illness) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(illness);
		transaction.commit();
		session.close();
		
		return illness;
	}

	@Override
	public Illness save(Illness illness) {
		if (illness.getId() == null)
		{
			return this.insert(illness);
		} else 
			return this.update(illness);
	}

	@Override
	public int delete(Illness illness) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Illness model = (Illness) session.get(Illness.class, illness.getId());
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
