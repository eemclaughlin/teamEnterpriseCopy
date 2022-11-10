package org.enterprise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.enterprise.entity.User;
import org.enterprise.persistence.GenericDao;
import org.enterprise.util.DaoFactory;

import java.util.List;

/**
 * Class to take requests from the restful api and perform actions based on the request.
 */
public class ReaderApiService {

    private final Logger logger = LogManager.getLogger(this.getClass());

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

    public String getSpecificReader(int readerId) {

        // TODO integrate with database using GenericDao and retrieve user by an Id
        //GenericDao userDao = new GenericDao(User.class);
        //String specificUser = userDao.getById(Integer.parseInt(userId)).toString();

        // Create a null test user.
        String testReader = null;

        // Check given readerId for a test return statement.
        if (readerId == 1) {
            testReader = "Eric ";
        } else if (readerId == 2) {
            testReader = "Frank ";
        } else if (readerId == 3) {
            testReader = "Eduardo ";
        } else if (readerId == 4) {
            testReader = "John ";
        }

        return testReader;
    }

    public String getSpecificReadersBooks (int readerId) {

        // Instantiate both the order and user daos.
        //GenericDao userDao = new GenericDao(User.class);
        //GenericDao bookDao = new GenericDao(Order.class);

        // Get the user object by the given id.
        // User user = (User)userDao.getById(Integer.parseInt(userId));

        // Use the user object to find order for just that user.
        // String specificUsersRoles = orderDao.getByPropertyEqual("user", user).toString();

        // Create a test reader and a test book
        String testReader = null;
        String book = "Java in 21 Days";

        // Give a reader based on id given
        if (readerId == 1) {
            testReader = "Eric ";
        } else if (readerId == 2) {
            testReader = "Frank ";
        } else if (readerId == 3) {
            testReader = "Eduardo ";
        } else if (readerId == 4) {
            testReader = "John ";
        }

        // Combine test reader with test book.
        String finalString = testReader + " is reading " + book;

        return finalString;
    }

    /**
     * Update an existing user.
     * @return the updated user.
     */
    public User updateUser(User user) {
        // TODO integrate with database using GenericDao to update a user.
        // Create a new user object.
        // User user = new User();

        // Update user in the database.

        // Return the updated user.
        return user;
    }

    /**
     * Create a new user.
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return
     */
    public User createUser(String firstName, String lastName, String email, String phone) {
        // TODO integrate with database using GenericDao to create a new user.
        // Create a new user object.
        User user = new User();

        // Create a new userDao.


        // Insert the new user into the database.


        // Return the new user.
        return user;
    }

    /**
     * Delete a user.
     * @param userId
     * @return
     */
    public boolean deleteUser(int userId) {
        // TODO integrate with database using GenericDao to delete a user.
        // Create a new user object.
        boolean success = false;
        User user = new User();

        // Delete user from the database.

        // Return if the delete was successful.
        return success;
    }
}
