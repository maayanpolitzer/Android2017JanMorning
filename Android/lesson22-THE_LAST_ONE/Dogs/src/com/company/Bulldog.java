package com.company;

/**
 * Created by hackeru on 6/7/2017.
 */
public class Bulldog extends Dog {

    public Bulldog(){
        super("Bulldog", 5);
    }

    @Override
    public void setId(int id) {
        //super.setId(id*2);
        this.id = id;
    }

    @Override
    public int getId() {
        return 0;
    }
}
