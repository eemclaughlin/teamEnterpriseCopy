package org.enterprise.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Users books.
 */
@Entity(name = "UsersBooks")
@Table(name = "users_books")
public class UsersBooks {
    @Id
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @Id

    private Book book;

    /**
     * Instantiates a new Users books.
     */
    public UsersBooks() {}

    /**
     * Instantiates a new Users books.
     *
     * @param usersId the users id
     * @param booksId the books id
     */
    public UsersBooks(int usersId, int booksId) {
        this.usersId = usersId;
        this.booksId = booksId;
    }

    /**
     * Gets users id.
     *
     * @return the users id
     */
    public int getUsersId() {
        return usersId;
    }

    /**
     * Sets users id.
     *
     * @param usersId the users id
     */
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    /**
     * Gets books id.
     *
     * @return the books id
     */
    public int getBooksId() {
        return booksId;
    }

    /**
     * Sets books id.
     *
     * @param booksId the books id
     */
    public void setBooksId(int booksId) {
        this.booksId = booksId;
    }

    @Override
    public String toString() {
        return "UsersBooks{" +
                "usersId=" + usersId +
                ", booksId=" + booksId +
                '}';
    }
}
