package com.libraray.entity;

import org.hibernate.metamodel.model.domain.internal.MapMember;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompositeBookAuthor implements Serializable {
    @ManyToOne
    private Book bookDistributed;
    @ManyToOne
    private Members bookMember;

    public Book getBookDistributed() {
        return bookDistributed;
    }

    public void setBookDistributed(Book bookDistributed) {
        this.bookDistributed = bookDistributed;
    }

    public Members getBookMember() {
        return bookMember;
    }

    public void setBookMember(Members bookMember) {
        this.bookMember = bookMember;
    }
}
