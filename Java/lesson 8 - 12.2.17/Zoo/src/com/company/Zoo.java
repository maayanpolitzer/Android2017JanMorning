package com.company;

/**
 * Created by hackeru on 12/02/2017.
 */
public class Zoo {

    private String manager;
    private String address;
    private Cage[] cages;

    public Zoo(String manager, String address, int landCages, int aquariums){
        this.manager = manager;
        this.address = address;
        cages = new Cage[landCages + aquariums];
        for (int i = 0; i < cages.length ; i++) {
            if (i < landCages) {
                cages[i] = new Cage(false);
            }else{
                cages[i] = new Cage(true);
            }
        }
    }

    public boolean insertAnimal(Animal animal){
        for (int i = 0; i < cages.length; i++){
            if (cages[i].isAquatic() == animal.isAquatic() &&
                    !cages[i].isFull() &&
                    (cages[i].isEmpty() ||
                    (!animal.isPredator() && !cages[i].isPredator()) ||
                    (animal.isPredator() && cages[i].isPredator() && animal.getName().equals(cages[i].getFirstAnimal().getName())))){
                cages[i].addAnimalToCage(animal);
                return true;
            }
        }
        System.out.println("No place for "  + animal.getName());
        return false;
    }

    public void printZoo(){
        for (int i = 0; i < cages.length; i++){
            cages[i].printCage();
        }
    }

}
