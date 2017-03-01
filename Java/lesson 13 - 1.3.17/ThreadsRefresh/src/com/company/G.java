package com.company;

/**
 * Created by hackeru on 01/03/2017.
 */
public class G extends Thread {



    public G(String name){
        setName(name);
    }

    private void getNumber(int number){
        System.out.println(number);
    }

    private void getFiles(){

    }

    private void getDir(){

    }

    @Override
    public void run() {
        getNumber(5);
        getFiles();
        getDir();
    }
}
