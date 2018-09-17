package com.twu.biblioteca;

import com.twu.biblioteca.dto.Book;
import com.twu.biblioteca.dto.LibraryProduct;
import com.twu.biblioteca.dto.Movie;
import com.twu.biblioteca.dto.User;

import java.util.List;

public class LibraryManager {
    /**
     * Checks if there is a product with id=productId inside the given list, if so, the rented flag of this product is updated
     * @param productId the product id to checkout
     * @param productsList the current available products list
     * @return true if it has been possible to checkout, false if not
     */
    public Boolean checkoutProduct(int productId, List<? extends LibraryProduct> productsList, User user) {
        for (LibraryProduct libraryProduct : productsList) {
            if (productId == libraryProduct.getId() && !libraryProduct.isRented()) {
                if(libraryProduct instanceof Book){
                    ((Book) libraryProduct).setRented(true);
                    ((Book) libraryProduct).setRentedByUser(user);
                }else if(libraryProduct instanceof Movie){
                    ((Movie) libraryProduct).setRented(true);
                    ((Movie) libraryProduct).setRentedByUser(user);
                }
                return true;
            }
        }
        return false;
    }

    public Boolean returnProduct(int productId, List<? extends LibraryProduct> productsList, User user) {
        for (LibraryProduct libraryProduct : productsList) {
            if (productId == libraryProduct.getId() && libraryProduct.isRented() && libraryProduct.getRentedByUser().equals(user)) {
                if(libraryProduct instanceof Book){
                    ((Book) libraryProduct).setRented(false);
                    ((Book) libraryProduct).setRentedByUser(null);
                }else if(libraryProduct instanceof Movie){
                    ((Movie) libraryProduct).setRented(false);
                    ((Movie) libraryProduct).setRentedByUser(null);
                }
                return true;
            }
        }
        return false;
    }
}
