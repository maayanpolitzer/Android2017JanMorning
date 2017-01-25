package com.company;

public class Main {

    public static int wow = 20;

    public static void wow(int[] x){
        arr[1] = 54;
    }

    public static void mysteryMix(int x){
        x = 2;
    }

    public static void main(String[] args) {
/*
        int a = 1;
        int b = 2;

        mysteryMix(a,a);
        mysteryMix(a,b);
        System.out.println(a);
        System.out.println(b);

*/
        int a = 1;
        mysteryMix(a);
        System.out.println(a);
        int[] arr = {4,5,6};
        wow(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
/*
        int i = 0;
        i = i++ + i;
        System.out.println(i);
        */
        /*
        int age = 50;

        for (int i = 1; i < 100; i++){
            age = 60 / i;
        }

        wow = 76;
        printInt();
        System.out.println(wow + 100);
        System.out.println(age);
        */


    }



    public static void printInt(){
        int age = 45;
        System.out.println(age);
        System.out.println(wow++);
        System.out.println(++wow);

    }

}
