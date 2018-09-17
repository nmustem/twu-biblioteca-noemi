package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.dto.Movie;
import com.twu.biblioteca.dto.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryManagerTest {

    private LibraryManager libraryManager = new LibraryManager();
    private  List<Book> booksList;
    private  List<Movie> moviesList;
    User userLogged = new User("123-4567", "password", "User 1", "Surname 1", "123-4567@biblioteca.com", 123456789);
    User otherUser = new User("222-2222", "pass", "User 222", "Surname 222", "222-2222@biblioteca.com", 222222222);

    @Before
    public void fillTheBooksList() {
        this.booksList = new ArrayList<Book>();
        Book book1 = new Book(1, "Book 1", "Autor1", 1990, false);
        Book book2 = new Book(2, "Book 2", "Autor2", 1991, false);
        Book book3 = new Book(3, "Book 3", "Autor3", 1992, true);

        book3.setRentedByUser(userLogged);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);

        this.moviesList = new ArrayList<Movie>();
        Movie movie1 = new Movie(1, "Movie 1", "Director 1 ", 1990, 0,false);
        Movie movie2 = new Movie(2, "Movie 2", "Director 2", 1991, 4, false);
        Movie movie3 = new Movie(3, "Movie 3", "Director 3", 1992, 9, true);

        movie3.setRentedByUser(userLogged);

        moviesList.add(movie1);
        moviesList.add(movie2);
        moviesList.add(movie3);
    }

    @Test
    public void successfulCheckoutBookTest() {
        assertTrue(libraryManager.checkoutProduct(1, booksList, userLogged));
    }

    @Test
    public void failedCheckoutBookTest() {
        assertFalse(libraryManager.checkoutProduct(13, booksList, userLogged));
    }

    @Test
    public void successfulCheckoutBookTest_BookIsRented() {
        libraryManager.checkoutProduct(1, booksList, userLogged);

        assertTrue(booksList.get(0).isRented());
    }

    @Test
    public void failedCheckoutBookTest_checksTheListElements() {
        List<Book> booksListBackup = new ArrayList<Book>();
        for (Book book : booksList) {
            booksListBackup.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.isRented()));
        }

        libraryManager.checkoutProduct(13, booksList, userLogged);

        assertEquals(booksList, booksListBackup);
    }

    @Test
    public void failedCheckoutBookTest_bookIsAlreadyRented() {
        //someone rents a book with bookId = 1
        libraryManager.checkoutProduct(1, booksList, userLogged);

        //someone tries to rent a book that is already rented
        assertFalse(libraryManager.checkoutProduct(1, booksList, userLogged));
    }

    @Test
    public void successfulReturnBookTest() {
        assertTrue(libraryManager.returnProduct(3, booksList, userLogged));
    }

    @Test
    public void failedReturnBookTest() {
        assertFalse(libraryManager.returnProduct(13, booksList, userLogged));
    }

    @Test
    public void successfulReturnBookTest_BookIsReturned() {
        libraryManager.returnProduct(3, booksList, userLogged);

        assertFalse(booksList.get(2).isRented());
    }

    @Test
    public void failedReturnBookTest_checksTheListElements() {
        List<Book> booksListBackup = new ArrayList<Book>();
        for (Book book : booksList) {
            booksListBackup.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.isRented()));
        }

        libraryManager.returnProduct(13, booksList, userLogged);

        assertEquals(booksList, booksListBackup);
    }

    @Test
    public void failedReturnBookTest_bookIsAlreadyRented() {
        //someone returns a book with bookId = 3
        libraryManager.returnProduct(3, booksList, userLogged);

        //someone tries to returns a book that is already returned
        assertFalse(libraryManager.returnProduct(3, booksList, userLogged));
    }

    //Movies tests
    @Test
    public void successfulCheckoutMovieTest() {
        assertTrue(libraryManager.checkoutProduct(1, moviesList, userLogged));
    }

    @Test
    public void failedCheckoutMovieTest() {
        assertFalse(libraryManager.checkoutProduct(13, moviesList, userLogged));
    }

    @Test
    public void successfulCheckoutMovieTest_MovieIsRented() {
        libraryManager.checkoutProduct(1, moviesList, userLogged);

        assertTrue(moviesList.get(0).isRented());
    }

    @Test
    public void failedCheckoutMovieTest_checksTheListElements() {
        List<Movie> moviesListBackup = new ArrayList<Movie>();
        for (Movie movie : moviesList) {
            moviesListBackup.add(new Movie(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating(), movie.isRented()));
        }

        libraryManager.checkoutProduct(13, moviesList, userLogged);

        assertEquals(moviesList, moviesListBackup);
    }

    @Test
    public void failedCheckoutMovieTest_movieIsAlreadyRented() {
        //someone tries to rent a movie that is already rented
        assertFalse(libraryManager.checkoutProduct(3, moviesList, userLogged));
    }

    @Test
    public void successfulReturnMovieTest() {
        assertTrue(libraryManager.returnProduct(3, moviesList, userLogged));
    }

    @Test
    public void failedReturnMovieTest() {
        assertFalse(libraryManager.returnProduct(13, moviesList, userLogged));
    }

    @Test
    public void successfulReturnMovieTest_MovieIsReturned() {
        libraryManager.returnProduct(3, moviesList, userLogged);

        assertFalse(moviesList.get(2).isRented());
    }

    @Test
    public void failedReturnMovieTest_checksTheListElements() {
        List<Movie> booksListBackup = new ArrayList<Movie>();
        for (Movie movie : moviesList) {
            booksListBackup.add(new Movie(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating(), movie.isRented()));
        }

        libraryManager.returnProduct(13, moviesList, userLogged);

        assertEquals(moviesList, booksListBackup);
    }

    @Test
    public void failedReturnMovieTest_movieIsAlreadyRented() {
        //someone tries to returns a movie that is already returned
        assertFalse(libraryManager.returnProduct(1, moviesList, userLogged));
    }

    @Test
    public void successfulCheckoutBookTest_rentedByUser() {
        libraryManager.checkoutProduct(booksList.get(0).getId(), booksList, userLogged);
        assertEquals(booksList.get(0).getRentedByUser(), userLogged);
    }

    @Test
    public void successfulCheckoutMovieTest_rentedByUser() {
        libraryManager.checkoutProduct(moviesList.get(0).getId(), moviesList, userLogged);
        assertEquals(moviesList.get(0).getRentedByUser(), userLogged);
    }

    @Test
    public void successfulReturnBookTest_rentedByUser() {
        libraryManager.returnProduct(booksList.get(2).getId(), booksList, userLogged);
        assertEquals(booksList.get(2).getRentedByUser(), null);
    }

    @Test
    public void successfulReturnMovieTest_rentedByUser() {
        libraryManager.returnProduct(moviesList.get(2).getId(), moviesList, userLogged);
        assertEquals(moviesList.get(2).getRentedByUser(), null);
    }

    @Test
    public void unsuccessfulReturnBookTest_rentedByOtherUser() {
        assertFalse(libraryManager.returnProduct(booksList.get(2).getId(), booksList, otherUser));
    }

    @Test
    public void unsuccessfulReturnMovieTest_rentedByOtherUser() {
        assertFalse(libraryManager.returnProduct(moviesList.get(2).getId(), moviesList, otherUser));
    }

    @Test
    public void unsuccessfulReturnBookTest_rentedByOtherUser_checksUserFlag() {
        libraryManager.returnProduct(booksList.get(2).getId(), booksList, otherUser);
        assertEquals(booksList.get(2).getRentedByUser(), userLogged);
    }

    @Test
    public void unsuccessfulReturnMovieTest_rentedByOtherUser_checksUserFlag() {
        libraryManager.returnProduct(moviesList.get(2).getId(), moviesList, otherUser);
        assertEquals(moviesList.get(2).getRentedByUser(), userLogged);
    }
}