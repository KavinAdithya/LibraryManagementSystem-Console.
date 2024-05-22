package com.libraray.interFace;

public interface Login {
    boolean checkUser() throws LibraryException;
    boolean checkPassword() throws LibraryException;

}
