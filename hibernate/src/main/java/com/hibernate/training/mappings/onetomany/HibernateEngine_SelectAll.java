package com.hibernate.training.mappings.onetomany;

import com.hibernate.training.mappings.onetomany.pojo.Student;
import com.hibernate.training.mappings.onetomany.pojo.Subject;
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
        
        Criteria criteriaObj = session.createCriteria(Subject.class);
/*       	//criteriaObj.add(Restrictions.or(Restrictions.like("name","%r%"), Restrictions.gt("age", new Integer(20))));
        //criteriaObj.add(Restrictions.sqlRestriction(" id not in(1,2) "));
        criteriaObj.add(Restrictions.sqlRestriction(" id not in(select id from parents_data)"));
*/        
        
        List<Subject> subjects = criteriaObj.list();
        
        System.out.println("Subject");
        System.out.println("------------------------------------------");
        for(Subject subject:subjects){
            System.out.println("\t\t"+subject.getName());
            System.out.println("\t\t\tStudents");
            System.out.println("------------------------------------------");
            for(Student student : subject.getStudents()) {
                System.out.println("\t\t\t\t" +((student != null) ? student.getName() : ""));
            }
        }
        System.out.println("------------------------------------------");
               
        session.close();
        factoryObj.close();
        System.out.println(" ....... MANY TO ONE SELECT DONE ............");
        System.out.println("\n....... STOP ..........");
    }
 
}

