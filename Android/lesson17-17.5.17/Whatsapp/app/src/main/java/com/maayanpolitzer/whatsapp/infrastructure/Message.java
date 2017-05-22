package com.maayanpolitzer.whatsapp.infrastructure;

/**
 * Created by maayanpolitzer on 19/05/2017.
 */

public class Message {

    private boolean incoming;
    private String message;

    public Message(boolean incoming, String message){
        this.incoming = incoming;
        this.message = message;
    }

    public boolean isIncoming() {
        return incoming;
    }

    public String getMessage() {
        return message;
    }
}
