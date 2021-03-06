package com.hibernate.training.mappings.manytoone;

import com.hibernate.training.mappings.manytoone.pojo.Student;
import com.hibernate.training.mappings.manytoone.pojo.Subject;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateEngine_SelectAll { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... START ............");
    	System.out.println(" ....... MANY TO ONE SELECT DEMO ............\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml");
        condigurationObj.addAnnotatedClass(Student.class);
        condigurationObj.addAnnotatedClass(Subject.class);
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session session = factoryObj.openSession();
        
        Criteria criteriaObj = session.createCriteria(Student.class);
/*       	//criteriaObj.add(Restrictions.or(Restrictions.like("name","%r%"), Restrictions.gt("age", new Integer(20))));
        //criteriaObj.add(Restrictions.sqlRestriction(" id not in(1,2) "));
        criteriaObj.add(Restrictions.sqlRestriction(" id not in(select id from parents_data)"));
*/        
        
        List<Student> students = criteriaObj.list();
        
        System.out.println("Subject\tStudent-Name");
        System.out.println("------------------------------------------");
        for(Student student:students){
        	System.out.print((student.getSubject()!=null)?student.getSubject().getName():"");
        	System.out.println("\t\t"+student.getName());
        }
        System.out.println("------------------------------------------");
               
        session.close();
        factoryObj.close();
        System.out.println(" ....... MANY TO ONE SELECT DONE ............");
        System.out.println("\n....... STOP ..........");
    }
 
}

