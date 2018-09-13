package com.twu.biblioteca.utils;

import com.twu.biblioteca.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaUtils {


    public List<Book> fillBooksList() {
        List<Book> booksList = new ArrayList<Book>();
        Book book1 = new Book(1, "Book 1", "Autor1", 1990, false);
        Book book2 = new Book(1, "Book 2", "Autor2", 1991, false);
        Book book3 = new Book(1, "Book 3", "Autor3", 1992, false);
        Book book4 = new Book(1, "Book 4", "Autor4", 1993, false);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);

        return booksList;
    }
}
