package com.company;

/**
 * Created by hackeru on 08/02/2017.
 */
public class User {

    private String name;
    private String password;

    public User(String username, String pass){
        name = username;
        password = pass;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return name + ":" + password;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if (name.equals(user.name) && password.equals(user.password)){
            return true;
        }
        return false;
    }
}
