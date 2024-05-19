package com.libraray.ApplicationCRUD;

import com.libraray.dataBase.Hibernate;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.interFace.DataLibraryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

//Responsible for CRUD operation in database
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
            System.out.println("Failed...Inserting Data!!! \n"+e);
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
            throw new DataLibraryException("Failed... to insert the data into database!!!\n"+e.getMessage());
        }
    }

    //method which is responsible to delete the entity from database
    public <T>boolean deleteData(T persistObject) throws DataLibraryException{
        try{
            transaction.begin();
            session.delete(persistObject);
            transaction.commit();
            return true;
        }
        catch(Exception e){
            throw new DataLibraryException("Failed... to delete the data into database!!!\n"+e.getMessage());
        }
    }

    //method which is responsible for retrieve entity from database
    public <T>T getData(Class<T> className,int primaryKey) throws DataLibraryException{
        try{
            transaction.begin();
            T persistObject = session.load(className,primaryKey);
            transaction.commit();
            return persistObject;
        }
        catch(Exception e){
            throw new DataLibraryException("Failed... to retrieve the data from database!!!\n"+e.getMessage());
        }
    }


    //retrieve data from database query given by the user or developer which means HQL language
    public <T> List<T> getDataHQL(String query,Class<T> className) throws DataLibraryException{
        try{
            transaction.begin();
            Query<T> queryHQl = session.createQuery(query,className);
            List<T> listOfObjects = queryHQl.getResultList();
            transaction.commit();
            return listOfObjects;
        }catch(Exception e){
            throw new DataLibraryException("Failed... to retrieve the data into database!!!\n"+e.getMessage());
        }
    }

    //retrieve data from database query given by user or developer in SQL syntax
    public <T>List<T> getDataSQL(String query,Class<T> className) throws DataLibraryException{
        try{
            transaction.begin();
            NativeQuery<T> querySQL = session.createNativeQuery(query,className);
            List<T> listOfObjects = querySQL.getResultList();
            transaction.commit();
            return listOfObjects;
        }catch(Exception e){
            throw new DataLibraryException("Failed... to retrieve the data into database!!!\n"+e.getMessage());
        }
    }

    public boolean insertListEntity(List<?> persistObjects) throws DataLibraryException {
        try{
            transaction.begin();

            for(Object persist : persistObjects)
                session.persist(persist);

            transaction.commit();
            return true;
        }catch(Exception e){
            throw new DataLibraryException("Failed to persist in the entities in the dataBase "+e.getMessage());
        }
    }
}
