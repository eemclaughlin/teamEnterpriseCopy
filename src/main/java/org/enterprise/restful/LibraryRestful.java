package org.enterprise.restful;

import org.enterprise.service.BookApiService;
import org.enterprise.service.ReaderApiService;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Rest API for tracking a single users books and who they loaned them to.
 * Also uses Google Books to help populate book data into the database.
 * <p>
 * /library is the base level for the Rest API
 *
 * @author Team Enterprise
 */
@Path("/library")
public class LibraryRestful {
    // Instantiate the relevant service classes to process the restful api calls.
    ReaderApiService readerRelatedData = new ReaderApiService();
    BookApiService bookRelatedData = new BookApiService();

    /**
     * Base level for the user api
     * Hitting this level will give the user a welcome message/instructions.
     * http://localhost:8080/TeamEnterprise_war/library/
     *
     * @return introOutput Introductory message for the user.
     */
    @GET
    @Produces("text/plain")
    public Response getIntroduction() {
        String introOutput = ("Welcome to the Library App! " +
                "\n\nUse '/readers' to work with readers. " +
                "\nEx. http://teamenterprise-env.eba-q5tmzh33.us-east-2.elasticbeanstalk.com/library/readers/1/books" +
                "\n\nUse '/books' to work with books." +
                "\nEx. http://teamenterprise-env.eba-q5tmzh33.us-east-2.elasticbeanstalk.com/library/books/1/readers");

        // Send the results out to the GET
        return Response.status(200).entity(introOutput).build();
    }

    // *************************************************************************
    // BELOW IS START OF READERS/USERS BASED RESTFUL CALLS
    // *************************************************************************
    /**
     * Create a new reader/user and add to database.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/add?firstName="Bob"...
     * @version 1.5 Working
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return A JSON object with the new users info including their card number.
     */
    @POST
    @Path("readers/add")
    @Produces("application/json")
    public Response restfulCreateUser(
            @QueryParam("firstname") String firstName,
            @QueryParam("lastname") String lastName,
            @QueryParam("email") String email,
            @QueryParam("phone") String phone) {
        // Call createUser method from ReaderApiService to create a new user.
        String newUserJson = readerRelatedData.createUser(firstName, lastName, email, phone);

        // Return the new user to the requester.
        return Response.status(200).entity(newUserJson).build();
    }

    /**
     * Get a list of all readers/users AND the books they have checked out.
     * c.READ.u.d
     *
     * @version 1.5 Working
     * http://localhost:8080/TeamEnterprise_war/library/readers
     *
     * @return json all readers in the database
     */
    @GET
    @Path("readers")
    @Produces("application/json")
    public Response restfulGetAllReaders() {
        // Get a string of all readers.
        String json = readerRelatedData.getAllReaders();

        // Send the result string out to the GET
        return Response.status(200).entity(json).build();
    }

    /**
     * Get a specific reader by inputting an id
     * Also shows the books they have checked out.
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/1
     * @version 1.5 Working
     *
     * @param readerId
     * @return json specific reader
     */
    @GET
    @Path("readers/{readerId}")
    @Produces("application/json")
    public Response restfulGetSpecificReader(@PathParam("readerId") int readerId) {
        // Get a specific reader based on id provided.
        String specificReader = readerRelatedData.getSpecificReader(readerId);

        // Send the results out to the GET
        return Response.status(200).entity(specificReader).build();
    }

    /**
     * Get a list of all books that a specific reader has checked out/borrowed
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/1/books
     * @version 1.5 Working
     *
     * @param readerId
     * @return
     */
    @GET
    @Path("readers/{readerId}/books/")
    @Produces("application/json")
    public Response restfulGetSpecificReadersBooks(@PathParam("readerId") int readerId) {
        String readerBookOutput = readerRelatedData.getSpecificReadersBooks(readerId);

        // Return the response to the GET.
        return Response.status(200).entity(readerBookOutput).build();
    }

    /**
     * Update a users/readers information
     * c.r.UPDATE.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/1/update?firstName="Bob"...
     * @version 1.5 Working
     *
     * @param readerId   readerid
     * @param firstName  the first name
     * @param lastName   the last name
     * @param email      the email
     * @param phone      the phone
     * @return the response
     */
    @PUT
    @Path("readers/update/{readerid}")
    @Produces("application/json")
    public Response restfulUpdateReader(
            @PathParam("readerid") int readerId,
            @QueryParam("firstname") String firstName,
            @QueryParam("lastname") String lastName,
            @QueryParam("email") String email,
            @QueryParam("phone") String phone) {
        // Take readerID and new parameters and send to update user method.  Return new user info.
        String updatedUser = readerRelatedData.updateReader(readerId, firstName,
                lastName, email, phone);

        // Return the response to the GET.
        return Response.status(200).entity(updatedUser).build();
    }

    /**
     * Delete a reader/user.
     * c.r.u.DELETE
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/delete/1
     * @version 1.5 Working
     *
     * @return the response
     */
    @DELETE
    @Path("readers/delete/{readerid}")
    @Produces("application/json")
    public Response restfulDeleteReader(@PathParam("readerid") int readerId) {
        // Call on delete reader method to delete the reader.
        String message = readerRelatedData.deleteReader(readerId);

        // Return the result to the requester.
        return Response.status(200).entity(message).build();
    }

