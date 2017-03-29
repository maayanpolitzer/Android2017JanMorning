package com.example.hackeru.complexlistview;

/**
 * Created by hackeru on 29/03/2017.
 */

public class Person {

    private String name;
    private String phone;
    private int image;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return name + ", " + phone;
    }
}
