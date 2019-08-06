package com.hibernate.training.mappings.onetomany;

import com.hibernate.training.mappings.onetomany.pojo.Student;
import com.hibernate.training.mappings.onetomany.pojo.Subject;
import java.util.ArrayList;
import java.util.List;
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

        SessionFactory sessionFactory = configurationObj.buildSessionFactory();
        Session session = sessionFactory.openSession();

        
        Student student=new Student();
        student.setName("Jack");

        Student student1=new Student();
        student1.setName("Jill");

        List students = new ArrayList<Student>();
        students.add(student);
        students.add(student1);


        Subject subject=new Subject();
        subject.setName("JAVA");
        subject.setStudents(students);
        Transaction transaction=session.beginTransaction();
        session.save(subject);

                
        transaction.commit();        
        System.out.println(".. DATA INSERTED SUCCESSFULLY ..");
        session.close();
        sessionFactory.close();
        
        System.out.println(".......ENGINE STOP ..........");
    } 
}
