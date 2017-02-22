package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Client {

    private static int counter;

    private  int id;
    private String name;
    private String phone;
    private boolean ads;
    private ArrayList<Animal> pets;

    public Client(String name, String phone){
        this.name = name;
        this.phone = phone;
        ads = true;
        pets = new ArrayList<>();
        id = ++counter;
    }

    public String getName(){
        return name;
    }

    public boolean hasDog(){
        for (int i = 0; i < pets.size(); i++){
            if (pets.get(i) instanceof Dog){
                return true;
            }
        }
        return false;
    }

    public boolean isOwner(int animalID){
        for (int i = 0; i < pets.size(); i++){
            if (pets.get(i).getID() == animalID){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + ", " + id;
    }
}
