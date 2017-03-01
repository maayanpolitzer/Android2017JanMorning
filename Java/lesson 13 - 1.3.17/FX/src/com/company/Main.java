package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {

    private Button btn;
    private Stage window;
    private Scene mainScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        btn = new Button("click me! 1");
        Button btn2 = new Button("click me! 2");
        Button btn3 = new Button("Button 3");

        btn.setOnAction(this);
        btn2.setOnAction(this);
        btn3.setOnAction(this);

        HBox layout = new HBox(20, btn, btn2, btn3);

        mainScene = new Scene(layout, 500, 500);

        window.setScene(mainScene);
        window.setTitle("this is my first fx project");
        window.show();
    }

    @Override
    public void handle(Event event) {
        //btn.setText("moshe");
        Button backBtn = new Button("back");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(mainScene);
            }
        });
        VBox layout = new VBox(backBtn);
        Scene secondScene = new Scene(layout, 500, 500);
        window.setScene(secondScene);
    }
}
