package com.hibernate.training.mappings.onetoone;



import com.hibernate.training.mappings.onetoone.pojo.Pupil;
import com.hibernate.training.mappings.onetoone.pojo.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(".......ENGINE START.......");  
    	System.out.println(".. ONE TO ONE ANNOTATION INSERT LESSON ..");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml");
        configurationObj.addAnnotatedClass(Pupil.class);
        configurationObj.addAnnotatedClass(Result.class);
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();

    	Pupil pupilObj = new Pupil();
    	pupilObj.setRollNumber(4);
    	pupilObj.setName("Digpal");
    	pupilObj.setAddress("Raj-Palace,Mahel-Road,Baroda");    	
        
        Result resultObj = new Result();
        resultObj.setRollNumber(pupilObj.getRollNumber());
        resultObj.setMathsMarks(43);
        resultObj.setScienceMarks(60);
        resultObj.setTotalMarks((resultObj.getScienceMarks()+resultObj.getMathsMarks()));        
        resultObj.setPupil(pupilObj);        
        pupilObj.setResult(resultObj);
        
        Transaction transactionObj = sessionObj.beginTransaction();
        //sessionObj.save(resultObj);
        sessionObj.save(pupilObj);
                
        transactionObj.commit();        
        sessionObj.close();        
        sessionFactoryObj.close();
        System.out.println("....... DATA SAVED SUCCESSFULLY ............");
        System.out.println(".......ENGINE STOP.......");
    }
 
}
