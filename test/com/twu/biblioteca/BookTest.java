package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mac on 2017/2/27.
 */
public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("1","The Book Thief", "Markus Zusak", 2007);
    }

    @Test
    public void shouldGetBookInfoInFormat() {
        assertEquals(String.format("%-30s | %-20s | %d","The Book Thief", "Markus Zusak", 2007), book.getBookInfo());
    }
}