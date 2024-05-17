package com.libraray.entity;



import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Authors")
public class Author{
    @Column(name="author_name")
    private String authorName;

    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name="Number_Of_Books")
    private int countOfBook;

    @Column(name="author_age")
    private int ageOfAuthor;

    @Column(name="country_name")
    private String countryName;

    @OneToOne
    @JoinColumn(name="login")
    private User passWord;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
    //Default Constructor
    public Author(){
        super();
    }

    //parameterized constructor
    public Author(String authorName, int authorId, int countOfBook, int ageOfAuthor, String countryName) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.countOfBook = countOfBook;
        this.ageOfAuthor = ageOfAuthor;
        this.countryName = countryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //incrementing the book published count by 1
    public void incrementBooksCount(){
        countOfBook++;
    }
    //Author Name
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    //Author ID
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    //Number Books published by the author
    public int getCountOfBook() {
        return countOfBook;
    }

    public void setCountOfBook(int countOfBook) {
        this.countOfBook = countOfBook;
    }

    //Age Of the Author
    public int getAgeOfAuthor() {
        return ageOfAuthor;
    }

    public void setAgeOfAuthor(int ageOfAuthor) {
        this.ageOfAuthor = ageOfAuthor;
    }

    //Author native country
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    //userName and passWord
    public User getPassWord() {
        return passWord;
    }

    public void setPassWord(User passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", countOfBook=" + countOfBook +
                ", ageOfAuthor=" + ageOfAuthor +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return getAuthorId() == author.getAuthorId() && getCountOfBook() == author.getCountOfBook() && getAgeOfAuthor() == author.getAgeOfAuthor() && Objects.equals(getAuthorName(), author.getAuthorName()) && Objects.equals(getCountryName(), author.getCountryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorName(), getAuthorId(), getCountOfBook(), getAgeOfAuthor(), getCountryName());
    }
}
