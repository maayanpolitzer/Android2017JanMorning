package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String[] arr = new String[4];
        arr[0] = "Maayan";
        arr[1] = "Orlane";
        arr[2] = "Tomer";
        arr[3] = "Aliav";

        arr = new String[]{"Maayan", "Orlane", "Tomer", "Aliav"};

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }



        //System.out.println(arr[2]);

        ArrayList<String> list = new ArrayList<>();
        list.add("Maayan");
        list.add("Tomer");

        list.set(0, "Moshe");

        //System.out.println(list.get(0));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
