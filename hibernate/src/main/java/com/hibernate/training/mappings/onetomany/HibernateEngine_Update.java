package com.hibernate.training.mappings.onetomany;

import com.hibernate.training.mappings.onetomany.pojo.Student;
import com.hibernate.training.mappings.onetomany.pojo.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION UPDATE LESSON ..");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Student.class);
        condigurationObj.addAnnotatedClass(Subject.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session session = factoryObj.openSession();
                           
        Student student = (Student) session.get(Student.class, new Integer(6));
        student.setName("Anna");

        /* In below two line we are changing the already exist subject name*/
        Subject subject = student.getSubject();
        subject.setName("C++");
        
        /* Using below three line we can add a new subject for the existing student */
        /* 
        Subject newSubject = new Subject();
        newSubject.setName("C");
        student.setSubject(newSubject);
        */
        
        Transaction transactionObj=session.beginTransaction();
        session.update(student);
        transactionObj.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        session.close();
        factoryObj.close();
        
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
