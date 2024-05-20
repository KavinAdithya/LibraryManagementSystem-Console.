package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.interFace.LibraryException;

import java.util.List;

/*
    * this class is responsible to check the data is accurate and then only it will persist in database
    * To maintain the database data consistency it acts as an interface
 */
public class AuthorData {
    private final Author author;

    private final Validate valid ;
    private final InsertionData persist = new InsertionData();
    private final List<Book> books ;

    public AuthorData(Author author){
        this.author = author;
        this.books = author.getBooks();
        this.valid = new Validate(author.getPassWord());
        System.out.println(author);
    }

    public void checking() throws LibraryException{
        try{
            valid.checkUser();
            System.out.println("Valid Name...");

            valid.checkPassword();
            System.out.println("Valid password...");

            valid.nameValidate(author.getAuthorName());
            System.out.println("Valid author name...");

            valid.ageInvoker(author.getAgeOfAuthor());
            System.out.println("Valid Author Age...");

            if(checkBook())
                System.out.println("Verified!!! Author has valid authorized to use this books...");

            author.setCountOfBook(books.size());

            if(persist.insertData(author))
                System.out.println("Author Data is consistent...\nData Has been successfully persisted...");
        }catch(Exception e) {
            throw new LibraryException("Author Data is not consistent...\n Data Has been failed to persist..."+e.getMessage());
        }
    }
    //checking the books does not exist
    private boolean checkBook() throws LibraryException{
        try{
            if(books == null)
                throw new LibraryException("Author Must Has Books .. then only we can persist the author information");
            for(Book book : books){
                List<Book> book1 = persist.getDataHQL("from Book where name = '"+book.getName()+"'", Book.class);
                if(book1 != null)
                    throw new LibraryException("Author And Book Already Exists...");
            }
            return true;
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

}
