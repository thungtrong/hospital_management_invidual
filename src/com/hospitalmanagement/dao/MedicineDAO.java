package com.hospitalmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.util.HibernateUtil;

public class MedicineDAO implements DAO<Medicine, Integer>{

	private SessionFactory sessionFactory;
	
	public MedicineDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Medicine> findAll() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Medicine.class);
		List<Medicine> list = criteria.list();
		
		session.close();
		return list;
	}

	@Override
	public Medicine findById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Medicine medicine = (Medicine) session.get(Medicine.class, id);
		
		session.close();
		return medicine;
	}

	@Override
	public Medicine update(Medicine medicine) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Medicine model = (Medicine) session.get(Medicine.class, medicine.getId());
		if (model == null)
		{
			session.close();
			return null;
		}
		medicine.copyTo(model);
		
		transaction.commit();
		session.close();
		return model;
	}

	@Override
	public Medicine insert(Medicine medicine) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(medicine);
		transaction.commit();
		session.close();
		
		return medicine;
	}

	@Override
	public Medicine save(Medicine medicine) {
		if (medicine.getId() == null)
		{
			return this.insert(medicine);
		} else 
			return this.update(medicine);
	}

	@Override
	public int delete(Medicine medicine) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Medicine model = (Medicine) session.get(Medicine.class, medicine.getId());
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
