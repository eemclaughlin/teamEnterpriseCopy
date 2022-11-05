package org.enterprise.restful;

import org.enterprise.service.BookApiService;
import org.enterprise.service.ReaderApiService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    // *******************************************
    // BELOW IS START OF READERS BASED RESTFUL CALLS
    // *******************************************
    /**
     * Base level for the user api
     * Hitting this will list all users in database
     * http://localhost:8080/TeamEnterprise_war/library/
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getIntroduction() {
        String introOutput = ("Welcome to the Library App! " +
                "\n\nUse '/readers' to work with readers. " +
                "\nEx. http://localhost:8080/TeamEnterprise_war/readers/1/books" +
                "\n\nUse '/books' to work with books." +
                "\nEx. http://localhost:8080/TeamEnterprise_war/books/1/readers");

        // Send the results out to the GET
        return Response.status(200).entity(introOutput).build();
    }

    /**
     * Allows user to get a list of all readers
     * http://localhost:8080/TeamEnterprise_war/library/readers
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
     * Requestors can add the additional books keyword and a userid to get all books that
     * reader has borrowed
     * http://localhost:8080/TeamEnterprise_war/readers/1/books
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

    // *******************************************
    // BELOW IS START OF BOOKS BASED RESTFUL CALLS
    // *******************************************

    /**
     *
     * http://localhost:8080/TeamEnterprise_war/books
     * @return
     */
    @GET
    @Path("books")
    @Produces("application/json")
    public Response restfulGetAllBooks() {

        String testString = bookRelatedData.getAllBooks();

        // Send the results out to the GET
        return Response.status(200).entity(testString).build();
    }

    /**
     *
     * http://localhost:8080/TeamEnterprise_war/books/1
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
     *
     * http://localhost:8080/TeamEnterprise_war/books/1/readers
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
}



