package com.example.hackeru.memorygame;

/**
 * Created by hackeru on 26/03/2017.
 */

public class Level {

    private int rows;
    private int cols;

    public Level(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumberOfCards(){
        return rows * cols;
    }
}
