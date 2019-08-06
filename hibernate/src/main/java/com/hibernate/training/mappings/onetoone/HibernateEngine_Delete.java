package com.hibernate.training.mappings.onetoone;


/*
 * Author : RAJ 
 */
import com.hibernate.training.mappings.onetoone.pojo.Address;
import com.hibernate.training.mappings.onetoone.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
 
       	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO ONE ANNOTATION DELETE LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Student.class);
        configurationObj.addAnnotatedClass(Address.class);
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();

        Address address = (Address) sessionObj.get(Address.class, new Integer(1));
        Transaction transactionObj = sessionObj.beginTransaction();        
        sessionObj.delete(address);
        transactionObj.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
