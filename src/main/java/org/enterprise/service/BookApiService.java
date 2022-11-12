package org.enterprise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.enterprise.entity.Books;
import org.enterprise.entity.User;
import org.enterprise.persistence.GenericDao;
import org.enterprise.util.DaoFactory;

import javax.ws.rs.QueryParam;
import java.awt.print.Book;
import java.util.List;

/**
 * Class to take requests from the REST API and perform actions based on the request.
 */
public class BookApiService {

    // Create a logger for this class.
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Method to create a new book given and ISBN.
     * Calls on the Google Books API to get all the information about the book.
     * CREATE.r.u.d
     *
     * @param isbn the title of the book to get.
     * @return the book with the given title.
     */
    public void createBookFromIsbn(String isbn) { // TODO: Update to return a book object.
        // TODO integrate with database using GenericDao to create a new book.
        // Create a new book object.
        Book book = new Book();

        // Create a new bookDao.

        // Return the new book.
    }

    /**
     * Create a new book manually with the given parameters entered at the REST API
     * CREATE.r.u.d
     */
    public void createBookManually(/* Book object */) {
        // TODO: Update to return a book object.
        // TODO integrate with database using GenericDao to create a new book.
        // Create a new book object.
        Book book = new Book();

        // Create a new bookDao.

        // Return the new book.
    }

    /**
     * Method to get all books from the database.
     * c.READ.u.d
     *
     * @return a list of all books.
     */
    public String getAllBooks() {

        GenericDao<Books> dao = DaoFactory.createDao(Books.class);
        List<Books> books = dao.getAll();
        logger.debug("Sending back ALL books..." + books);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(books);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Method to get a book by its id.
     * c.READ.u.d
     *
     * @param bookId the id of the book to get.
     * @return the book with the given id.
     */
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

    /**
     * Method to get the current reader/user of a given book
     * c.READ.u.d
     *
     * @param bookId the title of the book to get.
     * @return the book with the given title.
     */
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

    /**
     * Method to update a book with given info from the REST API.
     * c.r.UPDATE.d
     *
     *
     * @return the book with the given id.
     */
    public void updateBook(/* Book object */) {
        // TODO integrate with database using GenericDao to update a book.
        // Create a new book object.
        // Book book = new Book();

        // Update book in the database.

        // Return the updated book.
    }

    /**
     * Method to delete a book by its id.
     * c.r.u.DELETE
     *
     * @param bookId the id of the book to update.
     * @return the book with the given id.
     */
    public String deleteBook(Integer bookId) {
        // TODO integrate with database using GenericDao to delete a book.

        boolean success = false;

        GenericDao<Books> bookDao = new GenericDao(Books.class);
        Books bookToDelete = bookDao.getById(bookId);

        if (bookToDelete != null) {
            bookDao.delete(bookToDelete);
            success = true;
        }

        logger.debug("Was book deleted: " + success);

        if (success) {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(bookToDelete);
                logger.debug("ResultingJSONstring = " + json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
        } else {
            return "There was an error deleting the book.";
        }
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

    /**
     * Service Method to Remove all non-numeric characters from a string.
     * @return A string with only numeric characters.
     */
    private String removeAlphaCharacters(String isbn) {
        // Remove dashes from ISBN number.

        return isbn;
    }
}
