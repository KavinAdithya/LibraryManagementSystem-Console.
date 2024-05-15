package com.libraray.entity;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.dataBase.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserPassWordTest {
    InsertionData data=new InsertionData();
    @Test
    public void userPassWordTest(){

        UserPassWord upw=new UserPassWord();
        upw.setPassWord("KavinD");
        upw.setUserId(1);
        upw.setUserName("AdithYa");
        //assertTrue(data.<UserPassWord>insertData(upw));
        Author author=new Author();
        author.setPassWord(upw);
        author.setAuthorName("KaVIN");
        author.setAuthorId(1990);
        author.setCountryName("Dubai");
        author.setCountOfBook(12);
        assertTrue(data.<Author>insertData(author));
    }

}