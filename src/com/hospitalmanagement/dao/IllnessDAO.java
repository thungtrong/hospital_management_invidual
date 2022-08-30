package com.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Illness;
import com.hospitalmanagement.util.HibernateUtil;
import com.hospitalmanagement.util.HibernateUtil2;

public class IllnessDAO implements DAO<Illness, Integer>{
	private SessionFactory sessionFactory;
	{
		sessionFactory = HibernateUtil2.getSessionFactory();
	}
	public IllnessDAO() {
	}

	
	@Override
	public List<Illness> findAll() {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Illness.class);
			List<Illness> list = criteria.list();
			
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
			{
				session.close();
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Illness findById(Integer id) {
		Illness illness;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			illness = (Illness) session.get(Illness.class, id);
			
			return illness;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public int update(Illness illness) {
		Illness model;
		Session session = null;
		int result = 0;
		
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			model = (Illness) session.get(Illness.class, illness.getId());
			if (model == null)
			{
				result = 0;
			} else
			{
				session.merge(illness);
				transaction.commit();
				result = 1;
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}

	@Override
	public Integer insert(Illness illness) {
		Session session = null;
		Integer id = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (Integer) session.save(illness);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
			{
				session.close();
			}
		}
		
		return id;
	}


	@Override
	public int delete(Illness illness) {
		Session session = null;
		int result = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Illness model = (Illness) session.get(Illness.class, illness.getId());
			if (model == null)
			{
				result = 0;
			} 
			else 
			{
				session.delete(model);
				
				transaction.commit();
				result = 1;
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
			{
				session.close();
			}
		}
		return result;
	}
	
}
