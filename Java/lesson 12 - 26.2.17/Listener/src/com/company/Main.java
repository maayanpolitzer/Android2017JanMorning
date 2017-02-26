package com.company;

public class Main {

    public static void main(String[] args) {

        Task[] tasks = new Task[3];

        tasks[0] = new Task("boil", 8);
        tasks[1] = new Task("Smash", 5);
        tasks[2] = new Task("mix", 7);

        Project p1 = new Project("gnocchi", tasks);
        p1.startProject();
    }
}
