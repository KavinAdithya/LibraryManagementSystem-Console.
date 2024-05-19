package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.User;
import com.libraray.interFace.LibraryException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginDataManagerTest {
     private User user = new User();
    private LoginDataManager data ;
    @Test
    void checkUser() throws LibraryException {

        InsertionData persist = new InsertionData();
       // persist.<User>insertData(user);

         assertTrue(data.checkUser());
    }

    @Test
    void checkPassword()  throws LibraryException {

        user.setSecurityId(1);
        user.setPassword("KavinDharani@3");
        user.setUserName("KavinAdithya");
        data = new LoginDataManager(user);
        assertTrue(data.checkPassword());
    }

    @BeforeAll
    void userExists() {


    }
}