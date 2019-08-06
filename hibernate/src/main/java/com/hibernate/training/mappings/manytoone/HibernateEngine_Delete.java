package com.hibernate.training.mappings.manytoone;
/*
 * Author : RAJ
 */

import com.hibernate.training.mappings.manytoone.pojo.Student;
import com.hibernate.training.mappings.manytoone.pojo.Subject;
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
                           
        Student student= (Student) session.get(Student.class, new Integer(9));
        Transaction transaction=session.beginTransaction();
        session.delete(student);
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        session.close();
        factoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
