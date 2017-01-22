package com.company;

public class Main {

    public static void main(String[] args) {

        //System.out.println(sum(60,30));
        int number = 6;
        System.out.println(sum(number, 7));
        int age = sum(20,10);
    }

    public static int sum(int x, int y){
        int sum = x + y;
        return sum;
    }

    public static int product(int x, int y){
        int result = x * y;
        return result;
    }



}
