package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.interFace.LibraryException;

import java.util.List;

/*
    * this class is responsible to check the data is accurate and then only it will persist in database
    * To maintain the database data consistency it acts as a interface
 */
public class AuthorData extends Validater{
    private final Author author;

    private final InsertionData persist = new InsertionData();
    private final List<Book> books ;

    public AuthorData(Author author){
        super(author.getPassWord());
        this.author = author;
        this.books = author.getBooks();
    }

    public boolean checking() throws LibraryException{
        try{
            checkUser();
            checkPassword();
            nameValidate(author.getAuthorName());
            ageInvoker(author.getAgeOfAuthor());
            checkBook(author.getCountOfBook());
            persistBook();
            persist.<Author>insertData(author);
            return true;
        }catch(Exception e) {
            throw new LibraryException("Author Not Valid..Provide proper information... \n"+e.getMessage());
        }
    }

    //checking the book exists if not persist the book
    private void persistBook() throws LibraryException{
        try{

        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    //checking the books does not exist
    private void checkBook() throws LibraryException{
        try{
            if(books == null)
                throw new LibraryException("Author Must Has Books .. then only we can persist the author information");
            for(Book book : books){
                List<Book> book1 = persist.<Book>getDataHQL("from Book where name = "+book.getName(), Book.class);
                if(book1 != null)
                    throw new LibraryException("Author And Book Already Exists...");
            }
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    //persisting the book into the database
    private void persistBooks() throws LibraryException{
        try{
            for(Book book : books)
                persist.<Book>insertData(book);

        }catch(Exception e){
            throw new LibraryException("Issue In book Data Retry After a While...");
        }
    }
}
