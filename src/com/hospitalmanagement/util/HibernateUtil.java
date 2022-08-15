package com.hospitalmanagement.util;

import java.util.ResourceBundle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try
		{			
			ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
			String url = resourceBundle.getString("db.url");
			String username = resourceBundle.getString("db.username");
			String password = resourceBundle.getString("db.password");
			
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.setProperty("hibernate.connection.url", url);
			cfg.setProperty("hibernate.connection.username", username);
			cfg.setProperty("hibernate.connection.password", password);
			
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e)
		{
			System.out.println("Session Factory initial creation error");
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
