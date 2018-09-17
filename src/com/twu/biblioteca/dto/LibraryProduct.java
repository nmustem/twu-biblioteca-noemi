package com.twu.biblioteca.dto;

public abstract class LibraryProduct {
    protected Integer id;

    private User rentedByUser = null;

    public LibraryProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isRented() {
        return rentedByUser != null;
    }

    public User getRentedByUser() {
        return rentedByUser;
    }

    public void setRentedByUser(User rentedByUser) {
        this.rentedByUser = rentedByUser;
    }
}
