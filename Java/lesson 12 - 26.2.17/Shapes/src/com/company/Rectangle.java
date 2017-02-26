package com.company;

/**
 * Created by hackeru on 26/02/2017.
 */
public class Rectangle extends Shape {

    private int width;
    private int height;
    private int marginTop;
    private int marginLeft;

    public Rectangle(int width, int height, int marginLeft, int marginTop){
        super("Rectangle");
        this.width = width;
        this.height = height;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    @Override
    public void draw(boolean[][] canvas) {
        for (int i = marginLeft; i < width + marginLeft; i++){
            canvas[marginTop][i] = true;
            canvas[height + marginTop -1][i] = true;
        }
        for (int i = marginTop; i < height + marginTop; i++){
            canvas[i][marginLeft] = true;
            canvas[i][width + marginLeft -1] = true;
        }
    }
}
