package com.company;

public class Main {

    public static void main(String[] args) {

        MyThread m = new MyThread();
        //m.setPriority(10);
        m.start();

        Thread t = new Thread(new Runner());
        t.setName("From runner");
        //t.setPriority(1);
        t.start();

        /*
        for (int i = 0; i < 10000; i++){
            System.out.println(i + " " + Thread.currentThread());

        }
        */

    }
}
