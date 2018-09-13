package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.utils.BibliotecaUtils;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();
    private static List<Book> booksList = bibliotecaUtils.fillBooksList();
    private static LibraryManager libraryManager = new LibraryManager();

    public static void main(String[] args) {
        welcome();
        manageUserActions(showMainMenu());
    }

    static void welcome() {
        System.out.println("Welcome to the Bangalore Public Library. The Biblioteca is available to use it!\n");
    }

    private static Integer showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        System.out.println("What do you want to do? (Choose one menu option by typing the number)");
        System.out.println("\t 1 - List Books");
        System.out.println("\t 2 - Checkout Book");
        System.out.println("\t 3 - Return Book");
        System.out.println("\t 4 - Quit");

        do {
            System.out.print("\nSelect an existing menu option: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n \"%s\" is not a valid number. Enter again please: ", input);
            }
        } while ((menuOption=scanner.nextInt()) < 1 || menuOption > 4);

        return menuOption;
    }

    private static void showTheAvailableBooksList() {
        System.out.println("\n__BOOKS LIST__\n");
        System.out.printf("| %5s | %-30s | %-30s | %4s | %5s|", "Id", "Title", "Author", "Year", "Rented");
        System.out.println("\n------------------------------------------------------------------------------------------");

        for(Book book : booksList){
            if(!book.isRented()){
                System.out.println(book.toString());
            }

        }
    }

    static void manageUserActions(Integer integer) {
        switch (integer){
            case 1:
                showTheAvailableBooksList();
                break;
            case 2:
                initTheCheckoutBookProcess();
                break;
            case 3:
                initTheReturnBookProcess();
                break;
            case 4:
                quit();
                break;
            default:
                break;
        }
    }

    private static void initTheCheckoutBookProcess() {
        System.out.println("\n__CHECKOUT BOOK__\n");

        if(libraryManager.checkoutBook(askBookId(), booksList)){
            System.out.println("Thank you! Enjoy the book.\n");
        }else{
            System.out.println("That book is not available.\n");
        }
    }

    private static void initTheReturnBookProcess() {
        System.out.println("\n__RETURN BOOK__\n");

        if(libraryManager.returnBook(askBookId(), booksList)){
            System.out.println("Thank you for returning the book.\n");
        }else{
            System.out.println("That is not a valid book to return.\n");
        }
    }

    private static int askBookId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the book id: ");

        while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n \"%s\" is not a valid number. Enter again please: ", input);
            }
        return scanner.nextInt();
    }

    private static void quit() {
        System.out.println("\n__QUIT__\n");
        System.out.println("Thanks for using the BibloitecaApp. See you soon!");
    }
}
