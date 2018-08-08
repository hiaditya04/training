package com.hibernate.training.mappings.onetoone;

import com.hibernate.training.mappings.onetoone.pojo.Pupil;
import com.hibernate.training.mappings.onetoone.pojo.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {     	    	
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO ONE ANNOTATION UPDATE LESSON ............\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Pupil.class);
        configurationObj.addAnnotatedClass(Result.class);
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
         
        Result resultObj = (Result) sessionObj.get(Result.class, new Integer(4));
        Pupil pupilObj= resultObj.getPupil();
        pupilObj.setName("Mansukh");
      
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.update(resultObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
