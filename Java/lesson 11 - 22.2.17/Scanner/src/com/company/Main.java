package com.company;

import java.util.Scanner;

public class Main {

    private static boolean isRunning = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();   // block method...
            if(name.equals("exit")){
                isRunning = false;
            }else{
                System.out.println("Your na\nme is " + name);
            }

        }
    }
}
