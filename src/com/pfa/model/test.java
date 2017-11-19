package com.pfa.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Eleve.class)
				.buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try{
			//create a student object
			System.out.println("creating a new student object...");
			//start a transaction
			session.beginTransaction();
			
			Eleve eleve=new Eleve();
			//save the student object
			System.out.println("saving the student");
			session.save(eleve);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally{
			session.close();
			factory.close();
		}
	}

}
