//package org.enterprise.persistence;
//
//import org.enterprise.googlebooksapi.ItemsItem;
//import org.junit.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class BooksApiTest {
//
//    @Test
//    public void getBookDataSuccess() throws Exception {
//
//        // Instantiate a new dao to get a book data response.
//        BookApiDao dao = new BookApiDao();
//
//        String submittedIsbn = "9780672337956";
//
//        // Expected Response Values.
//        String expectedPublisher = "Sams Publishing";
//        String expectedTitle = "Java in 21 Days, Sams Teach Yourself (Covering Java 9)";
//        String expectedAuthors = "Rogers Cadenhead";
//        int expectedPageCount = 720;
//
//        // On dao, getInfo set up to return full response. Then getItems get me VolumeInfo data.
//        // VolumeInfo has my data in a collection so I need to loop through that.
//        // Item type is ItemsItem and where it is coming from is second half of 'for'....
//        for (ItemsItem item : dao.getResponseInfo(submittedIsbn).getItems()) {
//            assertEquals(expectedPublisher, item.getVolumeInfo().getPublisher());
//            assertEquals(expectedTitle, item.getVolumeInfo().getTitle());
//
//            // For each author in array at second half of "for"...
//            for(String author : item.getVolumeInfo().getAuthors()) {
//                assertEquals(expectedAuthors, author);
//            }
//
//            assertEquals(expectedPageCount, item.getVolumeInfo().getPageCount());
//        }
//    }
//}
