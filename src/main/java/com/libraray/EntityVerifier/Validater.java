package com.libraray.EntityVerifier;

import com.libraray.interFace.LibraryException;

public class Validater {
    private String name;

    public String getName() {
        return name;
    }

    //Name Validating
    protected void nameValidate(String name) throws LibraryException {
        try{
            if(checkValidCharacters(name) || trimTheName(name))
                throw new NullPointerException();
        }
        catch(Exception e) {
            throw new LibraryException("You Missed to provide Your Correct Name..");
        }
    }

    //Method is used to remove unwanted space in both front and back
    private boolean trimTheName(String name) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        int count = -1;
        boolean lastAlphabet = false;

        for(char character : name.toCharArray()){
            if(count >= 0 && name.charAt(count) == ' ' && character != ' ' && lastAlphabet )
                 stringBuilder.append(' ');
            if(character != ' ') {
                stringBuilder.append(character);
                lastAlphabet=true;
            }
            count++;
        }

        this.name = stringBuilder.toString();
        return false;
    }

    //Method is responsible check whether name contains alphabets or space characters only
    private boolean checkValidCharacters(String name) throws Exception{
        for(char character : name.toCharArray()){
            int asciiCharacter = Character.toLowerCase(character) - 'a';

            if(!(asciiCharacter >= 0 && asciiCharacter <= 32) && character != ' ')
                return true;
        }
        return false;
    }

    //method is used to invoke the method og checkAe if
    //the age is valid then it will not generate exception
    public void ageInvoker(int age) throws LibraryException{
        try{
            if(!checkAge(age))
                throw new Exception("Age is Not Valid");
        }
        catch(Exception e){
            throw new LibraryException("Age is Not Valid");
        }
    }


    //method checking the age is valid or not
    private boolean checkAge(int age){
        if(age > 0 && age < 110)
            return true;
        return false;
    }

    //given count book is positive or not checker
    private boolean checkBook(int countBook){
        if(countBook>1)
            return false;
        return true;
    }


    //check the Aadhaar is valid or not
    public String checkAadhaar(String aadhaarNumber){
        if(aadhaarNumber.length() != 12)
            return null;

        StringBuilder stringBuilder = new StringBuilder();

        for(int k = 0; k < 12; k++){
            char character = aadhaarNumber.charAt(k);
            if(k == 4 || k == 8)
                stringBuilder.append(' ');
            if(character >= '0' && character <= '9')
                stringBuilder.append(character);
            else
                return null;
        }

        return stringBuilder.toString();


    }
}
