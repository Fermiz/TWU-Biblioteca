package com.twu.biblioteca;

/**
 * Created by Mac on 2017/2/28.
 */
public class Movie {
    private String no;
    private String name;
    private String director;
    private int year;
    private int rating;
    private String borrower;

    public Movie(String no,String name, String director, int year, int rating) {
        this.no = no;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.borrower = "";
    }

    public String getName(){
        return this.name;
    }

    public String getBorrower(){
        return this.borrower;
    }

    public String getMovieInfo() {
        return String.format("%-30s | %-20s | %d | %d", name, director, year, rating);
    }

    public void setBorrower(String borrower){
        this.borrower = borrower;
    }


}
