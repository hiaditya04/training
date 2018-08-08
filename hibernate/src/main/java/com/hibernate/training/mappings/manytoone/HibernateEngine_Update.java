package com.hibernate.training.mappings.manytoone;

import com.hibernate.training.mappings.manytoone.pojo.Children;
import com.hibernate.training.mappings.manytoone.pojo.Parent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION UPDATE LESSON ..");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Children.class);
        condigurationObj.addAnnotatedClass(Parent.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session sessionObj = factoryObj.openSession();        
                           
        Children childObj = (Children) sessionObj.get(Children.class, new Integer(1));
        childObj.setName("Nandni");
        childObj.setAge(20);
        
        /* In below two line we are changing the already exist parent name*/
        Parent parentObj = childObj.getParentObj();
        parentObj.setName("Divyansha");
        
        /* Using below three line we can add a new parent for the existing child */
        /* 
        Parent newParentObj = new Parent();
        newParentObj.setName("Divyesh");
        childObj.setParentObj(newParentObj);
        */
        
        Transaction transactionObj=sessionObj.beginTransaction();        
        sessionObj.update(childObj);                
        transactionObj.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        factoryObj.close();
        
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
