package com.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.util.HibernateUtil;
import com.hospitalmanagement.util.HibernateUtil2;

public class PatientDAO implements DAO<Patient, Integer>{
	private SessionFactory sessionFactory;
	{
		sessionFactory = HibernateUtil2.getSessionFactory();
	}
	public PatientDAO() {
	}

	
	@Override
	public List<Patient> findAll() {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Patient.class);
			List<Patient> list = criteria.list();
			
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
	public Patient findById(Integer id) {
		Patient patient;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			patient = (Patient) session.get(Patient.class, id);
			
			return patient;
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
	public int update(Patient patient) {
		Patient model;
		Session session = null;
		int result = 0;
		
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			model = (Patient) session.get(Patient.class, patient.getId());
			if (model == null)
			{
				result = 0;
			} else
			{
				session.merge(patient);
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
	public Integer insert(Patient patient) {
		Session session = null;
		Integer id = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (Integer) session.save(patient);
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
	public int delete(Patient patient) {
		Session session = null;
		int result = 0;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Patient model = (Patient) session.get(Patient.class, patient.getId());
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
