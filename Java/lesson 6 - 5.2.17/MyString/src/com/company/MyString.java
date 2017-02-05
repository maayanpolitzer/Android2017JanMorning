package com.company;

/**
 * Created by hackeru on 01/02/2017.
 */
public class MyString {

    private char[] chars;

    public MyString(char[] letters){
        chars = letters;
    }

    public int length(){
        return chars.length;
    }

    public void print(){
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public int indexOf(char c){
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return i;
            }
        }
        return -1;
    }

    public int sameCharsCount(char c){
        int counter = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                counter++;
            }
        }
        return counter;
    }

    public int[] indexesOf(char c){
        int[] arr = new int[sameCharsCount(c)];
        int x = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                arr[x++] = i;
            }
        }
        return arr;
    }

    public char charAt(int index){
        if (index < 0 || index >= chars.length){
            return '@';
        }else{
            return chars[index];
        }
    }

    public boolean isEmpty(){
        return chars.length == 0;
        /*
        if (chars.length == 0){
            return true;
        }
        return false;

        */
    }


    public boolean contains(char c){
        return indexOf(c) != -1;
        /*
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return true;
            }
        }
        return false;
        */
    }

    public MyString subString(int number){
        if (number < 0 || number >= chars.length){
            return null;
        }
        char[] myChars = new char[chars.length - number];
        for (int i = number; i < chars.length; i++){
            myChars[i - number] = chars[i];
        }
        return new MyString(myChars);
    }

    public MyString replace(char original, char newChar) {
        char[] c = new char[chars.length];
        for (int i = 0; i < c.length; i++){
            if (chars[i] == original){
                c[i] = newChar;
            }else {
                c[i] = chars[i];
            }
        }
        return new MyString(c);
    }

    public MyString subString(int start, int end) {
        if (start >= 0 && start <= end && end <= chars.length) {
            char[] c = new char[end - start];
            int counter = 0;
            for (int i = start; i < end; i++) {
                c[counter++] = chars[i];
            }
        /*
        for (int i = start; i < end; i++) {
            c[i - start] = chars[i];
        }
        */
            return new MyString(c);
        }
        return null;
    }

    public MyString[] split(char c){
        int counter = sameCharsCount(c);
        if (counter > 0) {
            int start = 0;
            MyString[] arr = new MyString[counter + 1];
            int[] charPosition = indexesOf(c);
            for (int i = 0; i < charPosition.length; i++){
                arr[i] = subString(start, charPosition[i]);
                start = charPosition[i]+1;
            }
            arr[arr.length - 1] = subString(start);
            return arr;
        }
        return null;
    }

    public MyString toUpperCase(){
        char[] c = new char[chars.length];
        for (int i = 0; i < c.length; i++){
            if(chars[i] >= 97 && chars[i] <= 122){
                c[i] = (char) (chars[i] - 32);  // casting...
            }else{
                c[i] = chars[i];
            }
        }
        return new MyString(c);
    }

}
