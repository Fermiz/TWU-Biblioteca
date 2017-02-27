package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> bookList;

    public BibliotecaApp(ArrayList<Book> listOfBooks) {
        this.bookList = listOfBooks;
    }

    public void start(){
        this.getWelcomeMessage();
        this.listBooks(bookList);
    }

    public void getWelcomeMessage(){
        System.out.println("Welcome To The Biblioteca Library!");
    }

    public void listBooks(ArrayList<Book> bookList){
        String output = "";
        for (Book book : bookList){
            output += book.getBookInfo() + "\n";
        }
        System.out.print(output);
    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("The Book Thief", "Markus Zusak", 2007));
        bookList.add(new Book("Gone with the Wind", "Margaret Mitchell", 2011));
        bookList.add(new Book("Life of Pi", "Yann Martel", 2007));
        bookList.add(new Book("A Game of Thrones: Book One of A Song of Ice and Fire", "George R.R. Martin", 2012));

        Scanner sc = new Scanner(System.in);

        BibliotecaApp biblioteca = new BibliotecaApp(bookList);

        biblioteca.start();
    }

    //List Books
    //Book Details
    //Main Menu
    //Invalid Menu Option
    //Quit
    //Checkout Book
    //Successful Checkout
    //Unsuccessful Checkout
    //Return Book
    //Successful Return
    //Unsuccessful Return
}
