package com.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class OneToOne {

	public static void main(String[] args) {
		Student_Info student = new Student_Info();
		student.setStudentName("ABC");
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("33333333");
		studentDetail.setStudent(student);
		
		student.setStudentDetail(studentDetail);
		Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
