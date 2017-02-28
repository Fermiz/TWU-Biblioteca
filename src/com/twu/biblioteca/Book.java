package com.twu.biblioteca;

/**
 * Created by Mac on 2017/2/27.
 */
public class Book {
    private String no;
    private String title;
    private String author;
    private int year;

    public Book(String no,String title, String author, int year) {
        this.no = no;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getBookInfo() {
        return String.format("%-30s | %-20s | %d", title, author, year);
    }
}
