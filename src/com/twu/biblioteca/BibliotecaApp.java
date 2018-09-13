package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.utils.BibliotecaUtils;

import java.util.List;

public class BibliotecaApp {

    private static BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();
    private static List<Book> booksList;

    public static void main(String[] args) {
        welcome();

        showTheAvailableBooksList();
    }

    static void welcome() {
        System.out.println("Welcome to the Bangalore Public Library. The Biblioteca is available to use it!\n");
    }

    private static void showTheAvailableBooksList() {
        booksList = bibliotecaUtils.fillBooksList();

        System.out.printf("| %5s | %-30s | %-30s | %4s | %5s|", "Id", "Title", "Author", "Year", "Rented");
        System.out.println("\n------------------------------------------------------------------------------------------");

        for(Book book : booksList){
            if(!book.isRented()){
                System.out.println(book.toString());
            }

        }
    }
}
