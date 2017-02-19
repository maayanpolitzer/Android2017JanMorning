package com.company;

public class Main {

    public static void main(String[] args) {

        String[] arr = null;
        try {
            arr[2] = "Maayan";
            arr[17] = "Moshe";
            /*
        }catch(ArrayIndexOutOfBoundsException error){
            System.out.println(error);
        }catch(NullPointerException error){
            System.out.println(error);
        }
        */
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("done");
        }




    }
}
