package com.company;

/**
 * Created by hackeru on 08/02/2017.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int id;

    public Person(String first, String last, int ID) {
        firstName = first;
        lastName = last;
        id = ID;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        if (id == person.id && firstName.equals(person.firstName) && lastName.equals(person.lastName)) {
            return true;
        } else {
            return false;
        }
    }
}
