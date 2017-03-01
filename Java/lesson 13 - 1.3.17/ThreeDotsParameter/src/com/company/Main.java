package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(sum(9));
        System.out.println(sum());
        System.out.println(sum(6,7,3,567,23,12));
        System.out.println(sum(new int[]{5,7,43,2,2}));
    }

    public static int sum(int... arr){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            counter += arr[i];
        }
        return counter;
    }

}
