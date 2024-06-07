package com.libraray.entity;

//Annotations
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/*
    *It is a book entity which is responsible to store book details
    * Here We use POJO's ->plain old java object
    * Using hibernate we are mapping our object into database
    * We are Annotate the entity based on JPA due to portability
 */

@Entity
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "Book_ID")
    private int Id;

    @Column(name = "Book_Name")
    private String name;

    @ManyToOne
    private Author author;

    @Column(name = "Book_Edition")
    private String edition;

    @Column(name = "Book_launched")
    private LocalDate launchDate;
    @Column(name = "Book_status")
    private int availabilityNumber;

    @Column(name = "fine_amount")
    private double profit;

    @Column(name = "cost_of_book")
    private double costOfBook;

    //total amount generated
    public double getAmount() {
        return profit;
    }

    public void setAmount(double profit) {
        this.profit = profit;
    }

    //Book_Id
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    //Book_Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Author_name
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    //Book_Edition
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    //Launched date of particular BOOk
    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    //Book_Status
    public int getAvailabilityNumber() {
        return availabilityNumber;
    }

    public void setAvailabilityNumber(int availabilityNumber) {
        this.availabilityNumber = availabilityNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", edition='" + edition + '\'' +
                ", launchDate=" + launchDate +
                ", availabilityNumber=" + availabilityNumber +
                ", fineAmount=" + profit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return  Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getEdition(), book.getEdition());
    }

}