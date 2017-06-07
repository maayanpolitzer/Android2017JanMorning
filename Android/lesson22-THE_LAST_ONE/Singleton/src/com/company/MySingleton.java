package com.company;

/**
 * Created by hackeru on 6/7/2017.
 */
public class MySingleton {

    private static MySingleton instance;
    private int age;
    private static String name = "maayan";

    private MySingleton(){

    }

    public static MySingleton getInstance(){
        if (instance == null){
            instance = new MySingleton();
        }
        return instance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
