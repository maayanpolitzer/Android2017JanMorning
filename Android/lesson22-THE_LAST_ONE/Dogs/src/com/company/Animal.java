package com.company;

/**
 * Created by hackeru on 6/7/2017.
 */
public abstract class Animal {

    protected String name;
    protected int id;
    protected int numOfLegs;

    public Animal(String name, int id, int numOfLegs){
        this.name = name;
        this.id = id;
        this.numOfLegs = numOfLegs;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", numOfLegs=" + numOfLegs +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getId();

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }
}
