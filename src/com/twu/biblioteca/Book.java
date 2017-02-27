package com.twu.biblioteca;

/**
 * Created by Mac on 2017/2/27.
 */
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getBookInfo() {
        return String.format("%-30.30s | %-30.30s | %d", title, author, year);
    }
}
