package com.company;

public class Main {

    public static void main(String[] args) {

        // convert upward:
        byte b = 126;
        int i = b;
        System.out.println(i);

        // convert downward:
        //1. by casting.
        int k = 346566778;
        short s = (short) k;
        System.out.println(s);

        // 2. by Helper classes:
        int g = 345356;
        Integer f = new Integer(g);
        short j = f.shortValue();

    }
}
