package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.utils.BibliotecaUtils;
import com.twu.biblioteca.utils.BiblotecaConstants;

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
        System.out.println(BiblotecaConstants.WELCOME_MESSAGE + "\n");
    }

    private static Integer showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int optionChosen;

        System.out.println(BiblotecaConstants.WHAT_TO_DO);
        for(String option : BiblotecaConstants.MENU_OPTIONS){
            System.out.println("\t " + option);
        }

        do {
            System.out.print("\n" + BiblotecaConstants.CHOOSE_MENU_OPTION);
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n " + BiblotecaConstants.INVALID_NUMBER, input);
            }
        } while ((optionChosen=scanner.nextInt()) < BiblotecaConstants.MINIMUM_MENU_SIZE  || optionChosen > BiblotecaConstants.MENU_OPTIONS.size());

        return optionChosen;
    }

    private static void showTheAvailableBooksList() {
        System.out.println("\n" + BiblotecaConstants.BOOKS_LIST + "\n");
        System.out.println(BiblotecaConstants.BOOKS_LIST_HEADER);
        System.out.println(BiblotecaConstants.SEPARATOR);

        for(Book book : booksList){
            if(!book.isRented()){
                System.out.println(book.toString());
            }
        }
    }

    private static void manageUserActions(Integer integer) {
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
        System.out.println("\n" + BiblotecaConstants.CHECKOUT_BOOK + "\n");

        if(libraryManager.checkoutBook(askBookId(), booksList)){
            System.out.println(BiblotecaConstants.ENJOY_BOOK_MESSAGE + "\n");
        }else{
            System.out.println(BiblotecaConstants.BOOK_NOT_AVAILABLE_MESSAGE + "\n");
        }
    }

    private static void initTheReturnBookProcess() {
        System.out.println("\n" + BiblotecaConstants.RETURN_BOOK + "\n");

        if(libraryManager.returnBook(askBookId(), booksList)){
            System.out.println(BiblotecaConstants.SUCCESSFUL_BOOK_RETURNED_MESSAGE + "\n");
        }else{
            System.out.println(BiblotecaConstants.INVALID_RETURN_BOOK_MESSAGE + "\n");
        }
    }

    private static int askBookId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(BiblotecaConstants.TYPE_BOOK_ID_MESSAGE);

        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\n " + BiblotecaConstants.INVALID_NUMBER, input);
        }
        return scanner.nextInt();
    }

    private static void quit() {
        System.out.println("\n" + BiblotecaConstants.QUIT + "\n");
        System.out.println(BiblotecaConstants.BYE_MESSAGE);
    }
}
