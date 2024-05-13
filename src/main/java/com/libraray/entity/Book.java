package com.libraray.entity;

//Annotations
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
@Table(name="Books")
public class Book {

    @Id
    @Column(name="Book_ID")
    private int Id;

    @Column(name="Book_Name")
    private String name;

    @Column(name="Author_Name")
    @ManyToOne
    private Author author;

    @Column(name="Book_Edition")
    private String edition;

    @Column(name="Book_launched")
    private LocalDate launchDate;
    @Column(name="Book_status")
    private int availabilityNumber;


    //Parameterized Constructor used to initialize the instance states
    public Book(int id, String name, Author author, String edition, LocalDate launchDate, int availabilityNumber) {
        Id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.launchDate = launchDate;
        this.availabilityNumber = availabilityNumber;
    }


    //Default Constructor which is used by Hibernate while we retriving data from database
    // hibernate use the default constructor to create object and it will insert the data using POJO's
    public Book(){
        super();
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && getAvailabilityNumber() == book.getAvailabilityNumber() && Objects.equals(getName(), book.getName()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getEdition(), book.getEdition()) && Objects.equals(getLaunchDate(), book.getLaunchDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getEdition(), getLaunchDate(), getAvailabilityNumber());
    }
}
