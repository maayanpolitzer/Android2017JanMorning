package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class Task {

    private String name;
    private int time;
    private TaskCompletedListener listener;

    public Task(String name, int time){
        this.name = name;
        this.time = time;
    }

    public void startTask(TaskCompletedListener listener){
        this.listener = listener;
        System.out.println("task " + name + " started");
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskComplete();
    }

    public void taskComplete(){
        System.out.println("task " + name + " is DONE");
        listener.startNextTask();
    }
}
