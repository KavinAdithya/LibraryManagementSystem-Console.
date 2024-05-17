package com.libraray.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer_details")
public class Borrower {
    @Id
    @Column(name = "Borrower_ID")
    private int borrowerId;

    @Column(name = "Borrower_name")
    private String nameOfBorrower;

    @Column(name = "age_of_borrower")
    private int ageOfBorrower;

    @Column(name = "adhaar_Number")
    private String adhaarNumber;

    @Column(name = "address_of_borrower")
    private String addressOfBorrower;



    //Borrower Id
    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }


    //Name of the Borrower
    public String getNameOfBorrower() {
        return nameOfBorrower;
    }

    public void setNameOfBorrower(String nameOfBorrower) {
        this.nameOfBorrower = nameOfBorrower;
    }

    //age of the borrower
    public int getAgeOfBorrower() {
        return ageOfBorrower;
    }

    public void setAgeOfBorrower(int ageOfBorrower) {
        this.ageOfBorrower = ageOfBorrower;
    }

    //Adhaar number of borrower

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    //Address of Borrower
    public String getAddressOfBorrower() {
        return addressOfBorrower;
    }

    public void setAddressOfBorrower(String addressOfBorrower) {
        this.addressOfBorrower = addressOfBorrower;
    }


    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerId=" + borrowerId +
                ", nameOfBorrower='" + nameOfBorrower + '\'' +
                ", ageOfBorrower=" + ageOfBorrower +
                ", adhaarNumber='" + adhaarNumber + '\'' +
                ", addressOfBorrower='" + addressOfBorrower + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrower borrower)) return false;
        return getBorrowerId() == borrower.getBorrowerId() && getAgeOfBorrower() == borrower.getAgeOfBorrower() && Objects.equals(getNameOfBorrower(), borrower.getNameOfBorrower()) && Objects.equals(getAdhaarNumber(), borrower.getAdhaarNumber()) && Objects.equals(getAddressOfBorrower(), borrower.getAddressOfBorrower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBorrowerId(), getNameOfBorrower(), getAgeOfBorrower(), getAdhaarNumber(), getAddressOfBorrower());
    }
}
