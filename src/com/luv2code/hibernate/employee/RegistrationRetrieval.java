package com.luv2code.hibernate.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entities.Employee;

public class RegistrationRetrieval {

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
			System.out.println(session.get(Employee.class, 1));
			
			List<Employee> employees = session.createQuery("from Employee e WHERE company='FFUF Manila Inc.'").list();
			for (Employee employee: employees) {
				System.out.println(employee);
			}
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
