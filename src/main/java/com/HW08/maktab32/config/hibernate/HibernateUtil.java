package com.HW08.maktab32.config.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory dbTestSessionFactory;

    private static Session session;
    private static Session dbTestSession;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();

        dbTestSessionFactory = new Configuration().configure("hibernate.testDatabase.cfg.xml").buildSessionFactory();
        dbTestSession = dbTestSessionFactory.openSession();

    }

    public static Session getSession() {
        return session;
    }

    public static Session getDbTestSession(){
        return dbTestSession;
    }
}
