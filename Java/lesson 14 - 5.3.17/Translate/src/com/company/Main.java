package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements EventHandler<ActionEvent>, OnDelayEndListener {

    private Button btn;
    private boolean working;
    private TextField firstTF;
    private TextField secondTF;
    private Word[] words;
    private int counter;
    private Thread timingThread;

    public static void main(String[] args) {
	    launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        words = new Word[]{
                new Word("כלב", "Dog"),
                new Word("יום", "Day"),
                new Word("חתול", "Cat"),
                new Word("לילה", "Night")
        };
        firstTF = new TextField();
        secondTF = new TextField();
        btn = new Button("START");
        btn.setOnAction(this);
        VBox layout = new VBox(20, firstTF, secondTF, btn);
        Scene mainScene = new Scene(layout, 500, 500);
        window.setScene(mainScene);

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (timingThread != null) {
                    working = false;
                    timingThread.interrupt();
                }
            }
        });
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (working){
            // stop!!!!
            stopTranslate();
        }else{
            // start!!!
            startTranslate();
        }
    }

    private void stopTranslate(){
        working = false;
        btn.setText("START");
        timingThread.interrupt();
        timingThread = null;    // for the MEHADRIN...
    }

    @Override
    public void changeWords(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (counter == words.length){
                    counter = 0;
                }
                firstTF.setText(words[counter].getEng());
                secondTF.setText(words[counter].getHeb());
                counter++;
            }
        });
    }

    private void startTranslate(){
        working = true;
        btn.setText("STOP");

        timingThread = new TimingThread(this);
        timingThread.start();
    }

    @Override
    public boolean isWorking(){
        return working;
    }

}
