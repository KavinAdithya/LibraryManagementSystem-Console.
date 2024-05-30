package com.libraray.EntityVerifier;

import com.libraray.ApplicationCRUD.InsertionData;
import com.libraray.entity.Members;
import com.libraray.entity.User;
import com.libraray.interFace.ObjectCreationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MembersDataTest {
    User user = new User();

    Members members = new Members();

    InsertionData persist = new InsertionData();

    @BeforeAll
     void aadhaarVerifier()  {

        user.setUserName("Kavin_Adithya123");
        user.setPassword("KavinDharani@3");
        user.setSecurityId(2);
        members.setMemberId(10);
        members.setFinePaid(0.0);
        members.setAadhaarNumber("350393356481");
        members.setNameOfMember("Kavin");
        members.setAddressOfMember("USA");
        members.setAgeOfMember(20);
        members.setTotalFineAllowed(0.00);
        members.setUser(user);
       //assertTrue(persist.insertData(members));
//        try {
//            MembersData membersData = new MembersData(members);
//            assertTrue(membersData.aadhaarVerifier());
//            System.out.println(members.getAadhaarNumber());
//        } catch (ObjectCreationException e) {
//            throw new RuntimeException(e);
//        }


    }

    @Test
    void amountManager() {
        try {
            members.setFinePaid(500.00);
            members.setTotalFineAllowed(2500.00);
            MembersData membersData = new MembersData(members);
            ///membersData.manageMemberData();
            assertTrue(membersData.amountManager());
        } catch (ObjectCreationException e) {
            throw new RuntimeException(e);
        }
    }
}