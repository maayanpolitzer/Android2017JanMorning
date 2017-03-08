package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements ChangeScreenListener {

    private Stage window;

    public static void main(String[] args) {
	    launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        TextField accountNumberTF = new TextField();
        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!accountNumberTF.getText().isEmpty()) {
                    int accountNumber = Integer.parseInt(accountNumberTF.getText());
                    // TODO: 08/03/2017 check if account number exists...
                    // TODO: 08/03/2017 if true -> move to next screen.
                }
            }
        });
        Button createAccountBtn = new Button("Create new account");
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        VBox layout = new VBox();
        layout.getChildren().addAll(accountNumberTF, loginBtn, createAccountBtn);
        displayLayout(layout);
        window.show();
    }

    @Override
    public void displayLayout(VBox layout){
        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
    }
}
