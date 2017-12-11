package com.example.administrator.mora_game;

/**
 * Created by Administrator on 2017/5/8.
 */


public class User {

    private int id;
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

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    private String username;
    private String userpwd;

}