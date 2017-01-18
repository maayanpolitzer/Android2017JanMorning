package com.company;

public class Main {

    public static void main(String[] args) {

	    //System.out.println(distance(13,80));

        //System.out.println(product(3,3000));

        /*
        System.out.println(quatient(10,4));
        System.out.println(quatient(10,5));
        System.out.println(quatient(1,4));
        System.out.println(quatient(0,4));
        System.out.println(quatient(10,1));
        System.out.println(quatient(10,0));
        System.out.println(quatient(10,10));
        */

        System.out.println(remainder(10, 4));   // same as 10 % 4 ==> 2
    }

    public static int quatient(int x, int y){
        if (y == 0){
            return -1;
        }
        if (y == 1){
            return x;
        }
        int result = 0;
        for (int i = y; i <= x; i += y){
            result++;
        }
        return result;
    }

    public static int product(int x, int y){
        if (x == 0 || y == 0){
            return 0;
        }
        int result = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        for (int i = 0; i < small; i++){
            result += large;
        }
        return result;
    }

    public static int distance(int x, int y){
        if (x == y){
            return 0;
        }
        int myDistance = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        while (small + myDistance < large){
            myDistance++;
        }
        return myDistance;
    }


}
