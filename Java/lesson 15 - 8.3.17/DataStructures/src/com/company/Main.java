package com.company;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("Maayan");
        myList.add("Moshe");
        myList.add("Eyal");
        myList.add("Ron");
        myList.add("Moshe");

        myList.remove("Moshe");

        myList.add(3, "Yossi");

        System.out.println(myList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Maayan");
        linkedList.add("Moshe");
        linkedList.add("Eyal");
        linkedList.add("Ron");
        linkedList.add("Moshe");

        linkedList.remove("Moshe");

        linkedList.add(3, "Yossi");

        System.out.println(myList);



        /*
        MaayanList<String> list = new MaayanList<>();
        list.add("Maayan");
        list.add("Moshe");
        list.add("Moshe");
        list.add("Eyal");
        list.add("Ron");
        list.add("Moshe");

        list.remove("Moshe");

        System.out.println(list);
        */



    }
}
