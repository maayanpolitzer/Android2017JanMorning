package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Person> set = new HashSet<>();

        set.add(new Person("Maayan"));  //6
        set.add(new Person("aaynMa"));   //5
        set.add(new Person("Maayan"));   //5
        set.add(new Person("Yossi"));   //5 // NO!!!
        set.add(new Person("Irit"));    //4

        System.out.println(set);

        // for each...
        for (Person p : set){
            System.out.println(p);
        }

        String[] arr = {"a", "b", "c", "d"};


        for (String str : arr){
            System.out.println(str);
        }
        /*
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */

    }

}
