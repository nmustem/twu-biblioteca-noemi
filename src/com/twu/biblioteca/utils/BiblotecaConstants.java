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
            add("7 - Quit");
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

    public static String BOOKS_LIST = "__BOOKS LIST__";

    public static String CHECKOUT_BOOK = "__CHECKOUT BOOK__";

    public static String RETURN_BOOK = "__RETURN BOOK__";

    public static String MOVIES_LIST = "__MOVIES LIST__";

    public static String CHECKOUT_MOVIE = "__CHECKOUT MOVIE__";

    public static String RETURN_MOVIE = "__RETURN MOVIE__";

    public static String QUIT = "__QUIT__";

    public static String CHOOSE_MENU_OPTION = "Select an existing menu option: ";

    public static String INVALID_NUMBER = "\"%s\" is not a valid number. Enter again please: ";

    public static String INVALID_OPTION = "\"%s\" is not a valid option. Enter again please: ";



    //BOOK MESSAGES
    public static String ENJOY_BOOK_MESSAGE = "Thank you! Enjoy the book.";

    public static String BOOK_NOT_AVAILABLE_MESSAGE = "That book is not available.";

    public static String SUCCESSFUL_BOOK_RETURNED_MESSAGE = "Thank you for returning the book.";

    public static String INVALID_RETURN_BOOK_MESSAGE = "That is not a valid book to return.";

    public static String TYPE_BOOK_ID_MESSAGE = "Type the book id: ";

    public static String BOOKS_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s |", "Id", "Title", "Author", "Year");

    public static String BOOK_SEPARATOR = "----------------------------------------------------------------------------------";

    //MOVIE MESSAGES
    public static String ENJOY_MOVIE_MESSAGE = "Thank you! Enjoy the movie.";

    public static String MOVIE_NOT_AVAILABLE_MESSAGE = "That movie is not available.";

    public static String SUCCESSFUL_MOVIE_RETURNED_MESSAGE = "Thank you for returning the movie.";

    public static String INVALID_RETURN_MOVIE_MESSAGE = "That is not a valid movie to return.";

    public static String TYPE_MOVIE_ID_MESSAGE = "Type the movie id: ";

    public static String MOVIE_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s | %7s |", "Id", "Title", "Director", "Year", "Rating");

    public static String MOVIE_SEPARATOR = "----------------------------------------------------------------------------------";

    //public static String BOOKS_LIST_HEADER = String.format("| %5s | %-30s | %-30s | %4s | %5s|", "Id", "Title", "Author", "Year", "Rented");

    //public static String SEPARATOR = "------------------------------------------------------------------------------------------";
}
