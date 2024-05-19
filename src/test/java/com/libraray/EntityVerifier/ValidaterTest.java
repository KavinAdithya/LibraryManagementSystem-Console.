package com.libraray.EntityVerifier;

import com.libraray.interFace.LibraryException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidaterTest {

    @Test
    void nameValidate() throws Exception {
        Validater validater = new Validater(null);

      try{
          validater.nameValidate("                                         Kavin     Adithya     Dharani    ");

      }catch(LibraryException e){
          System.out.println(e);
          fail();
      }

        System.out.println(validater.getName());
    }
}