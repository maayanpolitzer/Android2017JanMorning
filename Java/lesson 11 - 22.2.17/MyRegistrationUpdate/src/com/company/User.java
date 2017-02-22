package com.company;

/**
 * Created by hackeru on 23/02/2017.
 */
public class User {

    private String name;
    private String password;

    public User(String name,String password){
        this.name =name;
        this.password = password;


    }

    @Override
    public String toString() {
        return "[Username:" + name + "; password " + password + "]";
    }
}
