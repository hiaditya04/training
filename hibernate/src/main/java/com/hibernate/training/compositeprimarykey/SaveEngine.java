package com.hibernate.training.compositeprimarykey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.compositeprimarykey.pojo.Creature;
import com.hibernate.training.compositeprimarykey.pojo.CreatureId;

public class SaveEngine {

    public static void main(String[] javaPlanet) {
        try {
            System.out.println("********** START ************");
            Configuration configurationObj = new Configuration();
            configurationObj.configure("hibernate.cfg.xml");
            configurationObj.addAnnotatedClass(Creature.class);
            configurationObj.addAnnotatedClass(CreatureId.class);

            SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
            Session sessionObj = sessionFactoryObj.openSession();

            Creature creature = new Creature();
            CreatureId creatureId = new CreatureId();
            creatureId.setId(1);
            creatureId.setName("Tiger1");
            creature.setColor("Red-Yellow");
            creature.setCreatureId(creatureId);

            Transaction tx = sessionObj.beginTransaction();
            sessionObj.save(creature);
            tx.commit();
            System.out.println("Creature's Data saved successfully !");

            sessionObj.close();
            sessionFactoryObj.close();
            System.out.println("********** STOP ************");
        } finally {
            HibernateSessionFactory.shutdown();
        }
    }


}
