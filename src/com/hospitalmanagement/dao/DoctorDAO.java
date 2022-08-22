package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.util.DBConnection;
import com.hospitalmanagement.util.HibernateUtil2;

public class DoctorDAO implements DAO<Doctor, Long>, DoctorQueries {
	private SessionFactory sessionFactory;
	{
		sessionFactory = HibernateUtil2.getSessionFactory();
	}
	public DoctorDAO() {
	}

	
	@Override
	public List<Doctor> findAll() {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Doctor.class);
			List<Doctor> list = criteria.list();
			
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
	public Doctor findById(Long id) {
		Doctor doctor;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			doctor = (Doctor) session.get(Doctor.class, id);
			
			return doctor;
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
	public int update(Doctor doctor) {
		Doctor model;
		Session session = null;
		int result = 0;
		
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			model = (Doctor) session.get(Doctor.class, doctor.getId());
			if (model == null)
			{
				session.close();
				return 0;
			}
			
			session.merge(doctor);
			transaction.commit();
			result = 1;
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
	public Long insert(Doctor doctor) {
		Session session = null;
		Long id = -1l;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (Long) session.save(doctor);
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
	public int delete(Doctor doctor) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Doctor model = (Doctor) session.get(Doctor.class, doctor.getId());
			if (model == null)
			{
				session.close();
				return 0;
			} 
			session.delete(model);
			
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
		return 1;
	}
	

}
