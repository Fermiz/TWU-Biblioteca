package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;

/**
 * Created by Mac on 2017/2/27.
 */
public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ArrayList<Book> bookList;
    private Book theBookThief;
    private Scanner scanner;

    @Before
    public void setUp(){
        bookList = new ArrayList();
        scanner = mock(Scanner.class);
        bibliotecaApp = new BibliotecaApp(bookList,scanner);
        theBookThief = mock(Book.class);

    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting(){
        bibliotecaApp.start();
        //verify(System.out).println(contains("Welcome"));
    }
}