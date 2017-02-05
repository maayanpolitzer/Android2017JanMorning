package com.company;

public class Main {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();
        da.add("Maayan");
        da.add("Ofir");

        da.print();

        System.out.println(da.get(30));

        System.out.println(da.size());


        // HOME WORK:
        da.add(1, "wow");
        // TODO: 05/02/2017 add "wow" to index 1, move all right...

        da.clear();
        // TODO: 05/02/2017 clear all data.

        boolean b = da.contains("Ofir");
        System.out.println(b);

        int index = da.indexOf("Moshe");
        System.out.println(index);

        da.set(3, "WIIIIII");

        da.remove("Maayan");

    }
}
