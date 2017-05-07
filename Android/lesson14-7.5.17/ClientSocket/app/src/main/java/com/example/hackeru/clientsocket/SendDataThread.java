package com.example.hackeru.clientsocket;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 5/7/2017.
 */

public class SendDataThread extends Thread{

    private DataBackListener listener;
    private String name;
    private Handler handler;
    int response;   // blocking method!!!

    public SendDataThread(DataBackListener listener, String name){
        this.listener = listener;
        this.name = name;
        handler = new Handler();
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("10.0.7.49", 10234);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write("Moshe".getBytes());
            out.flush();
            Log.d("TAG", "flushed!");
            response = in.read();
            Log.d("TAG", "response: " + response);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.displayReturnedData(response);
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
