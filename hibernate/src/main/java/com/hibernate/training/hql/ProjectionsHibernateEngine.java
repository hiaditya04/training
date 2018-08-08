package com.hibernate.training.hql;

import java.util.Iterator;
import java.util.List;

import com.hibernate.training.hql.pojo.Entity;
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
        Criteria criteriaObj = sessionObj.createCriteria(Entity.class);
        
        Projection p1 = Projections.property("id");
        criteriaObj.setProjection(p1);               
        
        List 	entityList = criteriaObj.list();        
        Iterator  iteratorObj = entityList.iterator();
        
        System.out.println(" ID ");
        System.out.println("-------");
        while(iteratorObj.hasNext()){
        	Integer id =(Integer) iteratorObj.next();
        	System.out.println(id);
        }
        System.out.println("---------\n");
        
        Projection p2 = Projections.property("name");
        criteriaObj.setProjection(p2);         
     	entityList = criteriaObj.list();        
        iteratorObj = entityList.iterator();        

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
