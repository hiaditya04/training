package com.hibernate.training.hql;

import com.hibernate.training.basic.pojo.Student;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
 
public class ProjectionsHibernateEngine { 
	
    public static void main(String[] data)
    {
    	System.out.println("------- ENGINE START---------");    	      
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();              
        Criteria criteriaObj = sessionObj.createCriteria(Student.class);
        
        Projection p1 = Projections.property("rollNumber");
        criteriaObj.setProjection(p1);               
        
        List 	students = criteriaObj.list();
        Iterator  iteratorObj = students.iterator();
        
        System.out.println(" ROLLNO ");
        System.out.println("-------");
        while(iteratorObj.hasNext()){
        	Integer rollNo =(Integer) iteratorObj.next();
        	System.out.println(rollNo);
        }
        System.out.println("---------\n");
        
        Projection p2 = Projections.property("name");
        criteriaObj.setProjection(p2);         
     	students = criteriaObj.list();
        iteratorObj = students.iterator();

        System.out.println(" NAME ");
        System.out.println("-------");
        while(iteratorObj.hasNext()){
        	String name =(String) iteratorObj.next();
        	System.out.println(name);
        }
        System.out.println("---------");

        sessionFactoryObj.close();        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
