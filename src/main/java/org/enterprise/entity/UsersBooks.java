package org.enterprise.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Users books.
 */
@Entity(name = "UsersBooks")
@Table(name = "users_books")
public class UsersBooks implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_id", referencedColumnName = "id")

    private Books book;

    /**
     * Instantiates a new Users books.
     */
    public UsersBooks() {}

    /**
     * Instantiates a new Users books.
     *
     * @param user the user
     * @param book the book
     */
    public UsersBooks(User user, Books book) {
        this.user = user;
        this.book = book;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public Books getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(Books book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "UsersBooks{" +
                "user=" + user +
                ", book=" + book +
                '}';
    }
}