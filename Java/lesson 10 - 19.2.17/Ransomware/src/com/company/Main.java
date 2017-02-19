package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        

        try {
            FileInputStream in = new FileInputStream("C:\\Users\\hackeru\\Desktop\\myImages\\bahamas_encrypted.jpg");
            FileOutputStream out = new FileOutputStream("C:\\Users\\hackeru\\Desktop\\myImages\\new.jpg");
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while ((actuallyRead = in.read(buffer)) > 0){
                for (int j = 0; j < buffer.length; j++){
                    buffer[j] = (byte) (buffer[j] ^ 7);
                }
                out.write(buffer, 0, actuallyRead);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

}

