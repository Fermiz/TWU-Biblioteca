package com.twu.biblioteca;

/**
 * Created by Mac on 2017/2/28.
 */
public class User {
    private String no;
    private String name;
    private String password;
    private String email;
    private String phone;
    private boolean isLogged = false;

    public User(String no,String name, String password,String email,String phone) {
        this.no = no;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUserInfo() {
        return String.format("%-20s | %-20s | %-20s | %-20s | %-20s", no, name, password, email, phone);
    }

    public String getNumber(){
        return this.no;
    }

    public String getPassword(){
        return this.password;
    }

}
