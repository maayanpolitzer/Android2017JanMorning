package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class Project implements TaskCompletedListener {

    private String name;
    private Task[] tasks;
    private int counter;

    public Project(String name, Task[] tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public void startProject() {
        System.out.println("Project " + name + " started!");
        startNextTask();
    }

    @Override
    public void startNextTask() {
        if (counter < tasks.length) {
            tasks[counter++].startTask(this);
        }else{
            done();
        }
    }

    public void done() {
        System.out.println("Project " + name + " is done");
    }

}
