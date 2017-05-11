package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10234);
            while(true){
                System.out.println("waiting for clients...");
                Socket client = serverSocket.accept();  // blocking method...
                System.out.println("client connected! ");
                new ClientThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
