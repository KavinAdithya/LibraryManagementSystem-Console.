package com.libraray.ApplicationCRUD;

import com.libraray.dataBase.Hibernate;
import com.libraray.interFace.DataLibraryException;
import com.libraray.interFace.LibraryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

//Responsible for CRUD operation in database
@SuppressWarnings("deprecation")
public class InsertionData {
    private final Session session = Hibernate.getSessionFactory().openSession();

    private final Transaction transaction = session.getTransaction();

    /*
        *Method which is responsible to insert tha data into database Entity does not matter
        * because we used the type as generic
     */
    public <T>boolean insertData(T persistObject){
        try {
            transaction.begin();
            session.persist(persistObject);
            transaction.commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    //Method responsible to update the existing data into thw database
    public <T>boolean updateData(T persistObject) throws DataLibraryException{
        try{
            transaction.begin();
            session.update(persistObject);
            transaction.commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    //method which is responsible to delete the entity from database
    public <T>boolean deleteData(T persistObject){
        try{
            transaction.begin();
            session.delete(persistObject);
            transaction.commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    //method which is responsible for retrieve entity from database
    public <T>T getData(Class<T> className,int primaryKey){
        try{
            transaction.begin();
            T persistObject = session.load(className,primaryKey);
            transaction.commit();
            return persistObject;
        }
        catch(Exception e){
            return null;
        }
    }


    //retrieve data from database query given by the user or developer which means HQL language
    public <T> List<T> getDataHQL(String query,Class<T> className){
        try{
            transaction.begin();
            Query<T> queryHQl = session.createQuery(query,className);
            List<T> listOfObjects = queryHQl.getResultList();
            transaction.commit();
            return listOfObjects;
        }catch(Exception e){
            return null;
        }
    }

    //retrieve data from database query given by user or developer in SQL syntax
    public <T>List<T> getDataSQL(String query,Class<T> className) {
        try{
            transaction.begin();
            NativeQuery<T> querySQL = session.createNativeQuery(query,className);
            List<T> listOfObjects = querySQL.getResultList();
            transaction.commit();
            return listOfObjects;
        }catch(Exception e){
            return null;
        }
    }

    public boolean insertListEntity(List<?> persistObjects)  {
        try{
            transaction.begin();

            for(Object persist : persistObjects)
                session.persist(persist);

            transaction.commit();
            return true;
        }catch(Exception e){
           return false;
        }
    }

    public boolean shutDownFactory(){
        try {
            Hibernate.shutDownSessionFactory();
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
