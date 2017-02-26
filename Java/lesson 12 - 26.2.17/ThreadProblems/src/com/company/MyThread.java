package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class MyThread extends Thread {

    private static int counter;

    public MyThread(){

    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            increment();
        }
    }

    public static int getCounter() {
        return counter;
    }

    private synchronized static void increment(){
        counter++;
    }

}
