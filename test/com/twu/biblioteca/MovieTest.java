package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mac on 2017/2/28.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("1","Transformers", "Michael Benjamin Bay ", 2007, 9);
    }

    @Test
    public void shouldshouldGetMovieInfoInFormat()  {
        assertEquals(String.format("%-30s | %-20s | %d | %d", "Transformers", "Michael Benjamin Bay ", 2007, 9), movie.getMovieInfo());
    }

}