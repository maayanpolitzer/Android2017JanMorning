package com.company;

public class Main {

    public static void main(String[] args) {

        G g = new G("Maayan");
        g.start();

        R r = new R();
        Thread t1 = new Thread(r);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t2.start();

    }



}
