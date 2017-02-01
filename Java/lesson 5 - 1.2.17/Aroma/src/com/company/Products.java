package com.company;

/**
 * Created by hackeru on 01/02/2017.
 */
public class Products {

    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
