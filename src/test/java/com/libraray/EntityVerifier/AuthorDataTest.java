package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthorDataTest {

    @Test
    void checking() {
        Author author = new Author();
        Book book1 = new Book();
        Book book2 = new Book();
        User user = new User();
        InsertionData persist = new InsertionData();

        user.setUserName("Kavin_Adithya");
        user.setPassword("KavinDharani@3");
        persist.<User>insertData(user);

        user.setSecurityId(1);
        author.setAuthorName("Dennis Gosling");
        author.setAgeOfAuthor(95);
        author.setCountryName("USA");
        author.setCountOfBook(60000);
        author.setAuthorName("350493356481");
        author.setPassWord(user);


        book1.setName("C Programming");
        book1.setEdition("First Edition");
        book1.setLaunchDate(LocalDate.of(1972,3,7));
        book1.setAvailabilityNumber(200000);
        book1.setAuthor(author);


        book2.setName("Java Programming");
        book2.setEdition("Second Edition");
        book2.setLaunchDate(LocalDate.of(1995,3,7));
        book2.setAvailabilityNumber(400000);
        book2.setAuthor(author);


    }
}