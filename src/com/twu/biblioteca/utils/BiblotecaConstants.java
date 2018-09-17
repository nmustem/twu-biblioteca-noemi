package com.twu.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

public interface BiblotecaConstants {

    public static String WELCOME_MESSAGE = "Welcome to the Bangalore Public Library. The Biblioteca is available to use it!";

    public static String BYE_MESSAGE = "Thanks for using the BibloitecaApp. See you soon!";


    //MENU CONTENT
    public static String WHAT_TO_DO = "What do you want to do? (Choose one menu option by typing the number)";

    public static int MINIMUM_MENU_SIZE = 1;

    public static List<String> MENU_OPTIONS = new ArrayList<String>() {
        {
            add("1 - List Books");
            add("2 - Checkout Book");
            add("3 - Return Book");
            add("4 - List Movies");
            add("5 - Checkout Movie");
            add("6 - Return Movie");
            add("7 - Show user information");
            add("8 - Quit");
        }
    };

    public static String CONTINUE_MESSAGE = "Do you want to do something else?";

    public static List<String> CONTINUE_OPTIONS = new ArrayList<String>() {
        {
            add("y - Yes. Show me the menu again, please");
            add("n - No. That's all, quit.");
        }
    };

    public static String YES = "Y";

    public static String NO = "N";

    public static String PRODUCTS_LIST = "__%s LIST__";

    public static String CHECKOUT_PRODUCT = "__CHECKOUT %s__";

    public static String RETURN_PRODUCT = "__RETURN %s__";

    public static String USER_INFORMATION = "__USER INFORMATION__";

    public static String QUIT = "__QUIT__";

    public static String CHOOSE_MENU_OPTION = "Select an existing menu option: ";

    public static String INVALID_NUMBER = "\"%s\" is not a valid number. Enter again please: ";

    public static String INVALID_OPTION = "\"%s\" is not a valid option. Enter again please: ";

    public static String BOOK = "Book";

    public static String BOOKS = "Books";

    public static String MOVIE = "Movie";

    public static String MOVIES = "Movies";

    // Product messages
    public static String ENJOY_PRODUCT_MESSAGE = "Thank you! Enjoy the %s.";

    public static String PRODUCT_NOT_AVAILABLE_MESSAGE = "That %s is not available.";

    public static String SUCCESSFUL_PRODUCT_RETURNED_MESSAGE = "Thank you for returning the %s.";

    public static String INVALID_RETURN_PRODUCT_MESSAGE = "That is not a valid %s to return.";

    public static String TYPE_PRODUCT_ID_MESSAGE = "Type the %s id: ";

    //BOOK messages
    public static String BOOKS_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s |", "Id", "Title", "Author", "Year");

    public static String BOOK_SEPARATOR = "----------------------------------------------------------------------------------";

    //MOVIE messages
    public static String MOVIE_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s | %7s |", "Id", "Title", "Director", "Year", "Rating");

    public static String MOVIE_SEPARATOR = "--------------------------------------------------------------------------------------------";

    //public static String BOOKS_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s | %5s|", "Id", "Title", "Author", "Year", "Rented");

    //public static String SEPARATOR = "------------------------------------------------------------------------------------------";
}
