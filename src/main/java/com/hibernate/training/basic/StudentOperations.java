package com.hibernate.training.basic;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.basic.pojo.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentOperations {

    public static void main(String[] args) {
        try {
            Student student = new Student(120, "aditya", "science city");
            HibernateSessionFactory.buildSessionFactory();
            Session newSession = HibernateSessionFactory.getNewSession();
            Transaction transaction = newSession.beginTransaction();
            newSession.save(student);
            transaction.commit();
            newSession.close();
            newSession = HibernateSessionFactory.getNewSession();
            Student o = (Student) newSession.get(Student.class, 120);
            System.out.println(o);
        }finally {
            HibernateSessionFactory.shutdown();
        }

    }

}
