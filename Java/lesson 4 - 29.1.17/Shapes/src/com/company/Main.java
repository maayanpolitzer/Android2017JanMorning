package com.company;

public class Main {

    public static void main(String[] args) {

        Square s1 = new Square(7, 7);
        System.out.println(s1.getWidth());
        System.out.println(s1.getHeight());
        System.out.println(s1.getSurface());

        Square s2 = new Square(7, false);
        System.out.println(s2.getWidth());
        System.out.println(s2.getHeight());
        System.out.println(s2.getSurface());

        Square s3 = new Square(81, true);
        System.out.println(s3.getWidth());
        System.out.println(s3.getHeight());
        System.out.println(s3.getSurface());

    }
}
