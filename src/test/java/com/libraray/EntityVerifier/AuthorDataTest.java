package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.entity.User;
import com.libraray.interFace.LibraryException;
import com.libraray.interFace.ObjectCreationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AuthorDataTest {

    @Test
    void checking() throws ObjectCreationException {
        Author author = new Author();
        Book book1 = new Book();
        Book book2 = new Book();
        User user = new User();
        InsertionData persist = new InsertionData();

        user.setUserName("KaviAdithya");
        user.setPassword("KavinDharani@3");
        //persist.<User>insertData(user);


        author.setAuthorName("Dennis Gosling");
        author.setAgeOfAuthor(95);
        author.setCountryName("USA");
        author.setCountOfBook(60000);
        //author.setAuthorId(1);
        author.setPassWord(user);


        book1.setName("C Programming");
        book1.setId(2);
        book1.setEdition("First Edition");
        book1.setLaunchDate(LocalDate.of(1972,3,7));
        book1.setAvailabilityNumber(200000);
        book1.setAuthor(author);
       // persist.<Book>insertData(book1);

        book2.setName("Java Programming");
        book2.setId(3);
        book2.setEdition("Second Edition");
        book2.setLaunchDate(LocalDate.of(1995,3,7));
        book2.setAvailabilityNumber(400000);book2.setAuthor(author);
       // persist.<Book>insertData(book2);

        List<Book> books = new ArrayList<>();
        //books.add(book1);
        books.add(book2);
        author.setBooks(books);
        AuthorData authordata = new AuthorData(author);
        try {
            authordata.checking();
        }catch(LibraryException e){
            System.out.println(e.getMessage());
        }
    }
}