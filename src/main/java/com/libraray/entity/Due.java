package com.libraray.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Book_Distribution")
public class Due {


    @EmbeddedId
    private CompositeBookAuthor compositeBookAuthor;

    @Column(name="Date_Of_Distribution")
    @Temporal(TemporalType.DATE)
    private Date dateDistributed;

    @Column(name="Due_Date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name="returned_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name="fine_generated")
    private double fineAmount;


    //Book Distributed date
    public Date getDateDistributed() {
        return dateDistributed;
    }

    public void setDateDistributed(Date dateDistributed) {
        this.dateDistributed = dateDistributed;
    }

    //due date to return the book
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    //returned date of book by the borrower
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    //If the borrower late submission and so fine amount generated

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    //Composite Key
    public CompositeBookAuthor getCompositeBookAuthor() {
        return compositeBookAuthor;
    }


    public void setCompositeBookAuthor(CompositeBookAuthor compositeBookAuthor) {
        this.compositeBookAuthor = compositeBookAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Due due)) return false;
        return Double.compare(getFineAmount(), due.getFineAmount()) == 0 && Objects.equals(getCompositeBookAuthor(), due.getCompositeBookAuthor()) && Objects.equals(getDateDistributed(), due.getDateDistributed()) && Objects.equals(getDueDate(), due.getDueDate()) && Objects.equals(getReturnDate(), due.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompositeBookAuthor(), getDateDistributed(), getDueDate(), getReturnDate(), getFineAmount());
    }

    @Override
    public String toString() {
        return "Due{" +
                "compositeBookAuthor=" + compositeBookAuthor +
                ", dateDistributed=" + dateDistributed +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
