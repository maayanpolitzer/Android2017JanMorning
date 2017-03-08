package com.company;

/**
 * Created by hackeru on 08/03/2017.
 */
public class Person {

    private String name;
    private String phone;

    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + ":" + phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj != null && obj instanceof Person){
            Person p = (Person) obj;
            return p.name.equals(name) && p.phone.equals(phone);
        }
        return false;
    }
}
