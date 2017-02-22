package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //WriteToFile();
        readFromFile();
    }

    private static void readFromFile(){
        try {
            FileInputStream in = new FileInputStream("liz.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        try {
            FileInputStream in = new FileInputStream("liz.txt");
            byte[] buffer = new byte[1024];
            int length;
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            while ((length = in.read(buffer)) > 0){
                System.out.println(counter++);
                sb.append(new String(buffer, 0, length));
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void WriteToFile() {
        String str = " wow";
        byte[] bytes = str.getBytes();

        try {
            FileOutputStream out = new FileOutputStream("liz.txt", true);
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
