package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;
    private final PrintStream out;
    private BufferedReader in;
    private Boolean inputValid;

    public BibliotecaApp(ArrayList<User> listOfUsers, ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies,BufferedReader in, PrintStream out) {

        this.userList = listOfUsers;
        this.bookList = listOfBooks;
        this.movieList = listOfMovies;
        this.out = out;
        this.in = in;
        this.inputValid = true;
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
        this.out.println("2.Enter [2] to checkout book");
        this.out.println("3.Enter [3] to return book");
        this.out.println("4.Enter [4] to show all movies");
        this.out.println("5.Enter [5] to checkout movie");
        this.out.println("6.Enter [6] to return movie");
        this.out.println("7.Enter [0] to quit the system");
        this.respondToUserInput();
    }

    public void respondToUserInput() {
        while (this.inputValid) {
            applySelectedMenuOption(getUserInput());
        }
    }

    public void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks(this.bookList);
                break;
            case 2:
                this.checkoutBook();
                break;
            case 3:
                this.returnBook();
                break;
            case 4:
                this.listMovies(this.movieList);
                break;
            case 5:
                this.checkoutMovie();
                break;
            default:
                this.out.println("Select a valid option!");
        }
    }

    public Integer getUserInput() {
        Integer input = 0;
        try {
            this.out.print("\nMenu selection: \n");
            input =  Integer.parseInt(in.readLine());
        } catch (Exception e) {
            this.out.println("Select a valid option!");
        }
        return input;
    }

    public void listBooks(ArrayList<Book> bookList){
        String output = "";
        for (Book book : bookList){
            output += book.getBookInfo() + "\n";
        }
        this.out.print(output);
    }

    public void checkoutBook(){

    }

    public void returnBook(){

    }

    public void listMovies(ArrayList<Movie> movieList){
        String output = "";
        for (Movie movie : movieList){
            output += movie.getMovieInfo() + "\n";
        }
        this.out.print(output);
    }

    public void checkoutMovie(){

    }


}
