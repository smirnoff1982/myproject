package com.klb.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michał Makaruk on 25.06.2017.
 */

@Entity
@Table(name = "rents")
public class Rent extends BaseEntity{

    @Column(name="created_date", nullable = false)
    private Date createdDate;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Rent() {
    }

    public Rent(User user, Book book) {
        this.user = user;
        this.book = book;

        createdDate = new Date();
        status = Status.IN_PROGRESS;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
