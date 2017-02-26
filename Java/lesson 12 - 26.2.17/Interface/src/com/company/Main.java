package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        for (int i = 0; i < animals.size(); i++){
            if (animals.get(i) instanceof EatInterface){
                EatInterface e = (EatInterface) animals.get(i);
                e.eat();
            }
        }

    }
}
