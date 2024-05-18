package com.libraray.EntityVerifier;

import com.libraray.entity.Author;

/*
    * this class is responsible to check the data is accurate and then only it will persist in database
    * To maintain the database data consistency it acts as a interface
 */
public class AuthorData {
    private Author author;

    public AuthorData(Author author){
        this.author=author;
    }




}
