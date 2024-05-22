package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.User;
import com.libraray.interFace.LibraryException;
import com.libraray.interFace.Login;

import java.util.List;

/*
    *This class is responsible to validate the username and password
    * It will fetch the database it will check whether username already exists, and it will also check whether
    * the password is secured
 */
public class LoginDataManager implements Login {

    private final InsertionData persist = new InsertionData();
    private final User user;
    private final String userName;

    private final String passWord;

    public LoginDataManager(User user){
        this.user = user;
        this.userName = user.getUserName();
        this.passWord = user.getPassword();
    }

    //getter for user object
    public User getUser() {
        return user;
    }

    //Method which will take care of checking the dat is consistent
    public boolean checkUser() throws LibraryException {
        try{
            if(checkLength(userName,10) || checkUserExist())
                throw new LibraryException("Provided does not satisfy  our criteria.. You failed to provide It");
            return true;
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }


    //checks the length and given string length is greater than or equal  to
    private boolean checkLength(String string,int length) throws Exception{
        return string.length() < length;
    }


    //Method checks whether user exists already
    private boolean checkUserExist()  throws Exception{
        InsertionData persist = new InsertionData();
        String query = "from User where userName = '"+userName+"'";
        System.out.println(query);

        List<User> user = persist.<User>getDataHQL(query, User.class);
        return !user.isEmpty();
    }

    //method responsible to handle the password operation
    public boolean checkPassword() throws LibraryException{
        try{
            if(checkLength(passWord,8) || checkCharacters())
                throw new LibraryException("Password is too weak ...");
            return true;
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }


    private boolean checkCharacters(){
        int capsAlpha = 0;
        int smallAlpha = 0;
        int numerics =  0;
        int specialCharacter = 0;

        for(char character : passWord.toCharArray()){
            if(character == ' ')
                return true;
            if(character >= 'a' && character <= 'z')
                smallAlpha++;
            else if(character >= 'A' && character <= 'Z')
                capsAlpha++;
            else if(character >= '0' && character <= '9')
                numerics++;
            else
                specialCharacter++;
        }

       if(capsAlpha >= 1 && smallAlpha >= 1 && numerics >= 1 && specialCharacter >= 1)
           return false;
       return true;

    }
}
