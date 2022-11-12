package org.enterprise.restful;

import org.enterprise.entity.Books;
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
    // BELOW IS START OF READERS/USERS BASED RESTFUL CALLS
    // ***********************************************************************************
    /**
     * Create a new reader/user and add to database.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/users/add?firstName="Bob"...
     * @version 0.5 Needs Work
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
     * Get a list of all readers/users
     * c.READ.u.d
     *
     * @version 1.0 Working
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
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/readers/1
     * @version 0.5 Needs Work
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
     * @version 0.5 Needs Work
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
     * http://localhost:8080/TeamEnterprise_war/library/users/update/123?firstName=TestFirstName&
     * lastName=TestLastName&address=TestAddress&city=TestCity&state=TestState&zip=12345&
     * phone=1234567890&email=TestEmail
     * @version 0.1 Needs Much Work
     *
     * @param cardNumber the card number
     * @param firstName  the first name
     * @param lastName   the last name
     * @param email      the email
     * @param phone      the phone
     * @return the response
     */
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

    /**
     * Delete a reader/user.
     * c.r.u.DELETE
     *
     * http://localhost:8080/TeamEnterprise_war/library/delete/123
     * @version 0.5 Needs Work
     *
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

    // ***********************************************************************************
    // BELOW IS START OF BOOKS BASED RESTFUL CALLS
    // ***********************************************************************************
    /**
     * Create a new book using the ISBN number to get the book information from the Google Books API.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/addByISBN?isbn=9780-061122415
     * @version 0.5 Needs Work
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
     * Create a new book and add to the database manually.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/addManually?isbnTen=1234567890.....
     * @version 0.5 Needs Work     *
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
     * Get a list of books in the database limited to the number of books requested.
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/1/5
     * @version 0.5 Needs Work
     *
     * @return
     */
    @GET
    @Path("books/{start}/{end}")
    @Produces("application/json")
    public Response restfulRangeOfBooks(@PathParam("start") int start, @PathParam("end") int end) {

        String testString = bookRelatedData.getAllBooks();

        // Send the results out to the GET
        return Response.status(200).entity(testString).build();
    }

    /**
     * Get a specific book by bookID
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/1
     * @version 0.5 Needs Work
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
     * By Book, get the reader who currently has the book checked out.
     * c.READ.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/1/readers
     * @version 0.5 Needs Work
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
     * Update a book in the database.
     * c.r.UPDATE.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/update?bookId=1&
     * isbnTen=1234567890&isbnThirteen=1234567890123&title=TestTitle&author=TestAuthor&
     * publisher=TestPublisher&publishedDate=2017-01-01&description=TestDescription&pageCount=123&language=TestLanguage
     * @version 0.5 Needs Work
     *
     * @param bookId
     * @return
     */
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

    /**
     * Delete a book.
     * c.r.u.DELETE
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/delete?bookId=1
     * @version 0.5 Needs Work
     *
     * @param bookId
     * @return
     */
    @DELETE
    @Path("books/delete")
    @Produces("application/json")
    public Response deleteBook(@QueryParam("bookid") Integer bookId) {

        // Delete the book from the database.
        boolean successMessage = bookRelatedData.deleteBook(bookId);

        if (successMessage = true) {
            return Response.status(200).entity("Book deleted successfully.").build();
        } else {
            return Response.status(200).entity("Book not deleted.").build();
        }
    }

    // ***********************************************************************************
    // BELOW IS START OF USERS_ BOOKS BASED RESTFUL CALLS
    // ***********************************************************************************

    /**
     * Check out a book to a reader by cardNumber.
     * CREATE.r.u.d
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/checkout/123/1
     * @version 0.1 Needs Much Work
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
     * Check in a book from a user
     * c.r.u.DELETE
     *
     * http://localhost:8080/TeamEnterprise_war/library/books/checkin/123/1
     * @version 0.1 Needs Much Work
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
}