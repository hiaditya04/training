package com.hibernate.training.mappings.onetoone;

import com.hibernate.training.mappings.onetoone.pojo.Student;
import com.hibernate.training.mappings.onetoone.pojo.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO ONE ANNOTATION SELECT LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Student.class);
        configurationObj.addAnnotatedClass(Address.class);
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();

        /*Address address = (Address) sessionObj.get(Address.class, new Integer(1));
        Student student= address.getStudent();*/

        Student student= (Student) sessionObj.get(Student.class, new Integer(1));
        Address address = student.getAddress();

        System.out.println("\n--------Student Data----------");
        System.out.println("Id	: "+student.getRollNumber());
        System.out.println("Name	: "+student.getName());
        System.out.println("\n------------------------------\n");
                       
        System.out.println("\n---------Address Data--------");
        System.out.println("Name	: "+address.getName());
        System.out.println("Area	: "+address.getArea());

        System.out.println("-------------------------------");                
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
