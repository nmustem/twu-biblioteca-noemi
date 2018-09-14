package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.dto.Movie;

import java.util.List;

public class LibraryManager {

    /**
     * Checks if there is a book with id=bookId inside the given list, if so, the rented flag of this book is updated
     * @param bookId the book id to checkout
     * @param booksList the current available books list
     * @return true if it has been possible to checkout, false if not
     */
    public Boolean checkoutBook(int bookId, List<Book> booksList) {
        for (Book book : booksList) {
            if (bookId == book.getId() && !book.isRented()) {
                book.setRented(true);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(int bookId, List<Book> booksList) {
        for (Book book : booksList) {
            if (bookId == book.getId() && book.isRented()) {
                book.setRented(false);
                return true;
            }
        }
        return false;
    }

    public Boolean checkoutMovie(int movieId, List<Movie> moviesList) {
        for (Movie movie : moviesList) {
            if (movieId == movie.getId()) {
                movie.setRented(true);
                return true;
            }
        }
        return false;
    }
}
