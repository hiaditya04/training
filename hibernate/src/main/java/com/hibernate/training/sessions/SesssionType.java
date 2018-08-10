package com.hibernate.training.sessions;

import org.hibernate.Session;

public class SesssionType {

	public static void main(String[] args) {
		try {
		HibernateSessionFactory.buildSessionFactory();
		Session session1 = HibernateSessionFactory.getCurrentSession();
		Session session2 = HibernateSessionFactory.getCurrentSession();
		Session session3 = HibernateSessionFactory.getCurrentSession();
		
		
		Session session4 = HibernateSessionFactory.getNewSession();
		
		System.out.printf("Session1 & session2 are same %b \n",session1 == session2);
		System.out.printf("Session2 & session3 are same %b \n",session2 == session3);
		System.out.printf("Session1 & session3 are same %b \n",session1 == session3);
		System.out.printf("Session3 & session4 are same %b \n",session3 == session4);
		
		HibernateSessionFactory.getCurrentSession().close();
		
		Session session5 = HibernateSessionFactory.getCurrentSession();
		System.out.println("After closing the current session");
		System.out.printf("Session1 & session5 are same %b \n",session1 == session5);
	
		
		
		
		

	}finally {
		HibernateSessionFactory.shutDown();
	}
	}

}
