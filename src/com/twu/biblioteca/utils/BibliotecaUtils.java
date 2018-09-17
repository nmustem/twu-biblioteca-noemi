package com.twu.biblioteca.utils;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.dto.Movie;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaUtils {

    public List<Book> fillBooksList() {
        List<Book> booksList = new ArrayList<Book>();
        Book book1 = new Book(1, "Book 1", "Autor1", 1990);
        Book book2 = new Book(2, "Book 2", "Autor2", 1991);
        Book book3 = new Book(3, "Book 3", "Autor3", 1992);
        Book book4 = new Book(4, "Book 4", "Autor4", 1993);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);

        return booksList;
    }

    public List<Movie> fillMovieList() {
        List<Movie> moviesList = new ArrayList<Movie>();
        Movie movie1 = new Movie(1, "Movie 1", "Director 1 ", 1990, 0);
        Movie movie2 = new Movie(2, "Movie 2", "Director 2", 1991, 4);
        Movie movie3 = new Movie(3, "Movie 3", "Director 3", 1992, 9);
        Movie movie4 = new Movie(3, "Movie 3", "Director 3", 1992, 10);

        moviesList.add(movie1);
        moviesList.add(movie2);
        moviesList.add(movie3);
        moviesList.add(movie4);

        return moviesList;
    }
}
