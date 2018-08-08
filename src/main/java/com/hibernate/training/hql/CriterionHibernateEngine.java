package com.hibernate.training.hql;

import java.util.Iterator;
import java.util.List;

import com.hibernate.training.hql.pojo.Entity;
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
        
        Criteria criteriaObj = sessionObj.createCriteria(Entity.class);
        Criterion criterion = Restrictions.gt("id", new Integer(0)); //  means :  where id > 2
        criteriaObj.add(criterion);
        
        criteriaObj.addOrder(Order.desc("id"));	 // will fetch the data into descending order
        //criteriaObj.addOrder(Order.asc("id")); // will fetch the data into ascending order
        
        List 	entityList = criteriaObj.list();        
        Iterator  entityListIterator = entityList.iterator();
        
        System.out.println("ID\t NAME \t CATEGORY");
        System.out.println("-------------------------");
        
        while(entityListIterator.hasNext()){        	
        	Entity entityObj=(Entity)entityListIterator.next();
        	System.out.print(entityObj.getId());
        	System.out.print(" \t"+entityObj.getName());
        	System.out.println(" \t"+entityObj.getCategory());
        }
        
        System.out.println("-------------------------");
        
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println(" ....... ENGINE STOP ..........");
    } 
}
