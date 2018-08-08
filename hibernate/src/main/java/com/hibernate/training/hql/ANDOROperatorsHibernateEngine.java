package com.hibernate.training.hql;

import java.util.Iterator;
import java.util.List;

import com.hibernate.training.hql.pojo.Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
 
public class ANDOROperatorsHibernateEngine {
 
	 
    public static void main(String[] dataBag)
    {
    	System.out.println("------- ENGINE START---------");    	      
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Entity.class);
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();        
        
        Criteria criteriaObj = sessionObj.createCriteria(Entity.class);
        
        /* AND operator */
        
        //criteriaObj.add(Restrictions.and(Restrictions.like("name","%N%"), Restrictions.gt("id", new Integer(1))));
        //criteriaObj.add(Restrictions.and(Restrictions.like("name","%N%").ignoreCase(), Restrictions.gt("id", new Integer(1))));
        
        /*  OR operator */
        criteriaObj.add(
        			Restrictions.or(
        						Restrictions.like("name","%k%").ignoreCase(), 
        						Restrictions.gt("id", new Integer(0))
        					)
        			);
        
        criteriaObj.addOrder(Order.desc("category"));       
        List 	entityList=criteriaObj.list();        
        Iterator  entityListIterator=entityList.iterator();
        
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
