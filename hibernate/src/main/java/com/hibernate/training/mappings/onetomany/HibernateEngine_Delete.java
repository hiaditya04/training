package com.hibernate.training.mappings.onetomany;
/*
 * Author : RAJ
 */

import com.hibernate.training.mappings.onetomany.pojo.Student;
import com.hibernate.training.mappings.onetomany.pojo.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION DELETE LESSON ..\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Student.class);
        condigurationObj.addAnnotatedClass(Subject.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session session = factoryObj.openSession();
                           
        Subject subject= (Subject) session.get(Subject.class, new Integer(2));
        Transaction transaction=session.beginTransaction();
        session.delete(subject);
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        session.close();
        factoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
