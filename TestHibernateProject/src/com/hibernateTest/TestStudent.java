package com.hibernateTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestStudent {

	public static void main(String[] args) {
		Student_Info student = new Student_Info();
		student.setStudentName("Test1");
		Student_Info student1 = new Student_Info();
		student1.setStudentName("Test2");
		Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(student1);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
