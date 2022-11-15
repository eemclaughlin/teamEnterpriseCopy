package org.enterprise.service;

import org.enterprise.entity.Books;
import org.enterprise.entity.User;
import org.enterprise.googlebooksapi.ItemsItem;
import org.enterprise.persistence.BookApiDao;
import org.enterprise.persistence.GenericDao;
import org.enterprise.util.DaoFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
<<<<<<< Updated upstream
import org.enterprise.entity.Books;
import org.enterprise.entity.User;
import org.enterprise.entity.UsersBooks;
import org.enterprise.googlebooksapi.ItemsItem;
import org.enterprise.persistence.BookApiDao;
import org.enterprise.persistence.GenericDao;
import org.enterprise.util.DaoFactory;

import javax.ws.rs.QueryParam;
import java.awt.print.Book;
=======
>>>>>>> Stashed changes
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
    public String createBookFromIsbn(String isbn) {
        logger.debug("ISBN with dashes: " + isbn);

        // Remove the dashes from the ISBN.
        isbn = removeDashes(isbn);

        logger.debug("ISBN without dashes: " + isbn);

        // Instantiate a new dao to get a book data response.
        BookApiDao dao = new BookApiDao();

        // Setup a bunch onf empty variables.
        String title = null;
        String author = null;
        String publisher = null;
        String publishedDate = null;
        String description = null;
        String isbnTen = null;
        String isbnThirteen = null;
        int pageCount = 0;
        String language = null;
        String smallImageLink = null;
        String mediumImageLink = null;

        // Get book data from Google Books API using the ISBN and populate into
        // the variables.
        for (ItemsItem item : dao.getResponseInfo(isbn).getItems()) {
<<<<<<< Updated upstream

            isbnTen = null;
            isbnThirteen = null;
=======
>>>>>>> Stashed changes
            title = item.getVolumeInfo().getTitle();
            description = item.getVolumeInfo().getDescription();
            publisher = item.getVolumeInfo().getPublisher();
            publishedDate = item.getVolumeInfo().getPublishedDate() + "-01";
            pageCount = item.getVolumeInfo().getPageCount();
            language = item.getVolumeInfo().getLanguage();
            smallImageLink = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
            mediumImageLink = item.getVolumeInfo().getImageLinks().getThumbnail();

            // For each author in array at second half of "for"...
            for(String arrayAuthor : item.getVolumeInfo().getAuthors()) {
                //author = item.getVolumeInfo().getAuthors().toString();
                author = arrayAuthor;
            }
        }

        Books newBook = new Books(isbnTen, isbnThirteen, title, author,
                description, publisher, publishedDate, pageCount, language,
                smallImageLink, mediumImageLink);
        GenericDao bookDao = new GenericDao(Books.class);

        bookDao.insert(newBook);

        // Return the new user as a string.
        String bookInfo = newBook.toString();

        logger.debug("Sending back new user info ..." + bookInfo);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(bookInfo);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Create a new book manually with the given parameters entered at the REST API
     * CREATE.r.u.d
     */
    public String createBookManually(String isbnTen, String isbnThirteen,
            String title, String author, String publisher, String publishedDate,
            String description, int pageCount, String language) {
        // Create a new book object and populate it with the given parameters.
        Books newBook = new Books(isbnTen, isbnThirteen, title, author,
                description, publisher, publishedDate, pageCount, language,
                null, null);
        GenericDao bookDao = new GenericDao(Books.class);

        bookDao.insert(newBook);

        // Return the new book as a string.
        String bookInfo = newBook.toString();

        logger.debug("Sending back new user info ..." + bookInfo);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(bookInfo);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Method to get all books from the database.
     * c.READ.u.d
     *
     * @return a list of all books.
     */
    public String getAllBooks() {
<<<<<<< Updated upstream

=======
        // Create a new dao to get a book data response.
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
        // Create a new dao to get a book data response.
>>>>>>> Stashed changes
        GenericDao<Books> dao = DaoFactory.createDao(Books.class);
        Books book = (Books) dao.getById(bookId);

        logger.debug("Sending back book with id: " + bookId + "..." + book);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(book);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Method to get the current reader/user of a given book
     * c.READ.u.d
     *
     * @param bookId the title of the book to get.
     * @return the book with the given title.
     */
    public String getSpecificBooksReader (int bookId) {

        GenericDao bookDao = new GenericDao(Books.class);
        GenericDao usersBooksDao = new GenericDao(UsersBooks.class);

        Books book = (Books) bookDao.getById(bookId);

        List<User> specificBooksReader = usersBooksDao.getByPropertyEqual("book", book);

        logger.debug("Sending specific Books reader: " + specificBooksReader);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(book);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Method to update a book with given info from the REST API.
     * c.r.UPDATE.d
     *
     *
     * @return the book with the given id.
     */
<<<<<<< Updated upstream
    public String updateBook(int bookId, String isbnTen, String isbnThirteen, String title, String author, String publisher, String publishedDate, String description, int pageCount, String language) {

=======
    public String updateBook(int bookId, String isbnTen, String isbnThirteen,
            String title, String author, String publisher, String publishedDate,
            String description, int pageCount, String language) {
>>>>>>> Stashed changes
        // Creat the new bookDao.
        GenericDao<Books> bookDao = new GenericDao(Books.class);

        // Get the book object by given bookId.
        Books book = (Books) bookDao.getById(bookId);

        // Set the new values for the book.
        if (isbnTen != null) {
            book.setIsbnTen(isbnTen);
        }
        if (isbnThirteen != null) {
            book.setIsbnThirteen(isbnThirteen);
        }
        if (title != null) {
            book.setTitle(title);
        }
        if (author != null) {
            book.setAuthor(author);
        }
        if (publisher != null) {
            book.setPublisher(publisher);
        }
        if (publishedDate != null) {
            book.setPublishedDate(publishedDate);
        }
        if (description != null) {
            book.setDescription(description);
        }
        if (pageCount != 0) {
            book.setPageCount(pageCount);
        }
        if (language != null) {
            book.setLanguage(language);
        }

        // Update the book.
        bookDao.saveOrUpdate(book);

        // Return the updated book as a string.
        String bookInfo = bookDao.getById(bookId).toString();

        logger.debug("Sending back updated book info ..." + bookInfo);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(bookInfo);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Method to delete a book by its id.
     * c.r.u.DELETE
     *
     * @param bookId the id of the book to update.
     * @return the book with the given id.
     */
    public String deleteBook(Integer bookId) {
<<<<<<< Updated upstream
        // TODO integrate with database using GenericDao to delete a book.

=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    public boolean checkOutBook(int bookId, int userId) {
        // TODO integrate with database using GenericDao to check out a book.
        boolean success = false;

        // Should fail if the book is currently checked out.
=======
    public String checkOutBook(int userId, int bookId) {
        logger.debug("User id: " + userId);
        logger.debug("Book id: " + bookId);
>>>>>>> Stashed changes

        // Check out book from the database.

<<<<<<< Updated upstream
        // Return if the check out was successful.
        return success;
=======
        // Get the book and user.
        User user = userDao.getById(userId);
        Books book = bookDao.getById(bookId);

        logger.debug("User: " + user);
        logger.debug("Book: " + book);

        // Check out the book to the user by adding the user to the book.
        book.setUser(user);

        // Set the book to checked out.
        bookDao.saveOrUpdate(book);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(book);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            logger.error("JSON Processing Exception: " + e);
        }

        return json;
>>>>>>> Stashed changes
    }

    /**
     * Check in a book
     * @param bookId
     * @param userId
     * @return Success or failure of the check in.
     */
<<<<<<< Updated upstream
    public boolean checkInBook(int bookId, int userId) {
        // TODO integrate with database using GenericDao to check in a book.
        boolean success = false;

        // Should fail if the book is not currently checked out.
=======
    public String checkInBook(int bookId) {
        // Create a new dao.
        GenericDao<Books> bookDao = new GenericDao(Books.class);
>>>>>>> Stashed changes

        // Check in book from the database.

<<<<<<< Updated upstream
        // Return if the check in was successful.
        return success;
=======
        // Check in the book by removing the user from the book.
        book.setUser(null);

        // Set the book to checked in.
        bookDao.saveOrUpdate(book);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(book);
            logger.debug("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            logger.error("JSON Processing Exception: " + e);
        }

        return json;
>>>>>>> Stashed changes
    }

    /**
     * Service Method to Remove all non-numeric characters from a string.
     * @return A string with only numeric characters.
     */
    private String removeDashes(String isbn) {
        // Remove dashes from ISBN number.
        isbn = isbn.replaceAll("-", "");

        return isbn;
    }
}
