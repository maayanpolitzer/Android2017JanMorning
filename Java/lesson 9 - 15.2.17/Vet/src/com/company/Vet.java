package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 15/02/2017.
*/
public class Vet {

    private ArrayList<Client> clients;

    public Vet(){
        clients = new ArrayList<>();
    }

    public void addNewClient(Client newClient){
        clients.add(newClient);
    }

    public void printClients(){
        System.out.println(clients);
    }
}
