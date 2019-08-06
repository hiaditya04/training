package com.hibernate.training.mappings.manytoone;

import com.hibernate.training.mappings.manytoone.pojo.Student;
import com.hibernate.training.mappings.manytoone.pojo.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert{  
    public static void main(String[] javaPlanet)
    {    	
    	System.out.println(" .......ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNONTATION INSERT LESSON ..");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Student.class);
        configurationObj.addAnnotatedClass(Subject.class);
       //configurationObj.setProperty("hibernate.hbm2ddl.auto","create");
 
        SessionFactory sessionFactory = configurationObj.buildSessionFactory();
        Session session = sessionFactory.openSession();
                                   
        Subject subject=new Subject();

        subject.setName("JAVA");
        
        Student student=new Student();
        student.setName("Jack");
        student.setSubject(subject);

        Student student1=new Student();
        student1.setName("Jill");
        student1.setSubject(subject);
        
        Transaction transaction=session.beginTransaction();
        session.save(student);
        session.save(student1);
                
        transaction.commit();        
        System.out.println(".. DATA INSERTED SUCCESSFULLY ..");
        session.flush();
        session.close();
        sessionFactory.close();
        
        System.out.println(".......ENGINE STOP ..........");
    } 
}
