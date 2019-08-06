package com.hibernate.training.hql;

import com.hibernate.training.basic.pojo.Student;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
 
public class CriterionHibernateEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println("------- ENGINE START---------");    	      
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();        
        
        Criteria criteriaObj = sessionObj.createCriteria(Student.class);
        Criterion criterion = Restrictions.gt("rollNumber", new Integer(122)); //  means :  where id > 120
        criteriaObj.add(criterion);
        
        criteriaObj.addOrder(Order.desc("rollNumber"));	 // will fetch the data into descending order
        //criteriaObj.addOrder(Order.asc("rollNumber")); // will fetch the data into ascending order
        
        List 	students = criteriaObj.list();
        Iterator  studentIterator = students.iterator();
        
        System.out.println("ROLLNO\t NAME \t ADDRESS");
        System.out.println("-------------------------");
        
        while(studentIterator.hasNext()){
        	Student student=(Student)studentIterator.next();
        	System.out.print(student.getRollNumber());
        	System.out.print(" \t"+student.getName());
        	System.out.println(" \t"+student.getAddress());
        }
        
        System.out.println("-------------------------");
        
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println(" ....... ENGINE STOP ..........");
    } 
}
