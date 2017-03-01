package com.company;

/**
 * Created by hackeru on 01/03/2017.
 */
public class Count {

    private int number;

    public synchronized void increment(){
        number++;
    }

    public int getNumber() {
        return number;
    }
}
