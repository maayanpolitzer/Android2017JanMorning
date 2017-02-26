package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            System.out.println(i + " " + Thread.currentThread());
        }
    }
}
