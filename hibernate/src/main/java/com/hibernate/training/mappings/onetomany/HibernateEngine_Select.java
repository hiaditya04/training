package com.hibernate.training.mappings.onetomany;

import com.hibernate.training.mappings.onetoone.pojo.Pupil;
import com.hibernate.training.mappings.onetoone.pojo.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO ONE ANNOTATION SELECT LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
        configurationObj.addAnnotatedClass(Result.class);
        configurationObj.addAnnotatedClass(Pupil.class);
         
        Result resultObj = (Result) sessionObj.get(Result.class, new Integer(4));
        Pupil pupilObj= resultObj.getPupil();
                
        System.out.println("\n--------Pupil Data----------");
        System.out.println("Id	: "+pupilObj.getRollNumber());
        System.out.println("Name	: "+pupilObj.getName());
        System.out.println("Address	: "+pupilObj.getAddress());
        System.out.println("\n------------------------------\n");
                       
        System.out.println("\n---------Result Data--------");                       
        System.out.println("Maths-Marks	: "+resultObj.getMathsMarks());
        System.out.println("Science-Marks	: "+resultObj.getScienceMarks());
        System.out.println("Total-Marks	: "+resultObj.getTotalMarks());
        
        System.out.println("-------------------------------");                
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
