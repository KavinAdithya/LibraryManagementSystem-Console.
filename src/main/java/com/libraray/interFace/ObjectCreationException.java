package com.libraray.interFace;

// this is a custom exception which is used when we needed to throw exception during object Creation
public class ObjectCreationException extends Exception{
    public ObjectCreationException(String message){
        super(message);
    }
}
