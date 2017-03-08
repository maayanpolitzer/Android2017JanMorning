package com.company;

/**
 * Created by hackeru on 08/03/2017.
 */
public class Person {

    private String name;

    public Person(String name){
        this.name = name;
        System.out.println(hashCode());
    }

    /*
    public String getName() {
        return name;
    }
    */

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj != null && obj instanceof Person){
            Person person = (Person) obj;
            return name.equals(person.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
