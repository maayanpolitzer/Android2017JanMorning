package com.company;

/**
 * Created by hackeru on 08/02/2017.
 */
public class Fruit {

    private String name;
    private double price;

    public Fruit(String fruitName, double fruitPrice){
        name = fruitName;
        price = fruitPrice;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
