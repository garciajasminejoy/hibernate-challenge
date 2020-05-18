package com.luv2code.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entities.Employee;

public class Registration {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("registration.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			Employee employee1 = new Employee("Jasmine1", "Garcia", "FFUF Manila Inc.");
			Employee employee2 = new Employee("Jasmine2", "Garcia", "FFUF Manila Inc.");
			Employee employee3 = new Employee("Jasmine3", "Garcia", "FFUF Manila Inc.");
			session.beginTransaction();
			System.out.println("begin transaction.");
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
	
}
