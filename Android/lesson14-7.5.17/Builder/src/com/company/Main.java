package com.company;

public class Main {

    public static void main(String[] args) {

        Car c1 = new Car.CarBuilder("BMW", 1990)
                .setColor("Pink")
                .setLp(1234567)
                .build();

    }
}
