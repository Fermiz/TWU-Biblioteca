package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Mac on 2017/2/28.
 */
public class Launcher {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();

        bookList.add(new Book("1","The Book Thief", "Markus Zusak", 2007));
        bookList.add(new Book("2","Gone with the Wind", "Margaret Mitchell", 2011));
        bookList.add(new Book("3","Life of Pi", "Yann Martel", 2007));
        bookList.add(new Book("4","A Song of Ice and Fire", "George R.R. Martin", 2012));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        PrintStream output = new PrintStream(System.out);

        BibliotecaApp biblioteca = new BibliotecaApp(bookList,input,output);

        biblioteca.start();
    }
}
