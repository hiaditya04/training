package com.hibernate.training.hql;

import java.util.Iterator;
import java.util.List;

import com.hibernate.training.hql.pojo.Entity;
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
        Criteria criteriaObj=sessionObj.createCriteria(Entity.class);
        criteriaObj.addOrder(Order.desc("id"));
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("id"));
        projList.add(Projections.property("category"));
        criteriaObj.setProjection(projList);
        
        List 	entityList=criteriaObj.list();        
        Iterator  iteratorObj=entityList.iterator();
        
        System.out.println("ID \t CATEGORY ");
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
