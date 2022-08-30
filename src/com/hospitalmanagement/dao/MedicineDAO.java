package com.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.util.HibernateUtil;
import com.hospitalmanagement.util.HibernateUtil2;

public class MedicineDAO implements DAO<Medicine, Integer>{
	private SessionFactory sessionFactory;
	{
		sessionFactory = HibernateUtil2.getSessionFactory();
	}
	public MedicineDAO() {
	}

	
	@Override
	public List<Medicine> findAll() {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Medicine.class);
			List<Medicine> list = criteria.list();
			
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
	public Medicine findById(Integer id) {
		Medicine medicine;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			medicine = (Medicine) session.get(Medicine.class, id);
			
			return medicine;
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
	public int update(Medicine medicine) {
		Medicine model;
		Session session = null;
		int result = 0;
		
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			model = (Medicine) session.get(Medicine.class, medicine.getId());
			if (model == null)
			{
				result = 0;
			} else
			{
				session.merge(medicine);
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
	public Integer insert(Medicine medicine) {
		Session session = null;
		Integer id = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (Integer) session.save(medicine);
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
	public int delete(Medicine medicine) {
		Session session = null;
		int result = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Medicine model = (Medicine) session.get(Medicine.class, medicine.getId());
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
