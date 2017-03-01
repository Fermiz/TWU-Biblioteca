package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Mac on 2017/2/27.
 */
public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;
    private Book theBookThief;
    private Movie Transformers;
    private User Ruby;
    private BufferedReader in;
    private PrintStream out;

    @Before
    public void setUp(){
        bookList = new ArrayList();
        movieList = new ArrayList();
        userList = new ArrayList();
        in = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        theBookThief = mock(Book.class);
        Transformers = mock(Movie.class);
        Ruby = mock(User.class);
        bibliotecaApp = new BibliotecaApp(userList,bookList,movieList,in,out);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart() throws IOException{
        when(in.readLine()).thenReturn("0");
        bibliotecaApp.start();
        verify(out).println(contains("Welcome To The Biblioteca Library System!"));
    }

    @Test
    public void shouldShowMenuOptionsWhenMenuIsShow() throws IOException{
        when(in.readLine()).thenReturn("0");
        bibliotecaApp.start();
        verify(out).println(contains("1.Enter [1] to show all books"));
    }

    @Test
    public void shouldReportErroWhenInputIsNotInteger() throws IOException{
        when(in.readLine()).thenReturn("XXXXXX").thenReturn("0");
        bookList.add(theBookThief);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldReportErrorWhenInvalidOptionSelected() throws IOException{
        when(in.readLine()).thenReturn("-1").thenReturn("0");
        bookList.add(theBookThief);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldListNothingWhenThereIsNoBook(){
        bibliotecaApp.listBooks();
        verify(out).print(contains(""));
    }

    @Test
    public void shouldListNothingWhenAllBookAreBorrowed(){
        bookList.add(theBookThief);
        when(theBookThief.getBookInfo()).thenReturn("test book info");
        when(theBookThief.getBorrower()).thenReturn("101-1001");
        bibliotecaApp.listBooks();
        verify(out).print(contains(""));
    }

    @Test
    public void shouldListBooksAvailbleWhenInputsOne() throws IOException{
        bookList.add(theBookThief);
        when(theBookThief.getBookInfo()).thenReturn("test book info");
        when(theBookThief.getBorrower()).thenReturn("");
        bibliotecaApp.listBooks();
        verify(out).print(contains("test book info"));
    }

    @Test
    public void shouldShowSuccessfulMessageWhenCheckoutSucceed() throws IOException{
        bookList.add(theBookThief);
        when(theBookThief.getTitle()).thenReturn("the Book Thief");
        when(theBookThief.getBorrower()).thenReturn("");

        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");

        when(in.readLine()).thenReturn("2").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("the Book Thief");
        bibliotecaApp.start();

        verify(theBookThief).setBorrower("101-1001");
        verify(out).println(contains("Thank you! Enjoy the book."));
    }

    @Test
    public void shouldShowFailMessageWhenCheckoutFail() throws IOException{
        bookList.add(theBookThief);
        when(theBookThief.getTitle()).thenReturn("the Book Thief");
        when(theBookThief.getBorrower()).thenReturn("101-1001");

        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");

        when(in.readLine()).thenReturn("2").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("the Book Thief");
        bibliotecaApp.start();

        verify(out).println(contains("That book is not available."));
    }

    @Test
    public void shouldShowSuccessfulMessageWhenReturnSucceed() throws IOException{
        bookList.add(theBookThief);
        when(theBookThief.getTitle()).thenReturn("the Book Thief");
        when(theBookThief.getBorrower()).thenReturn("101-1001");

        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");

        when(in.readLine()).thenReturn("3").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("the Book Thief");
        bibliotecaApp.start();

        verify(theBookThief).setBorrower("");
        verify(out).println(contains("Thank you for returning the book."));
    }

    @Test
    public void shouldShowFailMessageWhenReturnFail() throws IOException{
        bookList.add(theBookThief);
        when(theBookThief.getTitle()).thenReturn("the Book Thief");
        when(theBookThief.getBorrower()).thenReturn("");

        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");

        when(in.readLine()).thenReturn("3").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("the Book Thief");
        bibliotecaApp.start();

        verify(out).println(contains("That is not a valid book to return."));
    }

    @Test
    public void shouldQuitAndSayGoodByeWhenInputZero() throws IOException{
        when(in.readLine()).thenReturn("0");
        bibliotecaApp.start();
        verify(out).println(contains("See you next time!"));
    }

    @Test
    public void shouldGetBookTitle() throws IOException{
        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");
        when(in.readLine()).thenReturn("2").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("the Book Thief");
        bibliotecaApp.start();
        assertEquals("the Book Thief", bibliotecaApp.getBookTitle());
    }

    @Test
    public void shouldGetMovieName() throws IOException{
        userList.add(Ruby);
        when(Ruby.getNumber()).thenReturn("101-1001");
        when(Ruby.getPassword()).thenReturn("qazwsx123123");
        when(in.readLine()).thenReturn("5").thenReturn("101-1001").thenReturn("qazwsx123123").thenReturn("Transformers");
        bibliotecaApp.start();
        assertEquals("Transformers", bibliotecaApp.getMovieName());
    }

    @Test
    public void shouldGetUserNumber() throws IOException{
        when(in.readLine()).thenReturn("2").thenReturn("101-1001");
        bibliotecaApp.start();
        assertEquals("101-1001", bibliotecaApp.getUserNumber());
    }

    @Test
    public void shouldGetUserPassword() throws IOException{
        when(in.readLine()).thenReturn("2").thenReturn("101-1001").thenReturn("password");
        bibliotecaApp.start();
        assertEquals("password", bibliotecaApp.getUserPassword());
    }
}