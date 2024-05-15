package com.libraray.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="login_Data")
public class UserPassWord {
    @Id
    @Column(name="user_Id")
    private int userId;
    @Column(name="user_Name")
    private String userName;

    @Column(name="pass_Word")
    private String passWord;


    @OneToOne
    private Author author;

    //user name
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //passWord
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //Id

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPassWord that)) return false;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassWord(), that.getPassWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassWord());
    }

    @Override
    public String toString() {
        return "UserPassWord{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}