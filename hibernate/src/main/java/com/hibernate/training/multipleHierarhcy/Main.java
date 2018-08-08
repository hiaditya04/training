package com.hibernate.training.multipleHierarhcy;

import com.hibernate.training.multipleHierarhcy.pojo.Car;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactoryObj=null;
		try {
			System.out.println(" ....... ENGINE START ............");
			System.out.println(" ..ANNOTATION LESSON TO SAVE DATA..\n");
			Configuration configurationObj = new Configuration();
			configurationObj.configure("hibernate.cfg.xml");
			configurationObj.addAnnotatedClass(Car.class);


			sessionFactoryObj = configurationObj
					.buildSessionFactory();
			Session sessionObj = sessionFactoryObj.openSession();
			Car bmw = new Car();
			bmw.setBrand("BMW");
			bmw.setFuel("DIESEL");
			bmw.setLicenseType("PRIVATE");
			bmw.setMakeYear("2015");
			bmw.setTypeOfWheelDrive("4");
			Transaction transaction = sessionObj.beginTransaction();
			sessionObj.save(bmw);
			transaction.commit();
			if (sessionObj.isOpen()) {
				sessionObj.close();
			}
			sessionFactoryObj.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sessionFactoryObj.close();
			
		}
       
       
       		
       		
		
	}

}
