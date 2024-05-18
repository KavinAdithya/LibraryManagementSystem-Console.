package com.libraray.interFace;

/*
    IT is  exception class which is a user customized exception
    it was used hole the project to raise our own exception NOT BY JVM
 */
public class LibraryException  extends Exception{
    public LibraryException(String message){
        super(message);
    }
}
