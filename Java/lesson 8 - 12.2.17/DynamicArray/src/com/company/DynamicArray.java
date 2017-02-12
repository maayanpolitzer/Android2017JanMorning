package com.company;

/**
 * Created by hackeru on 05/02/2017.
 */
public class DynamicArray {

    private String[] arr;
    private int counter;
    private static int grow = 2;

    public DynamicArray() {  // default constructor
        arr = new String[10];
        counter = 0;
    }

    public void add(String str) {
        if (counter == arr.length) {
            makeRoom();
        }
        arr[counter++] = str;
    }

    public void add(int index, String str) {

        if (index < 0 || index >= counter) {
            return;
        }

        if (counter == arr.length) {
            makeRoom();
        }
        for (int i = counter; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        counter++;
        arr[index] = str;
        /*
        add("ldfgnldfn");
        for (int i = counter; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = str;
        */
    }

    private void makeRoom() {
        String[] newArr = new String[grow * arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int size() {
        return counter;
    }

    public String get(int index) {
        if (index >= 0 && index < counter) {
            return arr[index];
        }
        return null;
    }

    public void clear() {
        arr = new String[10];
        counter = 0;
    }

    public boolean contains(String str) {
        /*
        for (int i = 0; i < counter; i++){
            if (arr[i].equals(str)){
                return true;
            }
        }
        return false;
        */
        return indexOf(str) != -1;
    }

    public int indexOf(String str) {
        for (int i = 0; i < counter; i++) {
            if (arr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, String str) {
        /*
        if (index < 0 || index >= counter){
            return;
        }
        arr[index] = str;
        */
        if (index >= 0 && index < counter) {
            arr[index] = str;
        }
    }

    public void remove(String str) {
        /*
        for (int i = 0; i < counter; i++) {
            if (arr[i].equals(str)) {
                removeOne(i);
                i--;
            }
        }
        */
        /*
        while(contains(str)){
            for (int i = indexOf(str); i < counter; i++){
                arr[i] = arr[i+1];
            }
            counter--;
        }
        */
        if (!contains(str)){
            return;
        }
        int times = numberOfTimes(str);
        if(times == arr.length){
            // all the Strings are str
            clear();
            return;
        }
        for (int i = 0; i < times; i++){
            removeOne(indexOf(str));
        }
    }

    private int numberOfTimes(String str){
        int number = 0;
        for (int i = 0; i < counter; i++){
            if (arr[i].equals(str)){
                number++;
            }
        }
        return number;
    }

    private void removeOne(int index) {
        counter--;
        for (int i = index; i < counter; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < counter; i++) {
            System.out.print(arr[i]);
            if (i < counter - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] arr.length: " + arr.length);
    }

}
