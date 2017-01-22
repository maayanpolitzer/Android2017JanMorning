package com.company;

public class Main {

    public static void main(String[] args) {

        int daysInMonth = 31;
        int months = 12;
        int age = 3;

        boolean b;
        b = true;
        b = false;

        boolean canItraveltTheElevator = age >= 14; // true;
        System.out.println(canItraveltTheElevator);

        boolean o = isNumbersTheSame(5,8);
        System.out.println(o);

        /*
        if (true){

        }else{
            // false.
        }
        */
    }

    public static boolean isNumbersTheSame(int x, int y){
        return x == y;
        /*
        if (x == y){
            return true;
        }else{
            return false;
        }
        */
    }

    public static boolean isTrue(boolean e){
        return e;
        /*
        if (e){     // equal to if(e == true){
            return true;
        }else{
            return false;
        }
        */
        /*
        if (e == true){
            return true;
        }else{
            return false;
        }
        */
    }
}
