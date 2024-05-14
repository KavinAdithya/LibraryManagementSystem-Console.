package com.libraray.entity;

import org.hibernate.Session;
import com.libraray.dataBase.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorTest {

    Book book=new Book();

    Session session;

    @BeforeAll
    public void sessionObjectCreation(){
        SessionFactory sessionFactory= Hibernate.getSessionFactory();

        session=sessionFactory.openSession();
    }

    @Test
    public void authorTest(){
        try {
            LocalDate date=LocalDate.of(2005,3,7);
            Author author=new Author();
            author.setAgeOfAuthor(20);
            author.setAuthorId(19);
            author.setAuthorName("Kavin_Adithya");
            author.setCountOfBook(1);
            author.setCountryName("INDIA");
            book.setName("HeadFirst");
            book.setAuthor(author);
            book.setId(19);
            book.setEdition("First editition ");
            book.setLaunchDate(date);
            book.setAvailabilityNumber(20);
        }catch(Exception e){
            fail("UnExpected Exception... \n "+e);
        }
    }

    @AfterAll
    public void closeTheSession(){
        Transaction trans=session.beginTransaction();
        session.persist(book);
        trans.commit();
        session.close();
    }

}