package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private final PrintStream out;
    private Scanner scanner;
    private Boolean inputValid;

    public BibliotecaApp(ArrayList<Book> listOfBooks, InputStream in, PrintStream out) {
        this.bookList = listOfBooks;
        this.out = out;
        this.scanner = new Scanner(in);
        this.inputValid = true;
    }

    private void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks(this.bookList);
                break;
            default:
                this.out.println("Select a valid option!");
        }
    }

    private Integer getUserInput() {
        Integer input = 0;
        try {
            this.out.print("\nMenu selection: \n");
            input = this.scanner.nextInt();
        } catch (Exception e) {

        }
        return input;
    }

    public void respondToUserInput() {
        while (this.inputValid) {
            applySelectedMenuOption(getUserInput());
        }
    }

    public void start(){
        this.getWelcomeMessage();
    }

    public void quit(){
        this.out.println("See you next time!");
        this.inputValid = false;
    }

    public void getWelcomeMessage(){
        this.out.println("Welcome To The Biblioteca Library System!");
        this.showMenuOptions();
    }

    public void showMenuOptions() {
        this.out.println("Menu Options:");
        this.out.println("1.Enter [1] to show all books");
        this.out.println("2.Enter [0] to show quit the system");
        this.respondToUserInput();
    }

    public void listBooks(ArrayList<Book> bookList){
        String output = "";
        for (Book book : bookList){
            output += book.getBookInfo() + "\n";
        }
        this.out.print(output);
    }



    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(new Book("The Book Thief", "Markus Zusak", 2007));
        bookList.add(new Book("Gone with the Wind", "Margaret Mitchell", 2011));
        bookList.add(new Book("Life of Pi", "Yann Martel", 2007));
        bookList.add(new Book("A Song of Ice and Fire", "George R.R. Martin", 2012));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, System.in, new PrintStream(System.out));

        biblioteca.start();
    }

}
