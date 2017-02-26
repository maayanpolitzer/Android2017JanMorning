package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class MyThread extends Thread {

    public MyThread(){
        setName("From MyThread");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            System.out.println(i + " " + currentThread());
        }
    }
}
