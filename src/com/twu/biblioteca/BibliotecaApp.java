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

    private void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks(this.bookList);
                break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private Integer getUserInput() {
        Integer input = 0;
        try {
            System.out.print("\nMenu selection: \n");
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
        System.out.println("See you next time!");
        this.inputValid = false;
    }

    public void getWelcomeMessage(){
        System.out.println("Welcome To The Biblioteca Library System!");
        this.showMenuOptions();
    }

    public void showMenuOptions() {
        System.out.println("Menu Options:");
        System.out.println("1.Enter [1] to show all books");
        System.out.println("2.Enter [0] to show quit the system");
        this.respondToUserInput();
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
        bookList.add(new Book("A Song of Ice and Fire", "George R.R. Martin", 2012));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, new Scanner(System.in));

        biblioteca.start();
    }

}
