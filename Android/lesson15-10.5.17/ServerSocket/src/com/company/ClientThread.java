package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Hackeru on 5/3/2017.
 */
public class ClientThread extends Thread {

    private Socket socket;
    private static int counter;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int length = in.read();
            byte[] buffer = new byte[length];
            in.read(buffer);
            System.out.println("welcome " + new String(buffer, 0, length));
            out.write(counter++);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
