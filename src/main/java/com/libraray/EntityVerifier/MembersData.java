package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Members;
import com.libraray.interFace.LibraryException;
import com.libraray.interFace.MembersVerifier;
import com.libraray.interFace.ObjectCreationException;
import com.libraray.interFace.Validate;

import java.util.List;


//This class acts  as interface between the interface and database  to persist the members data into database
public class MembersData implements MembersVerifier {

    private final Members members ;

    private final Validate validate;
    private final InsertionData persist = new InsertionData();

    //Parameterized Constructor
    MembersData(Members members) throws ObjectCreationException {
        if(!isFilledData(members)){
            this.members = null;
            throw new ObjectCreationException("Failed to instantiate it .. due to in consistent Members data..");
        }
        this.members = members;
        this.validate = new Validates(members.getUser());
    }


    //Driver to manage the members data
    public boolean manageMemberData() throws LibraryException {

        validate.nameValidate(members.getNameOfMember());
        validate.ageInvoker(members.getAgeOfMember());
        validate.checkUser();
        validate.checkPassword();

        return aadhaarVerifier() && !checkEntityExists();
    }

    //Checking the Object Already Exists ... Checking based ob object name and aadhaar name
    private boolean checkEntityExists(){
        String query = "from Members where nameOfMember = '" + members.getNameOfMember() + "' and aadhaarNumber = '" + members.getAadhaarNumber() + "'";

        List<Members> members1 = persist.getDataHQL(query, Members.class);

        return members1.isEmpty();
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

        if( ! (members.getAadhaarNumber().length() <= 14 && members.getAadhaarNumber().length() >= 12))
            return false;

        for(char character : members.getAadhaarNumber().toCharArray()){
            int number = character - '0';
            //System.out.println(number);
            if(!(number >= 0 && number <= 9))
                return false;
            if(k == 4 || k == 8)
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
        String query = "from Members where nameOfMember = '" + members.getNameOfMember() + "' and aadhaarNumber = '" + members.getAadhaarNumber() + "'";

        List<Members> members1 = persist.getDataHQL(query, Members.class);

        if(members1.isEmpty())
            return false;

        Members member = members1.get(0);

        member.setTotalFineAllowed(member.getTotalFineAllowed() + this.members.getTotalFineAllowed());
        member.setFinePaid(member.getFinePaid() + this.members.getFinePaid());

        return persist.updateData(members);

    }
}
