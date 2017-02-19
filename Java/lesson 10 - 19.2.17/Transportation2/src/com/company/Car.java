package com.company;

import java.util.Random;

/**
 * Created by hackeru on 29/01/2017.
 */
public class Car {

    //private static Random r;
    private static int counter; // default is 0;

    private String color;
    private int hand;
    private String brand;
    private int year;
    private Person owner;
    private int licensePlate;

    // static constructor, get called only the first time we use this class!!!
    static {
        //r = new Random();
        counter = 1000000;

    }


    public Car(String newColor, int newHand, String newBrand, int newYear, Person newOwner){
        color = newColor;
        hand = newHand;
        brand = newBrand;
        year = newYear;
        owner = newOwner;
        //licensePlate = r.nextInt(9000000) + 1000000;   // 1,000,000 - 9,999,999
        licensePlate = counter++;

    }

    public void switchOwner(Person buyer){
        if (owner != buyer) {
            owner = buyer;
            hand++;
        }
    }

    public String getDetails(){
        return color + ", " + hand + ", " + brand + ", " +
                 year + ", " + licensePlate + ", " + owner.getDetails();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public int getHand() {
        return hand;
    }

    public String getBrand() {
        return brand;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public Person getOwner(){
        //return owner;
        return new Person(owner);  // anti aliasing...
    }
}
