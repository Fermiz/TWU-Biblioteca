package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

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
    private Book theBookThief;
    private BufferedReader in;
    private PrintStream out;

    @Before
    public void setUp(){
        bookList = new ArrayList();
        in = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        theBookThief = mock(Book.class);
        bibliotecaApp = new BibliotecaApp(bookList,in,out);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStart(){
        bibliotecaApp.start();
        verify(out).println(contains("Welcome To The Biblioteca Library System!"));
    }

    @Test
    public void shouldShowMenuOptionsWhenMenuIsShow(){
        bibliotecaApp.start();
        verify(out).println(contains("1.Enter [1] to show all books"));
    }

    @Test
    public void shouldGetBookInfoWhenInputsOne() throws IOException{
        when(in.readLine()).thenReturn("1");
        bookList.add(theBookThief);
        bibliotecaApp.start();
        verify(theBookThief).getBookInfo();
    }

    @Test
    public void shouldReportErroWhenInputIsNotInteger() throws IOException{
        when(in.readLine()).thenReturn("XXXXXX").thenReturn("1");
        bookList.add(theBookThief);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldReportErrorWhenInvalidOptionSelected() throws IOException{
        when(in.readLine()).thenReturn("-1").thenReturn("1");
        bookList.add(theBookThief);
        bibliotecaApp.start();
        verify(out).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(theBookThief);
        when(theBookThief.getBookInfo()).thenReturn("test info");
        bibliotecaApp.listBooks(bookList);
        verify(out).print(contains("test info"));
    }

    @Test
    public void shouldListNothingWhenBooksIsNull(){
        bibliotecaApp.listBooks(bookList);
        verify(out).print(contains(""));
    }



}