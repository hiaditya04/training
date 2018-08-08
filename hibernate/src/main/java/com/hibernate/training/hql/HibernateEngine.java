package com.hibernate.training.hql;

import java.util.List;

import com.hibernate.training.hql.pojo.Entity;
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
        
        Criteria criteriaObj =  sessionObj.createCriteria(Entity.class);
        List<Entity> 	entityList = criteriaObj.list();        
        
        System.out.println("ID\t NAME \t CATEGORY");
        System.out.println("-----------------------");
        for(Entity entityObj : entityList){        	
        	System.out.print(entityObj.getId());
        	System.out.print("\t"+entityObj.getName());
        	System.out.println("\t"+entityObj.getCategory());
        }
        System.out.println("-----------------------");
        
        
        
        
        
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println(" ....... ENGINE STOP ..........");
    }
 
}
