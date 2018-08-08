package com.hibernate.training.compositeprimarykey;

import com.hibernate.training.HibernateSessionFactory;
import com.hibernate.training.compositeprimarykey.pojo.Creature;
import com.hibernate.training.compositeprimarykey.pojo.CreatureId;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class SelectEngine {

    public static void main(String[] javaPlanet) {

        try {
            System.out.println("********** START ************");
            Configuration configurationObj = new Configuration();
            configurationObj.configure("hibernate.cfg.xml");

            SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
            Session sessionObj = sessionFactoryObj.openSession();


            CreatureId creatureId = new CreatureId();
            creatureId.setId(1);
            creatureId.setName("Tiger1");

            Creature creatureData = (Creature) sessionObj.get(Creature.class, creatureId);
            System.out.println("  Creature's Data  ");
            System.out.println("--------------------");
            System.out.println(" Id	: " + creatureData.getCreatureId().getId());
            System.out.println(" Name	: " + creatureData.getCreatureId().getName());
            System.out.println(" Color	: " + creatureData.getColor());

            sessionObj.close();
            sessionFactoryObj.close();

            System.out.println("\n-------STOP---------");
        } finally {
            HibernateSessionFactory.shutdown();
        }
    }
}
