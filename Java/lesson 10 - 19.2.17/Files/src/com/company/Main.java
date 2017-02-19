package com.company;

import java.io.*;


public class Main {

    public static void main(String[] args) {

        //createFile();
        //writeToFile("ori ori ori ori ori amazing!!!");
        //readFromFile();
        //copyFile();
        //deleteFile();
        appendToFile();

        /*
        File folder = new File("C:\\Users\\hackeru\\Desktop\\privateFile.txt");
        File newFile = new File("C:\\Users\\hackeru\\Desktop\\privateFile.jpg");
        folder.renameTo(newFile);
        //String[] arr = folder.list();

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */
    }

    private static void appendToFile(){
        File file = new File("C:\\Users\\hackeru\\Desktop\\myImages\\password.txt");
        try {
            FileOutputStream out = new FileOutputStream(file, true);
            out.write("maayan politzer".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile(){
        File f = new File("C:\\Users\\hackeru\\Desktop\\myImages\\bahamas.jpg");
        f.delete();
    }

    private static void copyFile(){
        File original = new File("C:\\Users\\hackeru\\Desktop\\image.jpg");
        File newFile = new File("C:\\Users\\hackeru\\Desktop\\newImage.jpg");
        try {
            FileOutputStream out = new FileOutputStream(newFile);
            FileInputStream in = new FileInputStream(original);
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) > 0){
                out.write(buffer, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readFromFile(){
        try {
            InputStream in = new FileInputStream("myGreatFile.txt");
            byte[] buffer = new byte[1024];
            int actuallyRead = in.read(buffer);
            String str = new String(buffer, 0, actuallyRead);
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String content){
        byte[] contentInBytes = content.getBytes();
        try {
            OutputStream out = new FileOutputStream("myGreatFyle.txt");
            out.write(contentInBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        File myFile = new File("myGreatFile.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
