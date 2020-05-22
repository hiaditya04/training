package com.hibernate.training.basic;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.basic.pojo.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentOperations {

    public static void main(String[] args) {
        try {
            Student student = new Student(120, "Jack", "Magnet Corporate Park");
            student.setHouseCaptain(false);

            HibernateSessionFactory.buildSessionFactory();
            Session session = HibernateSessionFactory.getNewSession();
            Transaction transaction = session.beginTransaction();
            session.save(student);

            transaction.commit();
            session.close();

            session = HibernateSessionFactory.getNewSession();
            Student studentData = (Student) session.get(Student.class, 120);
            System.out.println("----------------- STUDENT DATA -----------------------");
            System.out.println(studentData);
        }finally {
            HibernateSessionFactory.shutdown();
        }

    }

}
