package com.company;

/**
 * Created by hackeru on 05/02/2017.
 */
public class Hall {

    private String movie;
    private boolean[] seats;

    public Hall(int numberOfSeats, String movieName) {
        movie = movieName;
        seats = new boolean[numberOfSeats]; // default{false, false, false, false...}
    }

    public int buyTicket(){
        for (int i = 0; i < seats.length; i++){
            if(!seats[i]) {     //same as: if(seats[i] == false){
                seats[i] = true;
                return i;
            }
        }
        return -1;
    }

    public boolean buyTicket(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length){
            return false;
        }
        if (!seats[seatNumber]) {
            seats[seatNumber] = true;
            return true;
        }
        return false;
    }

    public boolean cancelTicket(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length){
            return false;
        }
        if (seats[seatNumber]) {
            seats[seatNumber] = false;
            return true;
        }
        return false;
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i]);
            if (i < seats.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int buyGroup(int numberOfSeats){
        if (numberOfSeats <= 0 || numberOfSeats > seats.length){
            return -1;
        }
        for (int i = 0; i <= seats.length - numberOfSeats; i++) {
            if (!seats[i]){
                int availableSeatsInRow = checkSeatsInRow(i, numberOfSeats);
                if (availableSeatsInRow == numberOfSeats){
                    buySeats(i, numberOfSeats);
                    return i;
                }else{
                    i += availableSeatsInRow;
                }
            }
        }
        return -1;
    }

    private int checkSeatsInRow(int fromIndex, int seatsAmount){
        int counter = 1;
        for (int i = fromIndex + 1; i < fromIndex + seatsAmount; i++){
            if (!seats[i]){
                counter++;
            }else{
                return counter;
            }
        }
        return counter;
    }

    private void buySeats(int fromIndex, int seatsAmount){
        for (int i = fromIndex; i < fromIndex + seatsAmount; i++){
            seats[i] = true;
        }
    }

}
