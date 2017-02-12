package com.company;

public class Main {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();
        DynamicArray da2 = new DynamicArray();

        for (int i = 0; i < 9; i++){
            da.add("wiiiii");
        }

        da2.add("Moshe8");
        da2.add("Moshe 5");
        da2.add("Mosh6e");

        da2.add("Moshe3");
        da2.add("Moshe4");

        da.add("wow2");
        da.add("wiiiii");

        da.print();
        //da2.print();

        //System.out.println(da.get(30));

        //System.out.println(da.size());


        // HOME WORK:

        //da.add(0, "s");
        //da.print();
        // TODO: 05/02/2017 add "wow" to index 1, move all right...

        //da.clear();
        // TODO: 05/02/2017 clear all data.


        //da.print();

        //boolean b = da.contains("wow");
        //System.out.println(b);

        //int index = da.indexOf("Moshe 4");
        //System.out.println(index);

        //da.set(3, "WIIIIII");

        da.set(5, "wiiiii");
        da.set(6, "wiiiii");
        da.set(1, "Maayan");
        da.print();
        System.out.println(da.size());
        da.remove("b");
        da.print();
        System.out.println(da.size());


    }
}
