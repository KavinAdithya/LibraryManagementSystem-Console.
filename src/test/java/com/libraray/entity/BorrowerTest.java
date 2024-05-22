package com.libraray.entity;

import com.libraray.dataBase.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BorrowerTest {

    Members borrow=new Members();
    Session session;
    @BeforeAll
    public void setUp() {
        SessionFactory sessionFactory= Hibernate.getSessionFactory();

        session=sessionFactory.openSession();
    }

    @Test
    public void borrowerTest(){
        try{
//            borrow.setBorrowerId(20);
//            borrow.setAddressOfBorrower("Nehru Nagar,Coimbatore");
//            borrow.setNameOfBorrower("Dharani SK");
//            borrow.setAdhaarNumber("3503 9335 6451");
//            borrow.setAgeOfBorrower(21);
        }
        catch(Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    @AfterAll
    public void tearDown() {
        session.getTransaction().begin();
        session.persist(borrow);
        session.getTransaction().commit();
    }
}