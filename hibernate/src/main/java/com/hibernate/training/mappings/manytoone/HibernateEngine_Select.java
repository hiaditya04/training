package com.hibernate.training.mappings.manytoone;

import com.hibernate.training.mappings.manytoone.pojo.Student;
import com.hibernate.training.mappings.manytoone.pojo.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION SELECT LESSON ..\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Student.class);
        condigurationObj.addAnnotatedClass(Subject.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session session = factoryObj.openSession();
                              
        Student student= (Student) session.get(Student.class, new Integer(8));
                
        System.out.println("\n--------Student Data---------");
        System.out.println("Id	:"+student.getRollNumber());
        System.out.println("Name	:"+student.getName());
        System.out.println("----------------------------\n");

        Subject subject = student.getSubject();
        System.out.println("--------Subject Data---------");
        System.out.println("Id	: "+subject.getId());
        System.out.println("Name	:"+subject.getName());
        System.out.println("----------------------------");
        session.flush();
        session.close();
        factoryObj.close();
        System.out.println(".. MANY TO ONE  ANNOTATION SELECT LESSON DONE ..");
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
