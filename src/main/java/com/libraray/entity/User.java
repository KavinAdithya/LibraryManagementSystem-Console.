package com.libraray.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Security")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_Security")
    private int securityId;

    @Column(name = "name_unique")
    private String userName;

    @Column(name="pass_word")
    private String password;


    //Unique Securiry ID
    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }


    //username
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    //passWord
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "securityId=" + securityId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}