package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Person> map = new HashMap<>();
        map.put(23,new Person("Michael Jordan", "052-1234567"));
        map.put(9, new Person("Leo messi", "054-234342"));
        map.put(7, new Person("Christiano ronaldo", "050-563423423"));

        map.put(7, new Person("Avi nimni", "234556"));

        System.out.println(map);

        System.out.println(map.get(9));
        System.out.println(map.containsKey(24));
        System.out.println(map.containsValue(new Person("Leo messi", "054-234342")));

        System.out.println(map.size());
        // loop...
        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
