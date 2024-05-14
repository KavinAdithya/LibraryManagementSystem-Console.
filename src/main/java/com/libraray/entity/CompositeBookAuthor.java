package com.libraray.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompositeBookAuthor implements Serializable {
    @ManyToOne
    private Book bookDistributed;
    @ManyToOne
    private Borrower bookBorrower;

    public Book getBookDistributed() {
        return bookDistributed;
    }

    public void setBookDistributed(Book bookDistributed) {
        this.bookDistributed = bookDistributed;
    }

    public Borrower getBookBorrower() {
        return bookBorrower;
    }

    public void setBookBorrower(Borrower bookBorrower) {
        this.bookBorrower = bookBorrower;
    }
}
