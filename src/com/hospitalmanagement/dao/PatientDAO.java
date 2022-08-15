package com.hospitalmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.util.HibernateUtil;

public class PatientDAO implements DAO<Patient, Integer> {
private SessionFactory sessionFactory;
	
	public PatientDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Patient> findAll() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Patient.class);
		List<Patient> list = criteria.list();
		
		session.close();
		return list;
	}

	@Override
	public Patient findById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Patient patient = (Patient) session.get(Patient.class, id);
		
		session.close();
		return patient;
	}

	@Override
	public Patient update(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Patient model = (Patient) session.get(Patient.class, patient.getId());
		if (model == null)
		{
			session.close();
			return null;
		}
		patient.copyTo(model);
		
		transaction.commit();
		session.close();
		return model;
	}

	@Override
	public Patient insert(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(patient);
		transaction.commit();
		session.close();
		
		return patient;
	}

	@Override
	public Patient save(Patient patient) {
		if (patient.getId() == null)
		{
			return this.insert(patient);
		} else 
			return this.update(patient);
	}

	@Override
	public int delete(Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Patient model = (Patient) session.get(Patient.class, patient.getId());
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
