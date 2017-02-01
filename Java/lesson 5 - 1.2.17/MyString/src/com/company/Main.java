package com.company;

public class Main {

    public static void main(String[] args) {

        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        MyString myString = new MyString(chars);
        //System.out.println(myString.length());    // 11;

        myString.print();   // Hello World

        System.out.println(myString.indexOf('o'));  // 8;

        System.out.println(myString.sameCharsCount('l'));   // 3

        printArr(myString.indexesOf('l'));

        System.out.println(myString.charAt(4)); // 'o'

        System.out.println(myString.isEmpty()); // false

        System.out.println(myString.contains('y'));     // false

        MyString x = myString.subString(5);
        x.print();

        // HOME WORK:

        MyString x2 = myString.replace('l', 'v');
        x2.print();

        MyString x3 = myString.subString(2,4);
        x3.print();

        // hard!!
        MyString[] arrX = myString.split('o');

        for (int i = 0; i < arrX.length; i++){
            arrX[i].print();
        }

    }

    private static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
