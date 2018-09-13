package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
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

        booksList.add(book1);
        booksList.add(book2);
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
    public void successfulCheckoutBookTestListSizeDecreased() {
        libraryManager.checkoutBook(1, booksList);
        assertEquals(1, booksList.size());
    }

    @Test
    public void failedCheckoutBookTestSameListSize() {
        libraryManager.checkoutBook(13, booksList);
        assertEquals(2, booksList.size());
    }
}