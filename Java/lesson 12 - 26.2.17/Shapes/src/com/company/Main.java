package com.company;

public class Main {

    private static boolean[][] canvas = new boolean[11][14];

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(8, 5, 2, 5);
        r1.draw(canvas);
        Rectangle r2 = new Rectangle(8, 8, 0, 0);
        r2.draw(canvas);

        render();

    }

    private static void render(){
        for (int i = 0; i < canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++){
                System.out.print(canvas[i][j] ? "* " : "  ");
                /*
                if (canvas[i][j]){
                    System.out.print("* ");
                }else{
                    System.out.print("- ");
                }
                */
            }
            System.out.println();
        }
    }

}
