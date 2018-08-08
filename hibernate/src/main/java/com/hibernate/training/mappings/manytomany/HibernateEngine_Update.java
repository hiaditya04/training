package com.hibernate.training.mappings.manytomany;

import java.util.Set;

import com.hibernate.training.mappings.manytomany.pojo.MobilePhone;
import com.hibernate.training.mappings.manytomany.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    { 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO MANY ANNOTATION UPDATE LESSON ..\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        User userObj = (User) session.get(User.class, new Integer(2));
        userObj.setName("Dharm");
        Set<MobilePhone> mobilePhoneSet = userObj.getMobilePhones();
        
        for(MobilePhone phone:mobilePhoneSet){
        	if(phone.getModelNumber()==11)
        		phone.setName("SAMSUNG galaxy NOTE");        	
        }
        userObj.setMobilePhones(mobilePhoneSet);
        
        Transaction transaction=session.beginTransaction();        
        session.update(userObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
