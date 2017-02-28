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
    public void shouldGetNumber() {
        assertEquals("101-1234", user.getNumber());
    }

    @Test
    public void shouldGetPassword() {
        assertEquals("qazwsx123", user.getPassword());
    }

    @Test
    public void shouldGetUserInfoInFormat() {
        assertEquals(String.format("%-20s | %-20s | %-20s | %-20s | %-20s", "101-1234","Transformers", "qazwsx123", "12345678@gmail.com","12345678900"), user.getUserInfo());
    }

}