package org.enterprise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.enterprise.entity.Books;
import org.enterprise.entity.User;
import org.enterprise.entity.UsersBooks;
import org.enterprise.persistence.GenericDao;
import org.enterprise.util.DaoFactory;

import java.util.List;

/**
 * Class to take requests from the REST API and perform actions based on the request.
 */
public class ReaderApiService {

    // Create a logger for this class.
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Create a new user.
     * CREATE.r.u.d
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return
     */
    public String createUser(String firstName, String lastName, String email, String phone) {

        // Generate the user's card number.
        int cardNumber = generateCardNumber();

        // Create a new user object.
        User newUser = new User(cardNumber, firstName, lastName, email, phone);

        // Create a new userDao.
        GenericDao userDao = new GenericDao(User.class);

        // Insert the new user into the database.
        userDao.insert(newUser);

        // Return the new user as a string.
        String userInfo = newUser.toString();

        logger.debug("Sending back new user info ..." + userInfo);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(userInfo);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Method to get all users/readers from the database.
     * c.READ.u.d
     *
     * @return the list of all readers/users
     */
    public String getAllReaders() {
        GenericDao<User> dao = DaoFactory.createDao(User.class);
        List<User> users = dao.getAll();
        logger.debug("Sending back ALL users..." + users);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(users);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Method to get a single user/reader from the database.
     * c.READ.u.d
     *
     * @param readerId the id of the user to get.
     * @return the user with the given id.
     */
    public String getSpecificReader(int readerId) {

        GenericDao<User> dao = DaoFactory.createDao(User.class);

        User user = (User) dao.getById(readerId);

        logger.debug("Sending back user with id " + readerId + "..." + user);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Method to get a reader/users checked out books.
     * c.READ.u.d
     *
     * @param readerId the id of the book to get the current reader of.
     * @return the current reader of the given book.
     */
    public String getSpecificReadersBooks (int readerId) {

        //Instantiate both the books and readers daos.
        GenericDao userDao = new GenericDao(User.class);
        GenericDao usersBooksDao = new GenericDao(UsersBooks.class);

        // Get the user object by the given id.
        User user = (User) userDao.getById(readerId);

        // Use the user object to find books for just that user.
        List<Books> specificUsersBooks = usersBooksDao.getByPropertyEqual("user", user);

        logger.debug("Sending back ALL books for one user..." + specificUsersBooks);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(specificUsersBooks);
            logger.debug("ResultingJSONstring = " + json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Update an existing user.
     * c.r.UPDATE.d
     *
     * @return the updated user.
     */
    public String updateReader(int readerId, String firstName, String lastName, String email, String phone) {

            // Create a new userDao.
            GenericDao userDao = new GenericDao(User.class);

            // Get the user object by the given id.
            User user = (User) userDao.getById(readerId);

            // Update the user object with the new information.
            if (firstName != null) {
                user.setFirstName(firstName);
            }
            if (lastName != null) {
                user.setLastName(lastName);
            }
            if (email != null) {
                user.setEmail(email);
            }
            if (phone != null) {
                user.setPhoneNumber(phone);
            }

            // Update the user in the database.
            userDao.saveOrUpdate(user);

            // Return the updated user as a string.
            // User userInfo = (User) userDao.getById(readerId);
            String userInfo = userDao.getById(readerId).toString();

            logger.debug("Sending back updated user info ..." + userInfo);

            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(userInfo);
                logger.debug("ResultingJSONstring = " + json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
    }

    /**
     * Delete a user.
     * c.r.u.DELETE
     *
     * @param readerId
     * @return
     */
    public String deleteReader(int readerId) {

            // Create a new userDao.
            GenericDao userDao = new GenericDao(User.class);

            // Get the user object by the given id.
            User user = (User) userDao.getById(readerId);

            // Delete the user from the database.
            userDao.delete(user);

            // Return the deleted user as a string.
            String userInfo = user.toString();

            logger.debug("Sending back deleted user info ..." + userInfo);

            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(userInfo);
                logger.debug("ResultingJSONstring = " + json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
    }

    private int generateCardNumber() {

        int min = 100;
        int max = 999;

        // Generate a random number between 100 and 999.
        int cardNumber = (int) (Math.random() * (max - min + 1) + min);

        return cardNumber;
    }
}
