package com.libraray.ApplicationCRUD;

import org.junit.jupiter.api.Test;
import com.libraray.entity.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertionDataTest {
    Book book=new Book();
    Author author=new Author();
    Borrower borrower=new Borrower();

    CompositeBookAuthor cba=new CompositeBookAuthor();
    Due due=new Due();
    InsertionData data=new InsertionData();
    @Test
    public void updateAuthor(){
        author.setAuthorName("KaVin");
        author.setCountryName("USA");
        author.setAuthorId(43);
        author.setAgeOfAuthor(19);
        author.setCountOfBook(1);
        //assertTrue(data.<Author>insertData(author));
    }
    @Test
    public void updateData() {
        updateAuthor();
        book.setEdition("Seconed Edition");
        book.setAvailabilityNumber(20);
        book.setId(1943);
        book.setName("Head First");
        book.setAuthor(author);
        book.setLaunchDate(LocalDate.of(2005,3,7));
        //assertTrue(data.<Book>insertData(book));
    }

    @Test
    public void updateBorrower(){
        borrower.setAgeOfBorrower(78);
        borrower.setBorrowerId(23);
        borrower.setNameOfBorrower("Romeo");
        borrower.setAdhaarNumber("5674 2341 7894");
        borrower.setAddressOfBorrower("Ukarine");
        //assertTrue(data.<Borrower>insertData(borrower));
    }

    @Test
    public void updateDueAmount(){
        updateData();
        updateBorrower();
        cba.setBookDistributed(book);
        cba.setBookBorrower(borrower);
        due.setCompositeBookAuthor(cba);
        LocalDate date=LocalDate.of(1999,5,4);
        due.setDueDate(date);
        due.setReturnDate(date);
        due.setDateDistributed(date);
        due.setFineAmount(99.5);
        assertFalse(data.<Due>insertData(due));
    }

    @Test
    public void updateEntityTest(){
        author.setAuthorName("KaVinDharani");
        author.setCountryName("USA");
        author.setAuthorId(43);
        author.setAgeOfAuthor(19);
        author.setCountOfBook(1);
        assertTrue(data.<Author>updateData(author));
    }

    @Test
    public void deleteEntityTest(){
        author.setAuthorName("KaVin");
        author.setCountryName("USA");
        author.setAuthorId(43);
        author.setAgeOfAuthor(19);
        author.setCountOfBook(1);
        assertTrue(data.<Author>deleteData(author));
    }

    @Test
    public void retrieveEntityTest(){
        Author author1=data.<Author>getData(Author.class,19);
        if(author1==null)
            fail("Not Possible retrieve entity ");
        System.out.println(author1);
    }

    @Test
    public void retrieveHQLTest(){
        String query="from Author";
        List<Author> list=data.<Author>getDataHQL(query, Author.class);
        if(list==null)
            fail("Failed to load the data from datbase");
        for(Author author:list)
            System.out.println(author);

    }

    @Test
    public void retrieveSQLTest(){
        String query="select * from Authors";
        List<Author> list=data.<Author>getDataSQL(query, Author.class);
        if(list==null)
            fail("Failed to load the data from datbase");
        for(Author author:list)
            System.out.println(author);

    }

}