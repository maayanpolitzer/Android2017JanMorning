package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static File file;
    private static FileOutputStream out;
    private static String userName;
    private static String userPassword;

    public static void main(String[] args) {
        createFile();


        while (enterCommand()) {
            String usersFromFile = getAllUsersFromFile();
            getDataFromScanner();
            if (checkIfUserExists(usersFromFile)){
                System.out.println("User name already exists!!!");

            }else{
                writeUserToFile();
                System.out.println("User " + userName+" created!");
            }


        }

        /// END THE MAIN METHOD //////
    }

    private static void createFile() {
        //Todo: create new text file;
        file = new File("users.txt");

        try {
            out = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static boolean enterCommand() {
        System.out.println("please enter add or close");
        String command = scanner.nextLine();
        if (command.equals("add")) {
            return true;

        } else return false;

    }
}
