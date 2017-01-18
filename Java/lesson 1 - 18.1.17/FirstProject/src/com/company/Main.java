package com.company;

public class Main {

    public static void main(String[] args) {
        int age;
        age = 32;

	    System.out.println(age);
        /*
	    System.out.println(age + 10);
	    System.out.println(age + 20);
	    System.out.println(age + 30);
	    System.out.println(age + 40);
	    System.out.println(age + 50);
	    System.out.println(age + 60);
	    */
        age = 50;
        System.out.println(age);
        age += 5; //age = age + 5;
        age -= 5; //age = age - 78;
        age *= 5; //age = age * 6;
        age /= 5; //age = age / 34;

        age++; //age += 1;
        age--; //age -= 1;

        age = 10;
        System.out.println(age++);


        // conditions:

        age = 15;
        if (age >= 14) {
            // ok;
            System.out.println(1000); // 1000 is GREAT!!!
        } else {
            System.out.println(30); // 30 is NOT good.
        }

        age = 14;

        if (age == 14){

        }else if (age > 14){

        }else{

        }

        // loops:
        // for loop

        for (int i = 0; i < age; i++){
            System.out.println(10);
        }

        int i = 0;
        while (i < age) {
            System.out.println(10);
            i++;
        }

    }

}
