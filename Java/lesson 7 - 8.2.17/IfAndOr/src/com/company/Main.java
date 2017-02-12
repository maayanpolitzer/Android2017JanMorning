package com.company;

public class Main {

    public static void main(String[] args) {

        String msg = null;

        if(msg.equals("x") || msg == null){
            msg = "YEY!!!";
        }
        System.out.println(msg);

    }

    /*
    1. msg == null || msg.equals("x")
    2. msg.equals("x") || msg == null
    3. "x".equals(msg) || msg == null
     */
}
