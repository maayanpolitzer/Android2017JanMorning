package com.company;

public class Main {

    public static void main(String[] args) {

        Hall h1 = new Hall(8, "Spy");

        h1.print();

        h1.buyTicket();
        h1.buyTicket(3);
        h1.buyTicket(4);

        //h1.cancelTicket(0);

        h1.print();

        System.out.println(h1.buyGroup(7));

        h1.print();

        /*
        boolean b = false;
        boolean e = !b;


        if (b){

        }else{
            System.out.println("b is FALSE");
        }

        if (!b){    // if(b == false){
            System.out.println("b is FALSE");
        }
        */

    }
}
