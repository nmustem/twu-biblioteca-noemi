package com.twu.biblioteca.dto;

public abstract class LibraryProduct {
    protected Integer id;

    protected boolean rented;

    public LibraryProduct(Integer id, boolean rented) {
        this.id = id;
        this.rented = rented;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
