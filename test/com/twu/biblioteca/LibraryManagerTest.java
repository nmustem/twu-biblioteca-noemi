package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryManagerTest {

    private LibraryManager libraryManager = new LibraryManager();
    private  List<Book> booksList;

    @Before
    public void setUpStreams() {
        this.booksList = new ArrayList<Book>();
        Book book1 = new Book(1, "Book 1", "Autor1", 1990, false);
        Book book2 = new Book(2, "Book 2", "Autor2", 1991, false);
        Book book3 = new Book(3, "Book 3", "Autor3", 1992, true);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
    }

    @Test
    public void successfulCheckoutBookTest() {
        assertTrue(libraryManager.checkoutBook(1, booksList));
    }

    @Test
    public void failedCheckoutBookTest() {
        assertFalse(libraryManager.checkoutBook(13, booksList));
    }

    @Test
    public void successfulCheckoutBookTest_BookIsRented() {
        libraryManager.checkoutBook(1, booksList);

        assertTrue(booksList.get(0).isRented());
    }

    @Test
    public void failedCheckoutBookTest_SameBooksAreStillAvailable() {
        List<Book> booksListBackup = new ArrayList<Book>();
        for (Book book : booksList) {
            booksListBackup.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.isRented()));
        }

        libraryManager.checkoutBook(13, booksList);

        assertEquals(booksList, booksListBackup);
    }

    @Test
    public void failedCheckoutBookTest_bookIsAlreadyRented() {
        //someone rents a book with bookId = 1
        libraryManager.checkoutBook(1, booksList);

        //someone tries to rent a book that is already rented
        assertFalse(libraryManager.checkoutBook(1, booksList));
    }

    @Test
    public void successfulReturnBookTest() {
        assertTrue(libraryManager.returnBook(3, booksList));
    }

    @Test
    public void failedReturnBookTest() {
        assertFalse(libraryManager.returnBook(13, booksList));
    }

}