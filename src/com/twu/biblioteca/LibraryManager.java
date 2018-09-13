package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;

import java.util.List;

public class LibraryManager {

    public Boolean checkoutBook(int bookId, List<Book> booksList) {
        for(Book book: booksList){
            if(bookId == book.getId()){
                booksList.remove(book);
                return true;
            }
        }
        return false;
    }
}
