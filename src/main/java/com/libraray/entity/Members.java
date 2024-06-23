package com.libraray.entity;

import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "customer_details")
public class Members {
    @Id
    @Column(name = "MemberID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(name = "MemberName")
    private String nameOfMember;

    @Column(name = "AgeOfBorrower")
    private int ageOfMember;

    @Column(name = "AadhaarNumber")
    private String aadhaarNumber;

    @Column(name = "AddressOfMember")
    private String addressOfMember;

    @JoinColumn(name = "Login")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "FineAllowed")
    private double totalFineAllowed = 0.0;

    @Column(name = "FinePaid")
    private double finePaid = 0.0;


    //totalFine generated
    public double getTotalFineAllowed() {
        return totalFineAllowed;
    }

    public void setTotalFineAllowed(double totalFineAllowed) {
        this.totalFineAllowed = totalFineAllowed;
    }

    //fine paid
    public double getFinePaid() {
        return finePaid;
    }

    public void setFinePaid(double finePaid) {
        this.finePaid = finePaid;
    }

    //Member id
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    //Name of the member
    public String getNameOfMember() {
        return nameOfMember;
    }

    public void setNameOfMember(String nameOfMember) {
        this.nameOfMember = nameOfMember;
    }

    //Age of the member
    public int getAgeOfMember() {
        return ageOfMember;
    }

    public void setAgeOfMember(int ageOfMember) {
        this.ageOfMember = ageOfMember;
    }

    //Aadhaar Number of Member
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    //Address of member
    public String getAddressOfMember() {
        return addressOfMember;
    }

    public void setAddressOfMember(String addressOfMember) {
        this.addressOfMember = addressOfMember;
    }

    //user id of the member
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId = " + memberId +
                ", nameOfMember = '" + nameOfMember + '\'' +
                ", ageOfMember = " + ageOfMember +
                ", aadhaarNumber = '" + aadhaarNumber + '\'' +
                ", addressOfMember = '" + addressOfMember + '\'' +
                ", user = " + user +
                ", totalFineAllowed = " + totalFineAllowed +
                ", finePaid = " + finePaid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Members members)) return false;
        return getMemberId() == members.getMemberId() && getAgeOfMember() == members.getAgeOfMember() && Double.compare(getTotalFineAllowed(), members.getTotalFineAllowed()) == 0 && Double.compare(getFinePaid(), members.getFinePaid()) == 0 && Objects.equals(getNameOfMember(), members.getNameOfMember()) && Objects.equals(getAadhaarNumber(), members.getAadhaarNumber()) && Objects.equals(getAddressOfMember(), members.getAddressOfMember()) && Objects.equals(getUser(), members.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId(), getNameOfMember(), getAgeOfMember(), getAadhaarNumber(), getAddressOfMember(), getUser(), getTotalFineAllowed(), getFinePaid());
    }
}