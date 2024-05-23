package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Book;
import com.libraray.interFace.BookVerifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookDataTest {
    Book book = new Book();
    InsertionData persist = new InsertionData();

    BookVerifier bookVerifier;
    @BeforeAll
     void data() throws ObjectCreationException {
        book.setId(1);
        book.setName("Java Programming..");
        book.setAuthor(null);
        book.setAmount(1000.00);
        book.setEdition("First Edition");
        book.setAvailabilityNumber(2);
        //persist.insertData(book);
        this.bookVerifier = new BookData(book);
    }
    @Test
    void idVerifier() {
        assertTrue(bookVerifier.idVerifier());
    }

    @Test
    void bookExists() {
        assertFalse(bookVerifier.bookExists());
    }

    @Test
    void availabilityBookChecker() {
        assertTrue(bookVerifier.availabilityBookChecker());
    }

    @Test
    void amountUpdate() {
        assertTrue(bookVerifier.amountUpdate());
    }
}