package com.twu.biblioteca.dto;

public class Book extends LibraryProduct{
    private String title;

    private String author;

    private int year;

    public Book(Integer id, String title, String author, int year) {
        super(id);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("| %5s | %-30s | %-30s | %4s |",
                id, title.length() > 30 ? title.substring(0, 27) + "..." : title, author.length() > 30 ? author.substring(0, 27) + "..." : author, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                id.equals(book.id) &&
                title.equals(book.title) &&
                author.equals(book.author);
    }
}