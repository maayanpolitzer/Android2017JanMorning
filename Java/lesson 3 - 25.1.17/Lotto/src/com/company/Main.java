package com.company;


import java.util.Random;

public class Main {

    public static int[] myLotto = {1, 2, 3, 4, 5, 6};
    public static int myExtra = 6;

    public static int[] lotto = new int[6];  // 1-36
    public static int extra;    // 1-8

    public static Random random = new Random();

    /*************************/

    public static void main(String[] args) {

        generateLotto();
        printArray(lotto);
        int rightGuesses = checkLottery();
        //boolean guessExtra = checkExtra();
        boolean guessExtra = myExtra == extra;

        System.out.println("You guessed " + rightGuesses + " from 6 numbers");
        System.out.println(guessExtra);
    }

    public static int checkLottery(){
        int counter = 0;
        for (int i = 0; i < myLotto.length; i++){
            if (isNumberInLotto(myLotto[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isNumberInLotto(int number){
        for (int i = 0; i < lotto.length; i++){
            if (number == lotto[i]){
                return true;
            }
        }
        return false;
    }

    public static boolean checkExtra(){
        return myExtra == extra;
        /*
        if (myExtra == extra){
            return true;
        }else{
            return false;
        }
        */
    }

    public static void generateLotto(){
        for (int i = 0; i < lotto.length; i++){
            // TODO: 25/01/2017 check for duplicate values in array.
            int generatedNumber = giveMeRandomNumber(36);
            if(isNumberValid(generatedNumber, i)){
                lotto[i] = generatedNumber;
            }else{
                i--;
                System.out.println("DUPLICATED!!!! " + generatedNumber);
            }
        }
        extra = giveMeRandomNumber(8);
    }

    public static boolean isNumberValid(int number, int position){
        for (int i = 0; i < position; i++){
            if (number == lotto[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int giveMeRandomNumber(int max){
        return random.nextInt(max) + 1;
    }
}
