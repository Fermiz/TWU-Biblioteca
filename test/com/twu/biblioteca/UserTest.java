package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mac on 2017/2/28.
 */
public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("101-1234","Transformers", "qazwsx123", "12345678@gmail.com","12345678900");
    }

    @Test
    public void shouldGetUserInfoInFormat() {
        assertEquals(String.format("%-20s | %-20s | %-20s | %-20s | %-20s", "101-1234","Transformers", "qazwsx123", "12345678@gmail.com","12345678900"), user.getUserInfo());
    }

    @Test
    public void shouldReturnTrueIfPasswordCorrect() {
        assertTrue("true", user.login("qazwsx123"));
    }

    @Test
    public void shouldReturnFalseIfPasswordWrong() {
        assertFalse("false", user.login("123qazwsx"));
    }
}