package com.hibernate.training.hql;

import com.hibernate.training.basic.pojo.Student;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
 
public class ProjectionsListHibernateEngine { 
	
    public static void main(String[] dataBag)
    {
    	System.out.println("------- ENGINE START---------");    	      
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();              
        Criteria criteriaObj=sessionObj.createCriteria(Student.class);
        criteriaObj.addOrder(Order.desc("id"));
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("rollNumber"));
        projList.add(Projections.property("address"));
        criteriaObj.setProjection(projList);
        
        List 	students=criteriaObj.list();
        Iterator  iteratorObj=students.iterator();
        
        System.out.println("ROLLNO \t ADDRESS ");
        System.out.println("^^^^^^^^^^^^^^^^^^^^");
        while(iteratorObj.hasNext()){
        	Object data[]=(Object[])iteratorObj.next();
        	System.out.println(data[0]+" \t "+data[1]);
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^");
        
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
