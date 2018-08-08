package com.hibernate.training.mappings.manytoone;

import java.util.List;

import com.hibernate.training.mappings.manytoone.pojo.Children;
import com.hibernate.training.mappings.manytoone.pojo.Parent;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
 
public class HibernateEngine_SelectAll { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... START ............");
    	System.out.println(" ....... MANY TO ONE SELECT DEMO ............\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Children.class);
        condigurationObj.addAnnotatedClass(Parent.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session sessionObj = factoryObj.openSession();        
        
        Criteria criteriaObj = sessionObj.createCriteria(Children.class);
/*       	//criteriaObj.add(Restrictions.or(Restrictions.like("name","%r%"), Restrictions.gt("age", new Integer(20))));
        //criteriaObj.add(Restrictions.sqlRestriction(" id not in(1,2) "));
        criteriaObj.add(Restrictions.sqlRestriction(" id not in(select id from parents_data)"));
*/        
        
        List<Children> childList = criteriaObj.list();
        
        System.out.println("Parent-Name\tChild-Name \tChild-Age");
        System.out.println("------------------------------------------");
        for(Children childObj:childList){
        	System.out.print((childObj.getParentObj()!=null)?childObj.getParentObj().getName():"");
        	System.out.print("\t\t"+childObj.getName());
        	System.out.println("\t\t"+childObj.getAge());        	
        }
        System.out.println("------------------------------------------");
               
        sessionObj.close();
        factoryObj.close();
        System.out.println(" ....... MANY TO ONE SELECT DONE ............");
        System.out.println("\n....... STOP ..........");
    }
 
}

