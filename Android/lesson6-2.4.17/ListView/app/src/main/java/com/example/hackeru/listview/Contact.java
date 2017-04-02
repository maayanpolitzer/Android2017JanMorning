package com.example.hackeru.listview;


/**
 * Created by hackeru on 4/2/2017.
 */

public class Contact {

    private String name;
    private String phone;
    private int image;
    private boolean whiteBackground = true;

    public Contact(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
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
        return name;
    }
}
