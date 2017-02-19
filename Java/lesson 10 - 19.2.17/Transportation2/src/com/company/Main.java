package com.company;

public class Main {

    private static Car[] cars = new Car[10];

    public static void main(String[] args) {

        Person p1 = new Person("Maayan", "051111111", "tel aviv");
        Person p2 = new Person("little moshiko", "0522222222", "Tzur Yitzhak");
        Car c1 = new Car("Pink", 3, "suzuky", 1999, p1);

        //cars[0] = c1;
        //cars[1] = new Car("Green", 5, "Audi", 2017, p1);

        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car("Green", i, "Audi", 2000 + i, new Person("maayan", "05" + i, "tel aviv" + i));
        }

        /*
        // printing...
        for (int i = 0; i < cars.length; i++){
            System.out.println(cars[i].getDetails());
        }
        */

        //System.out.println(c1.getDetails());

        //c1.getOwner().setName("Moshiko");   // won't work!!!(anti-aliasing);

        //System.out.println(c1.getDetails());

        //c1.switchOwner(p1);

        //System.out.println(c1.getDetails());

        System.out.println(getReport(1000006, true));

    }

    private static String getReport(int licensePlate, boolean sendToAddress){
        for (int i = 0; i < cars.length; i++){
            if (licensePlate == cars[i].getLicensePlate()){
                return sendToAddress ?  cars[i].getOwner().getAddress() : cars[i].getOwner().getPhone();
                /*
                if (sendToAddress) {         // same as if(sendToAddress == true){
                    return cars[i].getOwner().getAddress();
                }else{
                   return cars[i].getOwner().getPhone();
                }
                */
            }
        }
        return "Vehicle not found!!!";
    }
}
