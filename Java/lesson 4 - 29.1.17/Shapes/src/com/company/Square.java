package com.company;

/**
 * Created by hackeru on 29/01/2017.
 */
public class Square {

    private int width;
    private int height;
    private int surface;    // surface = width * height

    public Square(int number, boolean isSurface){
        if (isSurface){ // isSurface == true;
            width = Math.sqrt(number);
            height = width;
            surface = number;
        }else{
            width = number;
            height = number;
            calculateSurface();
        }
    }



    public Square(int squareWidth, int squareHeight){
        width = squareWidth;
        height = squareHeight;
        calculateSurface();
    }

    private void calculateSurface(){
        surface = width * height;
    }

    public int getSurface(){
        return surface;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
