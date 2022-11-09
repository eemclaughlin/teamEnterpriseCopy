package org.enterprise.service;

import org.enterprise.entities.User;
import org.enterprise.persistence.GenericDao;

import javax.ws.rs.QueryParam;
import java.awt.print.Book;

/**
 * Class to take requests from the restful api and perform actions based on the request.
 */
public class BookApiService {
    public String getAllBooks() {
        // TODO integrate with database using GenericDao to retrieve users and output.
        // Generate some test users for testing.
        String testBook1 = "BookOne ";
        String testBook2 = "BookTwo ";
        String testBook3 = "BookThree ";
        String testBook4 = "BookFour ";
        String testString = testBook1 + testBook2 + testBook3 + testBook4;

        return testString;
    }

    public String getSpecificBook(int bookId) {

        // TODO integrate with database using GenericDao and retrieve user by an Id
        //GenericDao userDao = new GenericDao(User.class);
        //String specificUser = userDao.getById(Integer.parseInt(userId)).toString();

        // Create a null test user.
        String testBook = null;

        // Check given bookId for a test return statement.
        if (bookId == 1) {
            testBook = "BookOne ";
        } else if (bookId == 2) {
            testBook = "BookTwo ";
        } else if (bookId == 3) {
            testBook = "BookThree ";
        } else if (bookId == 4) {
            testBook = "Book4 ";
        }

        return testBook;
    }

    public String getSpecificBooksReader (int bookId) {

        // Instantiate both the order and user daos.
        //GenericDao userDao = new GenericDao(User.class);
        //GenericDao bookDao = new GenericDao(Order.class);

        // Get the user object by the given id.
        // User user = (User)userDao.getById(Integer.parseInt(userId));

        // Use the user object to find order for just that user.
        // String specificUsersRoles = orderDao.getByPropertyEqual("user", user).toString();

        // Create a test peer and a test book
        String testBook = null;
        String reader = "Johnny";

        // Give a book based on id given
        if (bookId == 1) {
            testBook = "BookOne ";
        } else if (bookId == 2) {
            testBook = "BookTwo ";
        } else if (bookId == 3) {
            testBook = "BookThree ";
        } else if (bookId == 4) {
            testBook = "Book4 ";
        }

        // Combine test peer with test book.
        String finalString = testBook + " is being read by " + reader;

        return finalString;
    }



    public void createBookFromIsbn(String isbn) { // TODO: Update to return a book object.
        // TODO integrate with database using GenericDao to create a new book.
        // Create a new book object.
        Book book = new Book();

        // Create a new bookDao.

        // Return the new book.
    }

    /**
     * Create a new book manually
     */
    public void createBookManually(/* Book object */) {
        // TODO: Update to return a book object.
        // TODO integrate with database using GenericDao to create a new book.
        // Create a new book object.
        Book book = new Book();

        // Create a new bookDao.

        // Return the new book.
    }

    public boolean deleteBook(int bookId) {
        // TODO integrate with database using GenericDao to delete a book.

        boolean success = false;


        // Delete book from the database.

        // Return if the delete was successful.
        return success;
    }

    /**
     * Check out a book
     * @param bookId
     * @param userId
     * @return Success or failure of the checkout.
     */
    public boolean checkOutBook(int bookId, int userId) {
        // TODO integrate with database using GenericDao to check out a book.
        boolean success = false;

        // Should fail if the book is currently checked out.

        // Check out book from the database.

        // Return if the check out was successful.
        return success;
    }

    /**
     * Check in a book
     * @param bookId
     * @param userId
     * @return Success or failure of the check in.
     */
    public boolean checkInBook(int bookId, int userId) {
        // TODO integrate with database using GenericDao to check in a book.
        boolean success = false;

        // Should fail if the book is not currently checked out.

        // Check in book from the database.

        // Return if the check in was successful.
        return success;
    }


    public void updateBook(/* Book object */) {
        // TODO integrate with database using GenericDao to update a book.
        // Create a new book object.
        // Book book = new Book();

        // Update book in the database.

        // Return the updated book.
    }

    /**
     * Remoce all non-numeric characters from a string.
     * @return A string with only numeric characters.
     */
    private String removeAlphaCharacters(String isbn) {
        // Remove dashes from ISBN number.

        return isbn;
    }

}
