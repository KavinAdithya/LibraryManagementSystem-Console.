package com.libraray.entity;

import com.libraray.ApplicationCRUD.InsertionData;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EntityTester {
    InsertionData crud = new InsertionData();
    Author author = new Author();
    User user = new User();

    Book book1 = new Book();
    Book book2 = new Book();
    List<Book> books = new ArrayList<>();
    Due due = new Due();

    Members borrower = new Members();

    @BeforeAll
    public void dataInsertionOfAuthor(){
        author.setAuthorName("J.K.Rowling");
        author.setCountOfBook(14);
        author.setCountryName("United Kingdom");
        author.setAgeOfAuthor(57);
        author.setAuthorId(1);
       // author.setBooks(books);
        //author.setPassWord(user);
    }


    @BeforeAll
    public void dataInsertOfBook(){
        book1.setName("The harry Potter Series");
        book1.setAuthor(author);
        book1.setLaunchDate(LocalDate.of(2000,5,3));
        book1.setEdition("First Edition");
        book1.setAvailabilityNumber(25);
        //book1.setId(7);
        //book2.setId(11);
        book2.setAvailabilityNumber(56);
        book2.setAuthor(author);
        book2.setEdition("Second Edition");
        book2.setLaunchDate(LocalDate.of(2002,4,30));
        book2.setName("The Casual Vacancy");
        books.add(book1);
        books.add(book2);
    }

    @BeforeAll
    public void dataInsertOfSecurity(){
        user.setSecurityId(1);
        user.setUserName("Rowling@3");
        user.setPassword("row@3");
    }

    @Test
    public void test(){
        //crud.<Author>insertData(author);
       // crud.<Book>insertData(book1);
       // crud.<Book>insertData(book2);
        //crud.<Book>updateData(book1);
        //crud.<User>insertData(user);
        //crud.<Author>updateData(author);
    }
}