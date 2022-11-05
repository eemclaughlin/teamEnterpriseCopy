package org.enterprise.service;

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
}
