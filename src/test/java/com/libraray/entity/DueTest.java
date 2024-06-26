package com.libraray.entity;

import com.libraray.dataBase.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.lang.reflect.Member;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DueTest {
    Due due=new Due();
    Session session;
    @BeforeAll
    public void setUp() {
        SessionFactory sessionFactory= Hibernate.getSessionFactory();
        session=sessionFactory.openSession();
    }

    @Test
    public void dueTest(){
        try{
            LocalDate date=LocalDate.of(2005,3,7);
            due.setDueDate(date);
            due.setDateDistributed(date);
            due.setReturnDate(date);
            due.setFineAmount(10.00);
            CompositeBookAuthor cba=new CompositeBookAuthor();
            Members borrow=new Members();
            borrow.setMemberId(20);
            borrow.setAddressOfMember("Nehru Nagar,Coimbatore");
            borrow.setNameOfMember("Dharani SK");
            borrow.setAadhaarNumber("3503 9335 6451");
            borrow.setAgeOfMember(21);
            Author author=new Author();
            author.setAgeOfAuthor(20);
            author.setAuthorId(19);
            author.setAuthorName("Kavin_Adithya");
            author.setCountOfBook(1);
            author.setCountryName("INDIA");
            Book book=new Book();
            book.setName("HeadFirst");
            book.setAuthor(author);
            book.setId(19);
            book.setEdition("First editition ");
            book.setLaunchDate(date);
            book.setAvailabilityNumber(20);
            cba.setBookMember(borrow);
            cba.setBookDistributed(book);
            due.setCompositeBookAuthor(cba);
        }
        catch(Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    @AfterAll
    public void tearDown() {
        session.getTransaction().begin();
        session.persist(due);
        session.getTransaction().commit();
    }
}