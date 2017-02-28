package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList;
    private final PrintStream out;
    private BufferedReader in;
    private Boolean inputValid;

    public BibliotecaApp(ArrayList<Book> listOfBooks, BufferedReader in, PrintStream out) {
        this.bookList = listOfBooks;
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
        this.out.println("1.Enter [2] to checkout book");
        this.out.println("1.Enter [3] to return book");
        this.out.println("1.Enter [4] to show all movies");
        this.out.println("1.Enter [5] to checkout movie");
        this.out.println("1.Enter [6] to return movie");
        this.out.println("2.Enter [0] to quit the system");
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
                this.quit();//for test to quit
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

    public void listMovies(ArrayList<Movie> movieList){
        String output = "";
        for (Movie movie : movieList){
            output += movie.getMovieInfo() + "\n";
        }
        this.out.print(output);
    }

    public void checkoutBook(){

    }

    public void returnBook(){

    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();

        bookList.add(new Book("1","The Book Thief", "Markus Zusak", 2007));
        bookList.add(new Book("2","Gone with the Wind", "Margaret Mitchell", 2011));
        bookList.add(new Book("3","Life of Pi", "Yann Martel", 2007));
        bookList.add(new Book("4","A Song of Ice and Fire", "George R.R. Martin", 2012));

        BibliotecaApp biblioteca = new BibliotecaApp(bookList, new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));

        biblioteca.start();
    }

}
