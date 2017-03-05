package com.company;

public class Main {

    private static int[] arr = {-8, -2, -4, -3};
    private static int runs = 0;

    public static void main(String[] args) {

        int maxSoFar = arr[0];

        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int currentSum = sum(i,j+1);
                if (currentSum > maxSoFar){
                    maxSoFar = currentSum;
                }
            }
        }
        System.out.println("Max sum in arr is: " + maxSoFar + " (" + runs + " runs)");
    }

    private static int sum(int start, int end){
        int counter = 0;
        for (int i = start; i < end; i++){
            runs++;
            counter += arr[i];
        }
        return counter;
    }

}
