package com.company;

public class Main {

    public static void main(String[] args) {

        Vet hospital = new Vet();

        hospital.addNewClient(new Client("Maayan", "034522"));
        hospital.addNewClient(new Client("Yossi", "234345"));

        hospital.sendAd("5% off");  // message: "5% off" send to Maayan
        hospital.hospitalizedAnimal(4);// hopitalize the animal find owner.

        hospital.vaccinDogs("Come to vaciin your dog!");

        hospital.printClients();

    }
}
