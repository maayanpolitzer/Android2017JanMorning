package com.company;


import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by hackeru on 01/03/2017.
 */
public class BtnClick implements EventHandler {

    @Override
    public void handle(Event event) {
        System.out.println("btn clicked!!!!!");
    }
}
