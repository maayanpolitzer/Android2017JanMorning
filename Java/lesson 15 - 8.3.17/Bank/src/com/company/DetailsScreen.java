package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by hackeru on 08/03/2017.
 */
public class DetailsScreen {

    private ChangeScreenListener listener;

    public DetailsScreen(ChangeScreenListener listener){
        this.listener = listener;

        Button exitBtn = new Button("EXIT");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //listener.displayLayout(new DepositScreen());
            }
        });
    }

}
