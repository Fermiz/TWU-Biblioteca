package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;
    private final PrintStream out;
    private BufferedReader in;
    private Boolean inputValid;
    private String userNow;

    public BibliotecaApp(ArrayList<User> listOfUsers, ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies,BufferedReader in, PrintStream out) {

        this.userList = listOfUsers;
        this.bookList = listOfBooks;
        this.movieList = listOfMovies;
        this.out = out;
        this.in = in;
        this.inputValid = true;
        this.userNow = "";
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

    public void applySelectedMenuOption(Integer input){
        switch (input) {
            case 0:
                this.quit();
                break;
            case 1:
                this.listBooks();
                break;
            case 2:
                this.checkoutBook();
                break;
            case 3:
                this.returnBook();
                break;
            case 4:
                this.listMovies();
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

    public void listBooks(){
        String output = "";
        for (Book book : this.bookList){
            if( book.getBorrower() == "") {
                output += book.getBookInfo() + "\n";
            }
        }
        this.out.print(output);
    }

    public void checkoutBook(){
        this.loginCheck();
        if(this.userNow != ""){
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getTitle().equals(title) && book.getBorrower() == ""){
                    checkStatus = true;
                    book.setBorrower(this.userNow);
                    this.out.println("\nThank you! Enjoy the book.");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat book is not available.");
            }
        }
    }

    public void returnBook(){
        this.loginCheck();
        if(this.userNow != ""){
            String title = this.getBookTitle();
            boolean checkStatus = false;
            for (Book book : this.bookList){
                if(book.getTitle().equals(title) && book.getBorrower() != ""){
                    checkStatus = true;
                    book.setBorrower("");
                    this.out.println("\nThank you for returning the book.");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat is not a valid book to return.");
            }
        }
    }

    public void listMovies(){
        String output = "";
        for (Movie movie : this.movieList){
            if( movie.getBorrower() == "") {
                output += movie.getMovieInfo() + "\n";
            }
        }
        this.out.print(output);
    }

    public void checkoutMovie(){
        this.loginCheck();
        if(this.userNow != ""){
            String title = this.getMovieName();
            boolean checkStatus = false;
            for (Movie movie : this.movieList){
                if(movie.getName().equals(title) && movie.getBorrower() == ""){
                    checkStatus = true;
                    movie.setBorrower(this.userNow);
                    this.out.println("\nThank you! Enjoy the movie");
                    break;
                }
            }

            if(!checkStatus){
                this.out.println("\nThat movie is not available.");
            }
        }
    }

    public void loginCheck(){
        if ( this.userNow == ""){
            this.login(this.getUserNumber(),this.getUserPassword());
        }
    }

    public void login(String userNumber, String password){
        boolean validNumber = false;
        for (User user : this.userList){
            if (user.getNumber().equals(userNumber)){
                validNumber = true;
                if(user.getPassword().equals(password)){
                    this.userNow = user.getNumber();
                    break;
                }else{
                    this.out.print("\nInvalid password: \n");
                }
            }
        }

        if(!validNumber){
            this.out.print("\nInvalid user number: \n");
        }
    }

    public String getBookTitle(){
        this.out.print("\nThe book name: \n");
        String title = "";
        try {
            title = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return title;
    }

    public String getMovieName(){
        this.out.print("\nThe movie name: \n");
        String name = "";
        try {
            name = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return name;
    }

    public String getUserNumber(){
        this.out.print("\nUser number: \n");
        String number = "";
        try {
            number = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return number;
    }

    public String getUserPassword(){
        this.out.print("\npassword: \n");
        String password = "";
        try {
            password = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }


}
