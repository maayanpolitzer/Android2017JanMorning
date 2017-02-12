package com.company;

import java.util.Random;

public class Main {

    private static Animal[] animals = {
            new Animal("Lion", false, true),
            new Animal("Tiger", false, true),
            new Animal("Gold fish", true, false),
            new Animal("Piranea", true, true),
            new Animal("shark", true, true),
            new Animal("Star fish", true, false),
            new Animal("Giraffe", false, false),
            new Animal("Sheep", false, false),
            new Animal("Deer", false, false)
    };

    private static Random random = new Random();

    public static void main(String[] args) {

        Zoo zoo = new Zoo("Maayan", "Ramat gan", 10, 10);
        for (int i = 0; i < 100; i++){
            zoo.insertAnimal(animals[random.nextInt(animals.length)]);
        }
        zoo.printZoo();

    }
}
