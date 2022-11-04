package org.enterprise.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Restful api to working with users and/or books by user
 * @author eemclaughlin
 */
@Path("/user")
public class LibraryRestfulUser {

    /**
     * Base level for the user api
     * Hitting this will list all users in database
     * http://localhost:8080/TeamEnterprise_war/user
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getAllUser() {

        // TODO integrate with database using GenericDao to retrieve users and output.

        String testUser1 = "Eric ";
        String testUser2 = "Frank ";
        String testUser3 = "Eduardo ";
        String testUser4 = "John ";
        String testString = testUser1 + testUser2 + testUser3 + testUser4;

        // Send the results out to the GET
        return Response.status(200).entity(testString).build();
    }

    /**
     * Get a specific user by inputting an id
     * http://localhost:8080/TeamEnterprise_war/user/1
     * @param userId
     * @return
     */
    @GET
    @Path("{userId}")
    @Produces("application/json")
    public Response getSpecificUser(@PathParam("userId") int userId) {

        // TODO integrate with database using GenericDao and retrieve user by an Id
        //GenericDao userDao = new GenericDao(User.class);
        //String specificUser = userDao.getById(Integer.parseInt(userId)).toString();

        String testUser = null;

        if (userId == 1) {
            testUser = "Eric ";
        } else if (userId == 2) {
            testUser = "Frank ";
        } else if (userId == 3) {
            testUser = "Eduardo ";
        } else if (userId == 4) {
            testUser = "John ";
        }

        // Send the results out to the GET
        return Response.status(200).entity(testUser).build();
    }

    /**
     * Requestors can add the additional books keyword and a userid to get all books for that user.
     * http://localhost:8080/TeamEnterprise_war/user/books/1
     * @param userId
     * @return
     */
    @GET
    @Path("/books/{userId}")
    @Produces("application/json")
    public Response getSpecificUserBooks(@PathParam("userId") int userId) {

        // Instantiate both the order and user daos.
        //GenericDao userDao = new GenericDao(User.class);
        //GenericDao bookDao = new GenericDao(Order.class);

        // Get the user object by the given id.
        // User user = (User)userDao.getById(Integer.parseInt(userId));

        // Use the user object to find order for just that user.
        // String specificUsersRoles = orderDao.getByPropertyEqual("user", user).toString();

        String testUser = null;
        String book = "Java in 21 Days";

        if (userId == 1) {
            testUser = "Eric ";
        } else if (userId == 2) {
            testUser = "Frank ";
        } else if (userId == 3) {
            testUser = "Eduardo ";
        } else if (userId == 4) {
            testUser = "John ";
        }

        String finalString = testUser + " is reading " + book;

        // Return the response to the GET.
        return Response.status(200).entity(finalString).build();
    }
}

