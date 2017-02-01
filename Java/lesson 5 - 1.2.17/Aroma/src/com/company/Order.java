package com.company;

/**
 * Created by hackeru on 01/02/2017.
 */
public class Order {

   private Products[] products;


    public Order(Products[] products){

        this.products = products;




    }

    public void printAllProducts(){
        System.out.println("costumer ordered:");
        for (int i = 0; i <products.length ; i++) {
            System.out.println(products[i].getName() + ": "+ products[i].getPrice()+" shekels");

        }
    }

    public double calculatePrice(){
double sum =0;
        for (int i = 0; i <products.length ; i++) {
            sum+= products[i].getPrice();
        }
        return sum;
    }



}
