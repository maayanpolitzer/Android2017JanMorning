package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 15/02/2017.
*/
public class Vet {

    private static final int CAPACITY = 8;
    private ArrayList<Client> clients;
    private int animalsHospitalized;
    private Animal[] beds;

    public Vet(){
        clients = new ArrayList<>();
        beds = new Animal[CAPACITY];
    }

    public void vaccinDogs(String message){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).hasDog()){
                System.out.println(clients.get(i).getName() + " " + message);
            }
        }
    }

    public void hospitalizedAnimal(int animalID) {
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).isOwner(animalID)){
                System.out.println(clients.get(i).getName() + " your animal was almost died!!!! come fast");
                if(){
                   //beds[animalsHospitalized++] =
                }else{

                }
                return;
            }
        }
    }


    public void addNewClient(Client newClient){
        clients.add(newClient);
    }

    public void printClients(){
        System.out.println(clients);
    }


}
