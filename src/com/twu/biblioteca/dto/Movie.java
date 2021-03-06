package com.twu.biblioteca.dto;

public class Movie extends LibraryProduct{
    private String title;

    private String director;

    private int year;

    private int rating; // 0 means unrated

    public Movie(Integer id, String title, String director, int year, int rating) {
        super(id);
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("| %5s | %-30s | %-30s | %4s | %7s |",
                id, title.length() > 30 ? title.substring(0, 27) + "..." : title, director.length() > 30 ? director.substring(0, 27) + "..." : director, year, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                rating == movie.rating &&
                id.equals(movie.id) &&
                title.equals(movie.title) &&
                director.equals(movie.director);
    }
}