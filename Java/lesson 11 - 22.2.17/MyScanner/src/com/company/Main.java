package com.company;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    static boolean ok = true;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        System.out.println("hello " + name);

        while (ok) {
            System.out.println("enter your password:");
            String password = scanner.nextLine();
            System.out.println("enter your action");
            String action = scanner.nextLine();
            switch (action) {
                case "finish":
                    System.out.println("program finished ");
                    ok = false;
                    break;
                case "go":
                    System.out.println("still running");
                    break;
            }
        }

    }
}
