package com.company;

public class Main {

    private static Car[] cars = new Car[10];

    public static void main(String[] args) {

        Person p1 = new Person("Maayan", "051111111", "tel aviv");
        Person p2 = new Person("little moshiko", "0522222222", "Tzur Yitzhak");
        Car c1 = new Car("Pink", 3, "suzuky", 1999, p1);

        cars[0] = c1;
        cars[1] = new Car("Green", 5, "Audi", 2017, p1);

        System.out.println(c1.getDetails());

        //c1.getOwner().setName("Moshiko");   // won't work!!!(anti-aliasing);

        //System.out.println(c1.getDetails());

        c1.switchOwner(p1);

        System.out.println(c1.getDetails());

        System.out.println(getReport(10000003, false));

    }

    private static String getReport(int licensePlate, boolean sendToAddress){

    }
}
