package org.enterprise.restful;

import org.enterprise.service.BookApiService;
import org.enterprise.service.ReaderApiService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Restful api to working with readers and/or books by user
 * @author eemclaughlin
 */
@Path("/library")
public class LibraryRestful {

    // Instantiate the relevant service classes to process the restful api calls.
    ReaderApiService readerRelatedData = new ReaderApiService();
    BookApiService bookRelatedData = new BookApiService();

    /**
     * Base level for the user api
     * Hitting this will list all users in database
     * http://localhost:8080/TeamEnterprise_war/library/
     *
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getIntroduction() {
        String introOutput = ("Welcome to the Library App! " +
                "\n\nUse '/readers' to work with readers. " +
                "\nEx. http://localhost:8080/TeamEnterprise_war/library/readers/1/books" +
                "\n\nUse '/books' to work with books." +
                "\nEx. http://localhost:8080/TeamEnterprise_war/library/books/1/readers");

        // Send the results out to the GET
        return Response.status(200).entity(introOutput).build();
    }

    // ***********************************************************************************
    // BELOW IS START OF READERS BASED RESTFUL CALLS
    // ***********************************************************************************

    /**
     * Allows user to get a list of all readers
     * http://localhost:8080/TeamEnterprise_war/library/readers
     *
     * @return
     */
    @GET
    @Path("readers")
    @Produces("application/json")
    public Response restfulGetAllReaders() {
        // Get a string of all readers.
        String testString = readerRelatedData.getAllReaders();
        // Send the result string out to the GET
        return Response.status(200).entity(testString).build();
    }

    /**
     * Get a specific reader by inputting an id
     * http://localhost:8080/TeamEnterprise_war/library/readers/1
     *
     * @param readerId
     * @return
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
     * Requesters can add the additional books keyword and a userid to get all books that
     * reader has borrowed
     * http://localhost:8080/TeamEnterprise_war/library/readers/1/books
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

    // ***********************************************************************************
    // BELOW IS START OF BOOKS BASED RESTFUL CALLS
    // ***********************************************************************************

    /**
     * Get a list of books in the database limited to the number of books requested.
     * <p>
     * http://localhost:8080/TeamEnterprise_war/library/books
     *
     * @return
     */
    @GET
    @Path("books/{start}/{end}")
    @Produces("application/json")
    public Response restfulGetAllBooks(@PathParam("start") int start, @PathParam("end") int end) {

        String testString = bookRelatedData.getAllBooks();

        // Send the results out to the GET
        return Response.status(200).entity(testString).build();
    }

    /**
     * http://localhost:8080/TeamEnterprise_war/library/books/1
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
     * Get who have based a specific book.
     * <p>
     * <p>
     * <p>
     * http://localhost:8080/TeamEnterprise_war/library/books/1/readers
     *
     * @param bookId
     * @return
     */
    @GET
    @Path("books/{bookId}/readers/")
    @Produces("application/json")
    public Response restfulGetSpecificBooksReader(@PathParam("bookId") int bookId) {

        String bookReaderOutput = bookRelatedData.getSpecificBooksReader(bookId);

        // Return the response to the GET.
        return Response.status(200).entity(bookReaderOutput).build();
    }

    /**
     * Create a new user.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return A JSON object with the new users info including their card number.
     */
    @POST
    @Path("users/add")
    @Produces("application/json")
    public Response createUser(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("email") String email, @QueryParam("phone") String phone) {
        String output = "";

        // Generate a new card number for the user.

        // Create a new user in the database.

        // Return the new user to the requester.

        return Response.status(200).entity(output).build();
    }

    /**
     * Delete a user.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return
     */
    @DELETE
    @Path("users/delete/{cardNumber}")
    @Produces("application/json")
    public Response deleteUser(@PathParam("cardNumber") int cardNumber) {
        String output = "";

        // Delete the user from the database.

        // Return the result to the requester.

        return Response.status(200).entity(output).build();
    }

    /**
     * Create a new book using the ISBN number to get the book information from the Google Books API.
     *
     * @param isbn
     * @return A JSON object with the new books info.
     */
    @POST
    @Path("books/addByISBN")
    @Produces("application/json")
    public Response createBookFromIsbn(@QueryParam("isbn") String isbn) {
        String output = "";

        // Remove dashes from ISBN number.

        // Get book from Google Books API

        // Create a new book in the database.

        // Return the new book to the requester.

        // Return null if book not found.

        return Response.status(200).entity(output).build();
    }

    /**
     * Add a new book to the database manually.
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
    public Response createBookManually(@QueryParam("isbnTen") String isbnTen, @QueryParam("isbnThirteen") String isbnThirteen
            , @QueryParam("title") String title, @QueryParam("author") String author, @QueryParam("publisher") String publisher
            , @QueryParam("publishedDate") String publishedDate, @QueryParam("description") String description
            , @QueryParam("pageCount") int pageCount, @QueryParam("language") String language) {

        String output = "";

        // Create a new book in the database.

        // Return the new book to the requester.

        return Response.status(200).entity(output).build();
    }

    /**
     * Delete a book.
     *
     * @param bookId
     * @return
     */
    @DELETE
    @Path("books/delete/{bookId}")
    @Produces("application/json")
    public Response deleteBook(@QueryParam("bookId") int bookId) {
        String output = "";

        // Delete the book from the database.

        // Return the new book to the requester.

        return Response.status(200).entity(output).build();
    }

    /**
     * Check out a book.
     *
     * @param cardNumber
     * @param bookId
     * @return
     */
    @POST
    @Path("books/checkout/{cardNumber}/{bookId}")
    @Produces("application/json")
    public Response checkOutBook(@PathParam("cardNumber") int cardNumber, @PathParam("bookId") int bookId) {
        String output = "";

        // Check out the book.

        // Return the new book to the requester.

        return Response.status(200).entity(output).build();
    }

    /**
     * Check in a book.
     *
     * @param cardNumber
     * @param bookId
     * @return
     */
    @POST
    @Path("books/checkin/{cardNumber}/{bookId}")
    @Produces("application/json")
    public Response checkInBook(@PathParam("cardNumber") int cardNumber, @PathParam("bookId") int bookId) {
        String output = "";

        // Check in the book.

        // Return the new book to the requester.

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Path("books/update/{bookId}")
    @Produces("application/json")
    public Response updateBook(@QueryParam("bookId") int bookId, @QueryParam("isbnTen") String isbnTen, @QueryParam("isbnThirteen") String isbnThirteen
            , @QueryParam("title") String title, @QueryParam("author") String author, @QueryParam("publisher") String publisher
            , @QueryParam("publishedDate") String publishedDate, @QueryParam("description") String description
            , @QueryParam("pageCount") int pageCount, @QueryParam("language") String language) {

        String output = "";

        // Update the book in the database.

        // Return the new book to the requester.

        return Response.status(200).entity(output).build();
    }

    @PUT
    @Path("users/update/{cardNumber}")
    @Produces("application/json")
    public Response updateUser(@PathParam("cardNumber") int cardNumber, @QueryParam("firstName") String firstName
            , @QueryParam("lastName") String lastName, @QueryParam("email") String email, @QueryParam("phone") String phone) {

        String output = "";
        // Update the user in the database.

        // Return the new user to the requesters.

        return Response.status(200).entity(output).build();
    }
}



