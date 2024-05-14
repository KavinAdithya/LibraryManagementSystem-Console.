package com.libraray;

import com.libraray.dataBase.Hibernate;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.constant.Constable;
import org.hibernate.cfg.Configuration;

public class DriverSoftware {

    public static void main(String[] args) {


        Configuration config=new Configuration();
        config.configure().addAnnotatedClass(Author.class);

        SessionFactory sessionFactory= config.buildSessionFactory();

        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

//        Book book=new Book();
//        book.setName("HeadFirst");
//        book.setAvailabilityNumber(1);
//        book.setId(1);
//        book.setEdition("aaa");
//        book.setLaunchDate(null);
//        session.persist(book);

        Author author=new Author();
        author.setAgeOfAuthor(20);
        author.setAuthorId(19);
        author.setAuthorName("Kavin_Adithya");
        author.setCountOfBook(1);
        author.setCountryName("INDIA");
        session.persist(author);
        transaction.commit();
    }
}
