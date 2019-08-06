package com.hibernate.training.hql;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.basic.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentOperations {

    public static void main(String[] args) {
        try {


            Configuration configurationObj = new Configuration();
            configurationObj.configure("hibernate.cfg.xml");
            configurationObj.addAnnotatedClass(Student.class);

            SessionFactory sessionFactory = configurationObj.buildSessionFactory();
            Session session = sessionFactory.openSession();


            Student student1 = new Student(121, "Pooja", "Magnet Corporate Park");
            Student student2 = new Student(122, "Neelam", "Sillicon Tower");
            Student student3 = new Student(123, "Shyam", "Sillicon Tower");
            Student student = new Student(124, "Ram", "Magnet Corporate Park");

            Transaction transaction=session.beginTransaction();
            session.save(student);
            session.save(student1);
            session.save(student2);
            session.save(student3);

            transaction.commit();
            System.out.println(".. DATA INSERTED SUCCESSFULLY ..");
            session.close();
            sessionFactory.close();

        }finally {
            HibernateSessionFactory.shutdown();
        }

    }

}
