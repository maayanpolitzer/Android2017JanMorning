package com.company;

/**
 * Created by hackeru on 12/02/2017.
 */
public class Cage {

    private static final int MAX_CAPACITY = 5;
    private int animalsInside;
    private Animal[] animals;
    private boolean aquatic;
    private boolean predator;

    public Cage(boolean aquatic){
        this.aquatic = aquatic;
        animals = new Animal[MAX_CAPACITY];
    }

    public void addAnimalToCage(Animal animal){
        if (animalsInside == 0){
            predator = animal.isPredator();
        }
        animals[animalsInside++] = animal;
    }

    public void printCage(){
        System.out.print("Cage aquatic: " + aquatic + ", predator: " + predator + " [");
        for (int i = 0; i < animalsInside; i++){
            System.out.print(animals[i].getName());
            if (i < animalsInside - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public boolean isAquatic(){
        return aquatic;
    }

    public boolean isFull(){
        return animalsInside == MAX_CAPACITY;
    }

    public boolean isPredator(){
        return predator;
    }

    public boolean isEmpty(){
        return animalsInside == 0;
    }

    public Animal getFirstAnimal(){
        return animals[0];
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }
}
