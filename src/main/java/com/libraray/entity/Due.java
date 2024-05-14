package com.libraray.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="Book_Distribution")
public class Due {


    @EmbeddedId
    private CompositeBookAuthor compositeBookAuthor;

    @Column(name="Date_Of_Distribution")
    private LocalDate dateDistributed;

    @Column(name="Due_Date")
    private LocalDate dueDate;

    @Column(name="returned_date")
    private LocalDate returnDate;

    @Column(name="fine_generated")
    private double fineAmount;


    //Book Distributed date
    public LocalDate getDateDistributed() {
        return dateDistributed;
    }

    public void setDateDistributed(LocalDate dateDistributed) {
        this.dateDistributed = dateDistributed;
    }

    //due date to return the book
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //returned date of book by the borrower
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
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
