package com.hibernate.training.mappings.manytomany;

import java.util.HashSet;
import java.util.Set;

import com.hibernate.training.mappings.manytomany.pojo.MobilePhone;
import com.hibernate.training.mappings.manytomany.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEngine_Insert {
	public static void main(String[] javaPlanet) {
		
		System.out.println(" ....... ENGINE START ............");
		System.out.println(" .. MANY TO MANY ANNOTATION INSERT LESSON ..\n");

		HibernateSessionFactory.buildSessionFactory();
		Session sessionObj= HibernateSessionFactory.getSession();

		MobilePhone phoneObj1 = new MobilePhone();
		phoneObj1.setModelNumber(10);
		phoneObj1.setName("SAMSUNG WOW");

		MobilePhone phoneObj2 = new MobilePhone();
		phoneObj2.setModelNumber(11);
		phoneObj2.setName("SAMSUNG RAYS");

		Set<MobilePhone> mobilePhoneSet = new HashSet<MobilePhone>();
		mobilePhoneSet.add(phoneObj1);
		mobilePhoneSet.add(phoneObj2);

		User userObj1 = new User();
		userObj1.setName("Steve Jobs");
		userObj1.setAddress("Baroda, Alkapuri");

		User userObj2 = new User();
		userObj2.setName("Bill Gates");
		userObj2.setAddress("Bharuch,Narmada Colony");

		Set<User> userSet = new HashSet<User>();
		userSet.add(userObj1);
		userSet.add(userObj2);

		phoneObj1.setUsers(userSet);
		phoneObj2.setUsers(userSet);

		Transaction transaction = sessionObj.beginTransaction();
		sessionObj.save(phoneObj1);
		sessionObj.save(phoneObj2);
		transaction.commit();

		System.out.println("\n....... DATA INSERTED SUCCESSFULLY ..........");
		sessionObj.close();
		//factoryObj.close();
		HibernateSessionFactory.shutDown();
		System.out.println("\n....... ENGINE STOP ..........");
	}
}
