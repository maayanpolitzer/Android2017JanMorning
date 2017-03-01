package com.company;

public class Main {

    public static void main(String[] args) {

        Animal snake = new Animal(){
            @Override
            public int getNumberOfLegs(int g) {
                return 0;
            }
        };

        Animal horse = new Animal() {
            @Override
            public int getNumberOfLegs(int g) {
                return 4;
            }
        };

        Animal spider = new Animal() {
            @Override
            public int getNumberOfLegs(int g) {
                return 8;
            }

        };

        Printable p = new Printable() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        };




    }
}
