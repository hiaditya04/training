package com.hibernate.training.hql;

import com.hibernate.training.basic.pojo.Student;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println("------- ENGINE START---------");    	      
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();      
        
        Criteria criteriaObj =  sessionObj.createCriteria(Student.class);
        List<Student> 	students = criteriaObj.list();
        
        System.out.println("ROLLNO\t NAME \t ADDRESS");
        System.out.println("-----------------------");
        for(Student student : students){
        	System.out.print(student.getRollNumber());
        	System.out.print("\t"+student.getName());
        	System.out.println("\t"+student.getAddress());
        }
        System.out.println("-----------------------");
        
        
        
        
        
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println(" ....... ENGINE STOP ..........");
    }
 
}
