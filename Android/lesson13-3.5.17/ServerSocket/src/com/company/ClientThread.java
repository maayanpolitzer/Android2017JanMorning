package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Hackeru on 5/3/2017.
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            StringBuilder sb = new StringBuilder();
            while((length = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, length));
            }
            System.out.println("welcome " + sb.toString());
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
