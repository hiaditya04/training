package com.hibernate.training.hql;

import com.hibernate.training.basic.pojo.Student;
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
        
        Criteria criteriaObj = sessionObj.createCriteria(Student.class);
        
        /* AND operator */
        
        //criteriaObj.add(Restrictions.and(Restrictions.like("name","%N%"), Restrictions.gt("id", new Integer(1))));
        //criteriaObj.add(Restrictions.and(Restrictions.like("name","%N%").ignoreCase(), Restrictions.gt("id", new Integer(130))));
        
        /*  OR operator */
        /*criteriaObj.add(
        			Restrictions.or(
        						Restrictions.like("name","%k%").ignoreCase(), 
        						Restrictions.gt("id", new Integer(0))
        					)
        			);*/
        
        criteriaObj.addOrder(Order.desc("address"));
        List 	entityList=criteriaObj.list();        
        Iterator  studentIteratorList=entityList.iterator();
        
        System.out.println("ROLLNO\t NAME \t ADDRESS");
        System.out.println("-------------------------");
        while(studentIteratorList.hasNext()){
        	Student student=(Student) studentIteratorList.next();
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
