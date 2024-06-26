package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Author;
import com.libraray.entity.Book;
import com.libraray.interFace.AuthorVerifier;
import com.libraray.interFace.LibraryException;
import com.libraray.interFace.ObjectCreationException;
import com.libraray.interFace.Validate;
import java.util.List;

/*
    * It implements Author verifier interface
    * This class is responsible to check the data is accurate and then only it will persist in database.
    * To maintain the database data consistency it acts as an interface.
    * Checks the author object does not null during object initialization.
    * Checks the author already exists based on author name.
    * Checking author book does not exist already.
    * Driver for this class is checking -> userName valid, password valid, age valid, name valid and setting book counts
    * At last all the condition satisfy, and then it will persist the author data into database.
 */

public class AuthorData implements AuthorVerifier {
    private final Author author;

    private final Validate valid ;
    private final InsertionData persist = new InsertionData();
    private final List<Book> books ;

    //parameterized Constructor
    public AuthorData(Author author) throws ObjectCreationException {
        Author author1;
        author1 = author;
        this.books = author.getBooks();

        if(!checkDataIsFilled(author))
            throw new ObjectCreationException("Failed to instantiate it .. due to in consistent author data..");

        this.author = author1;
        this.valid = new Validates(author.getPassWord());
    }

    //This method is responsible to check the author attributes are consistent
    private boolean checkDataIsFilled(Author author) {
        return author.getAuthorName() != null &&
                author.getPassWord() != null &&
                author.getBooks() != null &&
                author.getCountryName() != null &&
                author.getAgeOfAuthor() != 0 &&
                author.getCountOfBook() != 0;
    }

    //Checking the Object Already Exists ... Checking based on author name
    private boolean checkEntityExists(){
        String query = "from Members where authorName = '" + author.getAuthorName() + "'";

        List<Author> members1 = persist.getDataHQL(query, Author.class);

        return members1.isEmpty();
    }

    //Driver for this class
    //it is a central method for
    // checking author data has been valid after the object has mandatory field values check
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

            if(checkBook() || checkEntityExists())
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
                List<Book> book1 = persist.getDataHQL("from Book where name = '" + book.getName() + "'", Book.class);
                if(book1 != null)
                    throw new LibraryException("Author And Book Already Exists...");
            }
            return true;
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
}