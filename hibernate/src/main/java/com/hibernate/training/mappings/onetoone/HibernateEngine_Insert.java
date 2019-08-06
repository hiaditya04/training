package com.hibernate.training.mappings.onetoone;



import com.hibernate.training.mappings.onetoone.pojo.Student;
import com.hibernate.training.mappings.onetoone.pojo.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(".......ENGINE START.......");  
    	System.out.println(".. ONE TO ONE ANNOTATION INSERT LESSON ..");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);

        SessionFactory sessionFactoryObj = configuration.buildSessionFactory();
        Session session = sessionFactoryObj.openSession();

        Student student = new Student();
        student.setRollNumber(1);
        student.setName("John");

        Address address = new Address();
        address.setRollNumber(student.getRollNumber());
        address.setName("Magnet Corporate park");
        address.setArea("Thaltej");
        address.setStudent(student);
        student.setAddress(address);
        
        Transaction transactionObj = session.beginTransaction();
        //sessionObj.save(address);
        session.save(student);
                
        transactionObj.commit();        
        session.close();
        sessionFactoryObj.close();
        System.out.println("....... DATA SAVED SUCCESSFULLY ............");
        System.out.println(".......ENGINE STOP.......");
    }
 
}
