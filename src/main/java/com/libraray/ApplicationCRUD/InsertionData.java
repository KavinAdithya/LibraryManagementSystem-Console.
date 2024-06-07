package com.libraray.ApplicationCRUD;

import com.libraray.dataBase.Hibernate;
import org.hibernate.Session;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

//Responsible for CRUD operation in database
public class InsertionData {
    /*
        *Method which is responsible to insert tha data into database Entity does not matter
        * because we used the type as generic
     */

    public <T>boolean insertData(T persistObject){
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            session.persist(persistObject);
            session.getTransaction().commit();

            return true;
        }
        catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return false;
        }
    }

    //Method responsible to update the existing data into thw database
    public <T>boolean updateData(T persistObject){
        Session session = null;
        try{
            session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            session.update(persistObject);
            session.getTransaction().commit();

            return true;
        }
        catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return false;
        }
    }

    //method which is responsible to delete the entity from database
    public <T>boolean deleteData(T persistObject){
        Session session = null;
        try{
            session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            session.delete(persistObject);
            session.getTransaction().commit();

            return true;
        }
        catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return false;
        }
    }

    //method which is responsible for retrieve entity from database
    public <T>T getData(Class<T> className,int primaryKey){
        Session session = null;
        try{
            session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            T persistObject = session.load(className,primaryKey);
            session.getTransaction().commit();

            return persistObject;
        }
        catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return null;
        }
    }

    public <T>T getDataEager(Class<T> className,int primaryKey){
        Session session = null;
        try{
            session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            T persistObject = session.get(className,primaryKey);
            session.getTransaction().commit();

            return persistObject;
        }
        catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return null;
        }
    }


    //retrieve data from database query given by the user or developer which means HQL language
    public <T> List<T> getDataHQL(String query,Class<T> className){
        Session session = null;
        try{
             session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            Query<T> queryHQl = session.createQuery(query,className);
            List<T> listOfObjects = queryHQl.getResultList();
            session.getTransaction().commit();

            for(T object : listOfObjects)
                session.detach(object);

            return listOfObjects;
        }catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
            return null;
        }
    }

    //retrieve data from database query given by user or developer in SQL syntax
    public <T>List<T> getDataSQL(String query,Class<T> className) {
        Session session = null;
        try{
             session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();
            NativeQuery<T> querySQL = session.createNativeQuery(query,className);
            List<T> listOfObjects = querySQL.getResultList();
            session.getTransaction().commit();

            return listOfObjects;
        }catch(Exception e){
            if(session != null)
                session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertListEntity(List<?> persistObjects)  {
        Session session = null;
        try{
             session = Hibernate.getSessionFactory().openSession();

            session.getTransaction().begin();

            for(Object persist : persistObjects)
                session.persist(persist);

            session.getTransaction().commit();

            return true;
        }catch(Exception e){

            if(session != null)
                session.getTransaction().rollback();

            e.printStackTrace();
           return false;
        }
    }

    public boolean shutDownFactory(){
        try {
            Hibernate.shutDownSessionFactory();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
