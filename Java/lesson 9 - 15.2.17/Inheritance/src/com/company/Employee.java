package com.company;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Employee extends Person {

    private int employeeID;
    private String phone;

    public Employee(String fName) {
        super(fName);
    }


    public String getPhone() {
        return phone;
    }
}
