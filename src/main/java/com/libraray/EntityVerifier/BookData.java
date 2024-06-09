package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Book;
import com.libraray.interFace.BookVerifier;
import com.libraray.interFace.ObjectCreationException;
import java.util.List;

/*
    * It implements BookVerifier Interface.
    * It checks whether the Book data is consistent in terms of null.
    * It will check whether the given book id is unique.
    * It will check the book does exist or not.
    * It will check the availability of book is positive.
    * It will update the amount of book by new fine amount + old amount.
 */

public class BookData implements BookVerifier {
    private final Book book;
    private final InsertionData persist = new InsertionData();

    //parameterized  constructor used to instantiate the book object
    public BookData(Book book) throws ObjectCreationException {
        if(!checkDataIsFilled(book)){
            book = null;
            throw new ObjectCreationException("Failed to instantiate it .. due to in consistent book data..");
        }
        this.book = book;

    }

    private boolean checkDataIsFilled(Book book) {
        return book.getAmount() != 0.00 &&
                book.getName() != null &&
                book.getEdition() != null &&
                book.getAuthor() != null &&
                book.getLaunchDate() != null ;
    }

    //Method which is responsible to verify allocated id for this book is correct or wrong
    @Override
    public boolean idVerifier() {
        return persist.getDataEager(Book.class, book.getId()) == null;
    }

    /*
        *This method is responsible whether the given book is already
        * exists or not returns boolean value as a result.
        *
     */
    @Override
    public boolean bookExists() {
        String query = "from Book where name = '" +
                book.getName() + "' AND edition = '" +
                book.getEdition() + "'";
        List<Book> books = persist.getDataHQL(query, Book.class);

        return  persist.getDataHQL(query, Book.class).isEmpty();
    }


    //Check the book availability count
    @Override
    public boolean availabilityBookChecker() {
        return book.getAvailabilityNumber() > 0;
    }

    //Update the amount does the book gained . Entity Inundation....
    @Override
    public boolean amountUpdate() {

        int id = book.getId();
        Book book = persist.getDataEager(Book.class, id);
        if(this.book.equals(book)){
            this.book.setAmount(
                            book.getAmount() +
                            this.book.getAmount());
            return persist.updateData(this.book);
        }
        return false;
    }
}