    // *************************************************************************
    // BELOW IS START OF BOOKS BASED RESTFUL CALLS
    // *************************************************************************
    /**
     * Create a new book using the ISBN number to get the book information from
     * the Google Books API.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/addbyisbn?isbn=9780-061122415
     * @version 1.5 Working Except the ISBN Number
     *
     * @param isbn
     * @return A JSON object with the new books info.
     */
    @POST
    @Path("books/addbyisbn")
    @Produces("application/json")
    public Response restfulCreateBookFromIsbn(@QueryParam("isbn") String isbn) {
        String newBookOutput = bookRelatedData.createBookFromIsbn(isbn);

        // Return the new user to the requester.
        return Response.status(200).entity(newBookOutput).build();
    }

    /**
     * Create a new book and add to the database manually.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/addManually?isbnten=1234567890.....
     * @version 1.5 Working
     *
     * @param isbnTen
     * @param isbnThirteen
     * @param title
     * @param author
     * @param publisher
     * @param publishedDate
     * @param description
     * @param pageCount
     * @param language
     * @return A JSON object with the new books info.
     */
    @POST
    @Path("books/addManually")
    @Produces("application/json")
    public Response restfulCreateBookManually(
            @QueryParam("isbnten") String isbnTen,
            @QueryParam("isbnthirteen") String isbnThirteen,
            @QueryParam("title") String title,
            @QueryParam("author") String author,
            @QueryParam("publisher") String publisher,
            @QueryParam("publisheddate") String publishedDate,
            @QueryParam("description") String description,
            @QueryParam("pagecount") int pageCount,
            @QueryParam("language") String language) {

        // Send book info to create book method and return the new book info.
        String newBookOutput = bookRelatedData.createBookManually(isbnTen,
                isbnThirteen, title, author, publisher, publishedDate,
                description, pageCount, language);

        // Return the new user to the requester.
        return Response.status(200).entity(newBookOutput).build();
    }

    /**
     * Get a list of all books in the database
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books
     * @version 1.0 Working
     *
     * @return json response containing all books
     */
    @GET
    @Path("books")
    @Produces("application/json")
    public Response restfulGetAllBooks() {
        String json = bookRelatedData.getAllBooks();

        // Send the results out to the GET
        return Response.status(200).entity(json).build();
    }

    /**
     * Get a specific book by bookID
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/1
     * @version 1.5 Working
     *
     * @param bookId
     * @return
     */
    @GET
    @Path("books/{bookId}")
    @Produces("application/json")
    public Response restfulGetSpecificBook(@PathParam("bookId") int bookId) {
        // Get a specific reader based on id provided.
        String specificBook = bookRelatedData.getSpecificBook(bookId);

        // Send the results out to the GET
        return Response.status(200).entity(specificBook).build();
    }

    /**
     * Update a book in the database.
     * c.r.UPDATE.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/update/1?isbnten=1234567890.....
     * @version 1.0 Working
     *
     * @param bookId
     * @return
     */
    @PUT
    @Path("books/update/{bookId}")
    @Produces("application/json")
    public Response restfulUpdateBook(
            @PathParam("bookId") int bookId,
            @QueryParam("isbnten") String isbnTen,
            @QueryParam("isbnthirteen") String isbnThirteen,
            @QueryParam("title") String title,
            @QueryParam("author") String author,
            @QueryParam("publisher") String publisher,
            @QueryParam("publisheddate") String publishedDate,
            @QueryParam("description") String description,
            @QueryParam("pageCount") int pageCount,
            @QueryParam("language") String language) {
        // Update the book in the database.
        String updatedBookOutput = bookRelatedData.updateBook(bookId, isbnTen,
                isbnThirteen, title, author, publisher, publishedDate,
                description, pageCount, language);

        // Return the new book to the requester.
        return Response.status(200).entity(updatedBookOutput).build();
    }

    /**
     * Delete a book.
     * c.r.u.DELETE
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/delete/1
     * @version 0.5 Needs Work
     *
     * @param bookId
     * @return
     */
    @DELETE
    @Path("books/delete/{bookid}")
    @Produces("application/json")
    public Response restfulDeleteBook(@PathParam("bookid") Integer bookId) {
        String json = bookRelatedData.deleteBook(bookId);

        // Send the results out to the GET
        return Response.status(200).entity(json).build();
    }

    // *************************************************************************
    // BELOW IS START OF USERS_BOOKS BASED RESTFUL CALLS
    // *************************************************************************

    /**
     * Check out a book to a reader by cardNumber.
     * c.r.UPDATE.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/checkout/1/1
     * @version 1.5 Working
     *
     * @param userId
     * @param bookId
     * @return
     */
    @POST
    @Path("books/checkout/{userId}/{bookId}")
    @Produces("application/json")
    public Response checkOutBook(
            @PathParam("userId") int userId,
            @PathParam("bookId") int bookId) {
        String output = bookRelatedData.checkOutBook(userId, bookId);

        // Return the new book to the requester.
        return Response.status(200).entity(output).build();
    }

    /**
     * Check in a book from a user
     * c.r.UPDATE.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/checkin/123/1
     * @version 1.5 Working
     *
     * @param bookId
     * @return
     */
    @POST
    @Path("books/checkin/{bookId}")
    @Produces("application/json")
    public Response checkInBook(@PathParam("bookId") int bookId) {
        String output = bookRelatedData.checkInBook(bookId);

        // Return the response to the requester.
        return Response.status(200).entity(output).build();
    }
}