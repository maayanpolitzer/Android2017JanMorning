package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public abstract class Shape {

    private String name;

    public Shape(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void draw(boolean[][] canvas);

}
