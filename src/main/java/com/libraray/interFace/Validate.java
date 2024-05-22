package com.libraray.interFace;

public interface Validate extends Login {
    void nameValidate(String name) throws LibraryException;
    void ageInvoker(int age) throws LibraryException;
     String checkAadhaar(String aadhaarNumber);
}
