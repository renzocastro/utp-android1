package com.example.utp_android1.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id ;
    private String username;
    private String password;
    private String first_name ;
    private String last_name ;
    private String email ;
    private String date_joined;
    private String DATE_FORMAT ;

    public User(int id, String username, String password, String first_name, String last_name, String email) {
        this.DATE_FORMAT  ="yyyy-mm-dd HH:mm:ss";
        this.id = id;
        this.username = username;
        this.password= password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        DateFormat date_format = new SimpleDateFormat(this.DATE_FORMAT) ;
        Date date = new Date() ;
        this.date_joined= date_format.format(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }
}
