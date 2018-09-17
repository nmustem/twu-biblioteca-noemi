package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.dto.LibraryProduct;
import com.twu.biblioteca.dto.Movie;
import com.twu.biblioteca.dto.User;
import com.twu.biblioteca.utils.BibliotecaUtils;
import com.twu.biblioteca.utils.BiblotecaConstants;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();
    private static List<Book> booksList = bibliotecaUtils.fillBooksList();
    private static List<Movie> moviesList = bibliotecaUtils.fillMovieList();
    private static LibraryManager libraryManager = new LibraryManager();
    private static SessionManager sessionManager = new SessionManager();
    private static User userLoged;

    public static void main(String[] args) {
        welcome();
        login();
        manageUserActions(showMainMenu());
    }

    static void welcome() {
        System.out.println(BiblotecaConstants.WELCOME_MESSAGE + "\n");
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        String username = null;
        String password = null;

        System.out.println(BiblotecaConstants.LOGIN_MESSAGE);

        do {
            if(username != null){
                System.out.println(BiblotecaConstants.WRONG_CREDENTIALS);
            }
            System.out.println(BiblotecaConstants.USERNAME);
            username = scanner.next();

            System.out.println(BiblotecaConstants.PASSWORD);
            password = scanner.next();
        }
        while (!sessionManager.login(username, password));
        // FIXME , recover the user loged data
    }

    private static Integer showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int optionChosen;

        System.out.println("\n" + BiblotecaConstants.WHAT_TO_DO);
        for (String option : BiblotecaConstants.MENU_OPTIONS) {
            System.out.println("\t " + option);
        }

        do {
            System.out.print("\n" + BiblotecaConstants.CHOOSE_MENU_OPTION);
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n " + BiblotecaConstants.INVALID_NUMBER, input);
            }
        }
        while ((optionChosen = scanner.nextInt()) < BiblotecaConstants.MINIMUM_MENU_SIZE || optionChosen > BiblotecaConstants.MENU_OPTIONS.size());

        return optionChosen;
    }

    private static void manageUserActions(Integer integer) {
        //FIXME new items added to the menu, missing methods implementation
        switch (integer) {
            case 1: // List books
                listSpecificProduct(BiblotecaConstants.BOOKS, BiblotecaConstants.BOOK_SEPARATOR, BiblotecaConstants.BOOKS_LIST_HEADER, booksList);
                manageUserActions(askToContinue());
                break;
            case 2: //Checkout book
                initTheCheckoutProductProcess(BiblotecaConstants.BOOK.toLowerCase(), booksList);
                manageUserActions(askToContinue());
                break;
            case 3: //Return book
                initTheReturnProductProcess(BiblotecaConstants.BOOK.toLowerCase(), booksList);
                manageUserActions(askToContinue());
                break;
            case 4: //List movies
                listSpecificProduct(BiblotecaConstants.MOVIES, BiblotecaConstants.MOVIE_SEPARATOR, BiblotecaConstants.MOVIE_LIST_HEADER, moviesList);
                manageUserActions(askToContinue());
                break;
            case 5: //Checkout movie
                initTheCheckoutProductProcess(BiblotecaConstants.MOVIE.toLowerCase(), moviesList);
                manageUserActions(askToContinue());
                break;
            case 6: //Return movie
                initTheReturnProductProcess(BiblotecaConstants.MOVIE.toLowerCase(), moviesList);
                manageUserActions(askToContinue());
                break;
            case 7: //Show user information
          //      showUserInformation();
                manageUserActions(askToContinue());
                break;
            case 8:
            case -1:
                quit();
                break;
            case 0:
                manageUserActions(showMainMenu());
                break;
            default:
                break;
        }
    }

    private static int askToContinue() {
        Scanner scanner = new Scanner(System.in);
        String optionChosen;

        System.out.println("\n " + BiblotecaConstants.CONTINUE_MESSAGE);
        for (String option : BiblotecaConstants.CONTINUE_OPTIONS) {
            System.out.println("\t " + option);
        }

        System.out.print("\n" + BiblotecaConstants.CHOOSE_MENU_OPTION);
        while (!(optionChosen = scanner.next().toUpperCase()).equals(BiblotecaConstants.YES) && !optionChosen.equals(BiblotecaConstants.NO)) {
            System.out.printf("\n " + BiblotecaConstants.INVALID_OPTION, optionChosen);
        }
        System.out.println();

        return optionChosen.equals(BiblotecaConstants.YES) ? 0 : -1;
    }

    private static void listSpecificProduct(String productType, String separator, String header, List<? extends LibraryProduct> productsList) {
        System.out.printf("\n" + BiblotecaConstants.PRODUCTS_LIST + "\n\n", productType.toUpperCase());
        System.out.println(header);
        System.out.println(separator);

        for (LibraryProduct libraryProduct : productsList) {
            if (!libraryProduct.isRented()) {
                System.out.println(libraryProduct.toString());
            }
        }
        System.out.println(separator);
    }

    private static void initTheCheckoutProductProcess(String productType, List<? extends LibraryProduct> productsList) {
        System.out.printf("\n" + BiblotecaConstants.CHECKOUT_PRODUCT + "\n\n", productType.toUpperCase()+ "S");

        if (libraryManager.checkoutProduct(askProductId(productType), productsList)) {
            System.out.printf(BiblotecaConstants.ENJOY_PRODUCT_MESSAGE + "\n\n", productType);
        } else {
            System.out.printf(BiblotecaConstants.PRODUCT_NOT_AVAILABLE_MESSAGE + "\n\n", productType);
        }
    }

    private static void initTheReturnProductProcess(String productType, List<? extends LibraryProduct> productsList) {
        System.out.printf("\n" + BiblotecaConstants.RETURN_PRODUCT + "\n\n", productType.toUpperCase()+ "S");

        if (libraryManager.returnProduct(askProductId(productType), productsList)) {
            System.out.printf(BiblotecaConstants.SUCCESSFUL_PRODUCT_RETURNED_MESSAGE + "\n\n", productType);
        } else {
            System.out.printf(BiblotecaConstants.INVALID_RETURN_PRODUCT_MESSAGE + "\n\n", productType);
        }
    }

    private static int askProductId(String productType) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(BiblotecaConstants.TYPE_PRODUCT_ID_MESSAGE + "\n\n", productType);

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