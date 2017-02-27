package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private Scanner scanner;
    private Boolean inputValid;

    public BibliotecaApp(ArrayList<Book> listOfBooks,Scanner sc) {
        this.bookList = listOfBooks;
        this.scanner =sc;
        this.inputValid = true;
    }


    public void start(){
        this.getWelcomeMessage();
    }

    public void getWelcomeMessage(){
        System.out.println("Welcome To The Biblioteca Library!");

    }



    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("The Book Thief", "Markus Zusak", 2007));
        bookList.add(new Book("Gone with the Wind", "Margaret Mitchell", 2011));
        bookList.add(new Book("Life of Pi", "Yann Martel", 2007));
        bookList.add(new Book("A Song of Ice and Fire", "George R.R. Martin", 2012));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, new Scanner(System.in));

        biblioteca.start();
    }

}
