package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        int i = 6;
	    incrementByOne(i);
        System.out.println(i);
        */

        int[] arr = new int[3]; // {0,0,0};
        int[] moshe = {5,4,3};
        moshe = arr;
        String[] arr2 = {"ggg", "lll"};
        String str = "Maayan";
        System.out.println(arr2);
        incrementArr(arr);
        ori(arr);
        System.out.println(arr);
    }

    public static void ori(int[] maayan){
        System.out.println(maayan);
    }

    public static void incrementArr(int[] leah) {
        System.out.println(leah);
    }

    public static void incrementByOne(int x){
        x++;
        System.out.println(x);

    }
}
