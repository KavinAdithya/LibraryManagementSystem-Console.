package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Book;
import com.libraray.entity.Members;
import com.libraray.interFace.MembersVerifier;

import java.util.List;


//This class acts  as interface between the interface and database  to persist the members data into database
public class MembersData implements MembersVerifier {

    private final Members members ;

    private final InsertionData persist = new InsertionData();

    //Parameterized Constructor
    MembersData(Members members) throws ObjectCreationException{
        if(!isFilledData(members)){
            members = null;
            throw new ObjectCreationException("Failed to instantiate it .. due to in consistent Members data..");
        }
        this.members = members;
    }

    //Checking the object data is consistent
    private boolean isFilledData(Members members) {
        return members.getAgeOfMember() != 0 &&
                members.getAddressOfMember() != null &&
                members.getNameOfMember() != null &&
                members.getUser() != null;
    }

    //Checking the data is valid  and converting its own shape of data if it's valid data
    @Override
    public boolean aadhaarVerifier() {
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;;

        if( ! (members.getAadhaarNumber().length() >= 14 && members.getAadhaarNumber().length() >= 12))
            return false;

        for(char character : members.getAadhaarNumber().toCharArray()){
            int number = character - '0';

            if(!(number >= 0 && number <= 9))
                return false;
            if(k == 3 || k == 7)
                stringBuilder.append(' ');

            stringBuilder.append(character);
            k++;
        }
        members.setAadhaarNumber(stringBuilder.toString());
        return true;
    }

    //Amount Manager provides the feature of updating the total amount paid amount and pending payments
    @Override
    public boolean amountManager() {
        List<Book> book = persist.getDataHQL("from Book where name = '"
                + members.getNameOfMember() + "' AND aadhaarNumber = '" + members.getAadhaarNumber() +
                "'", Book.class);
        if(book == null)
            return false;

        members.setTotalFineAllowed(members.getTotalFineAllowed() + this.members.getTotalFineAllowed());
        members.setFinePaid(members.getFinePaid() + this.members.getFinePaid());

        return persist.updateData(members);

    }
}
