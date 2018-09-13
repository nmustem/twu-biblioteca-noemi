package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.utils.BibliotecaUtils;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();
    private static List<Book> booksList;

    public static void main(String[] args) {
        welcome();
        showMainMenu();
        showTheAvailableBooksList();
    }

    static void welcome() {
        System.out.println("Welcome to the Bangalore Public Library. The Biblioteca is available to use it!\n");
    }

    private static Integer showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        System.out.println("What do you want to do? (Choose one menu option by typing the number)");
        System.out.println("\t 1 - List Books");
        System.out.println("\t 2 - Quit");

        do {
            System.out.print("\nSelect an existing menu option: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n \"%s\" is not a valid number. Enter again please: ", input);
            }
        } while ((menuOption=scanner.nextInt()) < 1 || menuOption > 2);

        return menuOption;
    }

    private static void showTheAvailableBooksList() {
        booksList = bibliotecaUtils.fillBooksList();

        System.out.println("\n__BOOKS LIST__\n");
        System.out.printf("| %5s | %-30s | %-30s | %4s | %5s|", "Id", "Title", "Author", "Year", "Rented");
        System.out.println("\n------------------------------------------------------------------------------------------");

        for(Book book : booksList){
            if(!book.isRented()){
                System.out.println(book.toString());
            }

        }
    }
}
