package com.company;

/**
 * Created by hackeru on 5/7/2017.
 */
public class Car {

    // must
    private String model;
    private int year;

    private int lp;
    private String color;
    private int horsePower;
    private int wheels;

    private Car(CarBuilder builder){
        this.model = builder.model;
        this.year = builder.year;
        this.lp = builder.lp;
    }

    public static class CarBuilder {
        private String model;
        private int year;
        private int lp;
        private String color;
        private int horsePower;
        private int wheels;

        public CarBuilder(String model, int year){

        }

        public CarBuilder setLp(int lp){
            this.lp = lp;
            return this;
        }

        public CarBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }


}
