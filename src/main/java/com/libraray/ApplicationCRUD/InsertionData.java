package com.libraray.ApplicationCRUD;

import com.libraray.dataBase.Hibernate;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Responsible for CRUD operation in database
public class InsertionData {
    private final Session session= Hibernate.getSessionFactory().openSession();

    private final Transaction transaction= session.getTransaction();

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
    public <T>boolean updateData(T persistObject){
        try{
            transaction.begin();
            session.update(persistObject);
            transaction.commit();
            return true;
        }
        catch(Exception e){
            System.out.println("Failed... to insert the data into database!!!");
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
            System.out.println("Failed...To delete entity from database");
            return false;
        }
    }

    //method which is responsible for retrieve entity from database
    public <T>T getData(Class<T> className,int primaryKey){
        try{
            transaction.begin();
            T persistObject=session.get(className,primaryKey);
            transaction.commit();
            return persistObject;
        }
        catch(Exception e){
            System.out.println("Failed...To retrieve entity from database");
            return null;
        }
    }

}
