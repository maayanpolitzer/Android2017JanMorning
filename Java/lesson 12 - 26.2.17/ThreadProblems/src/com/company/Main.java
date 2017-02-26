package com.company;

public class Main {

    public static void main(String[] args) {

        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.start();
        m2.start();

        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(MyThread.getCounter());

    }
}
