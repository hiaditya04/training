package com.hibernate.training;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateSessionFactory {

    private static final String CONFIG_FILE = "hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    public HibernateSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
    }

    public static HibernateSessionFactory create(Configuration cfg) throws HibernateException {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory(sessionFactory);
        System.out.println("Hibernate Session Factory initialized successfully");

        return hibernateSessionFactory;
    }

    public void shutDown(){
        sessionFactory.close();

    }

    public static void buildSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure(CONFIG_FILE);
        create(cfg);
    }


    public  static Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    public  static Session getNewSession() {
        return sessionFactory.openSession();
    }
    /**
     * In Web Applications with Hibernate, when the context is destroyed or reload, it's necessary to destroy the session factory
     * to evict problems with connection pools, caches etc.
     */
    public static void shutdown() {
        System.out.println("Closing Hibernate Session Factory");
        if(sessionFactory !=null && sessionFactory.isClosed()==false){
            sessionFactory.close();
        }
    }



}
