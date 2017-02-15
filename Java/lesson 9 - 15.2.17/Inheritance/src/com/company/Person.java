package com.company;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Person {

    private String fName;
    private String lName;
    private int id;
    private String address;

    public Person(String fName){
        this.fName = fName;
    }

    public String getfName(){
        return fName;
    }

    @Override   // annotation
    public String toString() {
        return "Great person";
    }
}
