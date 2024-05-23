package com.libraray.EntityVerifier;

// this is a custom exception which is used when we needed to throw exception during object Creation
public class ObjectCreationException extends Exception{
    ObjectCreationException(String message){
        super(message);
    }
}
