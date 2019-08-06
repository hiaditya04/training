package com.hibernate.training.mappings.onetomany;

import com.hibernate.training.mappings.onetomany.pojo.Student;
import com.hibernate.training.mappings.onetomany.pojo.Subject;
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

        //Student student= (Student) session.get(Student.class, new Integer(101));

        Subject subject = (Subject) session.get(Subject.class,new Integer(2));
        System.out.println("--------Subject Data---------");
        System.out.println("Id	: "+subject.getId());
        System.out.println("Name	:"+subject.getName());
        System.out.println("----------------------------");

        System.out.println("\n--------Student Data---------");
        for(Student student : subject.getStudents()){

            System.out.println("Id	:"+student.getRollNumber());
            System.out.println("Name	:"+student.getName());
        }
        System.out.println("----------------------------\n");

        session.close();
        factoryObj.close();
        System.out.println(".. MANY TO ONE  ANNOTATION SELECT LESSON DONE ..");
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
