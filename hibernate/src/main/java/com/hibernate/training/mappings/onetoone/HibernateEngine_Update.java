package com.hibernate.training.mappings.onetoone;

import com.hibernate.training.mappings.onetoone.pojo.Address;
import com.hibernate.training.mappings.onetoone.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {     	    	
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO ONE ANNOTATION UPDATE LESSON ............\n");

    	Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Student.class);
        configurationObj.addAnnotatedClass(Address.class);
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();


        Student student= (Student) sessionObj.get(Student.class, new Integer(1));
        Address address = student.getAddress();
        //student.setName("Jiya");
        address.setName("Silicon Tower");
        address.setArea("Ambawadi");

        Transaction transaction=sessionObj.beginTransaction();
        sessionObj.update(student);
        transaction.commit();

         /*Address address = (Address) sessionObj.get(Address.class, new Integer(1));
        Student student= address.getStudent();
        student.setName("Jiya");

        Transaction transaction=sessionObj.beginTransaction();
        sessionObj.update(address);*/
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
