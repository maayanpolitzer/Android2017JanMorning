package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /*
        Person p1 = new Person("Moshe", "Cohen", 1);
        Person p2 = new Person("Moshe", "Cohen", 1);
        Person p3 = new Person("lkml", "Clknlknohen", 1);

        System.out.println(p1.equals(p2));
        */

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Maayan", "2"));
        users.add(new User("Maya", "3"));
        users.add(new User("Misha", "4"));
        users.add(new User("Maydfmgkmkm", "1"));
        users.add(new User("Maayana", "123"));

        System.out.println(users);
        //System.out.println(users.contains(new User("Maayan", "123")));

        //System.out.println(users.indexOf(new User("M", "1")));
        User u1 = new User("May", "1235675");

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getName().equals(u1.getName())){

                // already in arrayList
                System.out.println(users);
                return;
            }
        }
        users.add(u1);
        System.out.println(users);



        //users.add(u1);

        //System.out.println(users);

        /*
        ArrayList<String> list = new ArrayList<>();
        list.add("Moshe");

        list.add("Yossi");
        list.add(0, "Liri");
        //list.remove(1);
        //list.remove("Moshe");
        //list.clear();
        list.set(2, "WOW");
        System.out.println(list.contains("Liri"));
        System.out.println(list.size());
        System.out.println(list);
        */


    }
}
