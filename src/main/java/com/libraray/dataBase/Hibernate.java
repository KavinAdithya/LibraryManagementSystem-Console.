package com.libraray.dataBase;

import com.libraray.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Hibernate {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    //method Which is responsible for Creating a session factory from configuration
    private static SessionFactory buildSessionFactory(){
        //Configuration Object which reads the configuration file and generate metadata to Session factory
        try {
            Configuration configuration =
                    new Configuration()
                            .configure()
                            .addAnnotatedClass(User.class)
                            .addAnnotatedClass(Author.class)
                            .addAnnotatedClass(Book.class)
                            .addAnnotatedClass(Members.class)
                            .addAnnotatedClass(Due.class);

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch(Exception e){
            //this exception has been raised by JVM when it can't able to initialize the static block variable or block
            throw new ExceptionInInitializerError(e);
        }
    }

    //Getter to retrieve the session factory object which is responsible to connect the database
    public static  SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //Used to close the session factory object
    public  static void shutDownSessionFactory(){
        sessionFactory.close();
    }
}
