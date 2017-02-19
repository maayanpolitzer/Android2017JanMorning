package com.company;

/**
 * Created by hackeru on 29/01/2017.
 */
public class Person {

    private String name;
    private String phone;
    private String address;

    public Person(String newName, String newPhone, String newAddress) {
        name = newName;
        phone = newPhone;
        address = newAddress;
    }

    public Person(Person obj){    // copy constructor...
        name = obj.getName();
        phone = obj.getPhone();
        address = obj.getAddress();
    }

    public String getDetails(){
        return name + ", " + phone + ", " + address;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setPhone(String newPhone){
        phone = newPhone;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }

}
