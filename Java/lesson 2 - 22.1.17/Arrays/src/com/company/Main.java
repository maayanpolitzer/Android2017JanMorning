package com.company;

public class Main {

    public static void main(String[] args) {

        int[] studentsGradesA = {-5,-56,-1,-5, 4};   // length=5;

        int[] studentsGradesC = new int[2];          // length=2;

        int k;  // default value of int is 0;


        // java array length CANNOT BE CHANGED!!!

        //System.out.println(studentsGradesA[5]);       // get array cell value by index.
        //System.out.println(studentsGradesA.length);   // get the array length (how many cells).
        //studentsGradesA[3] = 67;                      // change cell value.


        //printArray(studentsGradesA);

        //printArrayWithFactor(studentsGradesA, 2);

        //int myAverage = average(studentsGradesA);
        //System.out.println(myAverage);

        //int[] tempArr = createArr(4,32);
        //printArray(tempArr);

        //int times = howManyTimesInArr(studentsGradesA, 90);
        //System.out.println(times);

        //int max = getMax(studentsGradesA);
        //System.out.println(max);

        int[] studentsGradesB = new int[]{40,50,49}; // length=3;
        /*
        boolean b = isNumberInArray(studentsGradesB, 60);
        System.out.println(b);
        */
        /*
        boolean order = isOrdered(studentsGradesB);
        System.out.println(order);
        */

        /*
        boolean c = isLastNumberPositive(studentsGradesB);
        System.out.println(c);
        */

        //HOMEWORK:
        int sum = sumOfOddsIndex(studentsGradesB);
        System.out.println(sum);

        int[] reverse = flipArray(studentsGradesB);
        printArray(reverse);

        int[] largeArr = doubleMyArray(studentsGradesA);
        printArray(largeArr);

    }

    public static boolean isLastNumberPositive(int[] arr){
        return arr[arr.length - 1] > 0;
        /*
        if (arr[arr.length - 1] > 0){
            return true;
        }
        return false;
        */
    }

    public static boolean isOrdered(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberInArray(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                return true;
            }
        }
        return false;

        //return howManyTimesInArr(arr, number) > 0;    // NOT ALWAYS BETTER!!!!!
    }

    public static int getMax(int[] maayan){
        if (maayan.length > 0) {
            int max = maayan[0];
            for (int i = 1; i < maayan.length; i++) {
                if (maayan[i] > max) {
                    max = maayan[i];
                }
            }
            return max;
        }else{
            return -1;
        }
    }

    public static int howManyTimesInArr(int[] arr, int number){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                counter++;
            }
        }
        return counter;
    }

    public static int[] createArr(int length, int value){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            arr[i] = value;
        }
        return arr;
    }

    public static int average(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void printArrayWithFactor(int[] arr, int factor){
        for (int i = 0; i < arr.length; i++){
            int newGrade = arr[i] + factor;
            if (newGrade > 100){
                System.out.println(100);
            }else {
                System.out.println(newGrade);
            }
        }
    }



}
