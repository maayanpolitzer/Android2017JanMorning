package com.company;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Fruit> fruits = new ArrayList<>();

    public static void main(String[] args) {

        fruits.add(new Fruit("Apple", 9.9));
        fruits.add(new Fruit("Pear", 12.9));
        fruits.add(new Fruit("Banana", 10.9));
        fruits.add(new Fruit("Mango", 17.9));
        fruits.add(new Fruit("Melon", 3.9));

        double sum = getTotalPrice(0.5, 2.0, 6.0, 0.2, 0.4);    // vat 17%.
        System.out.println("You need to pay: " + sum);

    }



}
