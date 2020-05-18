package com.luv2code.hibernate.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entities.Employee;

public class DeleteRegistration {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("registration.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Employee employee = session.find(Employee.class, 3);
			session.delete(employee);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
