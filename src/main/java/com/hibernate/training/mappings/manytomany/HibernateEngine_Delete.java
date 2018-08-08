package com.hibernate.training.mappings.manytomany;

import com.hibernate.training.mappings.manytomany.pojo.MobilePhone;
import com.hibernate.training.mappings.manytomany.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO MANY ANNOTATION DELETE LESSON..\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(MobilePhone.class);
        cfg.addAnnotatedClass(User.class);
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        User usertObj= (User) session.get(User.class, new Integer(1));
        Transaction transaction=session.beginTransaction();        
        session.delete(usertObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
