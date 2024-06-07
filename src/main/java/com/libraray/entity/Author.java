package com.libraray.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import org.hibernate.annotations.Cache;

@Entity
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "Authors")
public class Author{
    @Column(name = "author_name")
    private String authorName;

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "Number_Of_Books")
    private int countOfBook;

    @Column(name = "author_age")
    private int ageOfAuthor;

    @Column(name = "country_name")
    private String countryName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login")
    private User passWord;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;
    //Default Constructor
    public Author(){
        super();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
                ", passWord=" + passWord +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return  getAgeOfAuthor() == author.getAgeOfAuthor() &&
                Objects.equals(getAuthorName(), author.getAuthorName()) &&
                Objects.equals(getCountryName(), author.getCountryName());
    }
}