package com.libraray.entity;

import org.hibernate.Session;
import com.libraray.dataBase.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorTest {

    Book book=new Book();

    Session session;

    @BeforeAll
    @Test
    public void sessionObjectCreation(){
        SessionFactory sessionFactory= Hibernate.getSessionFactory();

        session=sessionFactory.openSession();
    }

    @Test
    public void authorTest(){
        try {
            book.setName("HeadFirst");
            book.setAuthor(null);
            book.setId(19);
            book.setEdition("First editition ");
            book.setLaunchDate(null);
            book.setAvailabilityNumber(20);
        }catch(Exception e){
            fail("UnExpected Exception... \n "+e);
        }
    }

    @AfterAll
    @Test
    public void closeTheSession(){
        Transaction trans=session.beginTransaction();
        session.persist(book);
        trans.commit();
        session.close();
    }

}