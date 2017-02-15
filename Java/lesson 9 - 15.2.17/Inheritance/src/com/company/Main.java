package com.company;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Person> list = new ArrayList<>();

    public static void main(String[] args) {

        Student s1 = new Student("Moshe");
        Teacher t1 = new Teacher("Maayan");
        Nurse n1 = new Nurse("Sigal");

        /*
        Person p1 = s1;
        Person p2 = t1;
        list.add(p1);
        list.add(p2);
        */

        list.add(s1);
        list.add(t1);
        list.add(n1);



        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
            //System.out.println(list.get(i).getfName());
            //displayPhoneNumber(list.get(i));
            displayName(list.get(i));
        }

        //System.out.println(t1);

        //System.out.println(s1.getClassRoom());
        //System.out.println(s1.getfName());
        //System.out.println(s1);

    }

    public static void displayPhoneNumber(Person tempP) {
        if (tempP instanceof Employee) {
            Employee e = (Employee) tempP;
            System.out.println(e.getPhone());
        }
    }

    public static void displayName(Person tempPerson) {
        System.out.println(tempPerson.getfName());
    }
}
