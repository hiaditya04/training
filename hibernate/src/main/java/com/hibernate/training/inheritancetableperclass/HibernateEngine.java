package com.hibernate.training.inheritancetableperclass;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.inheritancetableperclass.pojo.Area;
import com.hibernate.training.inheritancetableperclass.pojo.Rural;
import com.hibernate.training.inheritancetableperclass.pojo.Urban;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine { 
 
    public static void main(String[] args){

        try{
      	System.out.println("********** START ************");
      	
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Area.class);
        configurationObj.addAnnotatedClass(Rural.class);
        configurationObj.addAnnotatedClass(Urban.class);


        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();
           
        Rural ruralObj=new Rural();

        ruralObj.setAreaId(1);
        ruralObj.setAreaName("Vrundavan");
        ruralObj.setPopulation(7000);
        ruralObj.setTotalSchools(4);
        
        Urban urbanObj=new Urban();
        urbanObj.setAreaName("Anand");
        urbanObj.setPopulation(70000);
        urbanObj.setTotalColleges(11);
        
        Transaction transactionObj = sessionObj.beginTransaction();
        sessionObj.save(ruralObj);
        sessionObj.save(urbanObj);
        
        transactionObj.commit();
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("Area's Data saved successfully !");
        System.out.println("*********** END ************");
    }finally {
            HibernateSessionFactory.shutdown();
        }
        }
 
}

/*
 CREATE TABLE HIB_AREA (ID NUMERIC PRIMARY KEY,AREA_NAME VARCHAR(20),PERSON_NAME VARCHAR(20),PERSON_QUALIFICATION VARCHAR(20))
 */