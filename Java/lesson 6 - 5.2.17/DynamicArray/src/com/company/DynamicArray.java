package com.company;

/**
 * Created by hackeru on 05/02/2017.
 */
public class DynamicArray {

    private String[] arr;
    private int counter;
    private static int grow = 2;

    public DynamicArray(){  // default constructor
        arr = new String[10];
        counter = 0;
    }

    public void add(String str){
        if (counter == arr.length){
            makeRoom();
        }
        arr[counter++] = str;
    }



    private void makeRoom(){
        String[] newArr = new String[grow * arr.length];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int size(){
        return counter;
    }

    public String get(int index){
        if (index >= 0 && index < counter){
            return arr[index];
        }
        return null;
    }


    public void print(){
        System.out.print("[");
        for (int i = 0; i < counter; i++){
            System.out.print(arr[i]);
            if (i < counter - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
