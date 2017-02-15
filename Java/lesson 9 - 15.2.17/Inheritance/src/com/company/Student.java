package com.company;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Student extends Person {

    private int classRoom;

    public Student(String name){
        super(name);
        classRoom = 56;
    }

    public int getClassRoom(){
        return classRoom;
    }

    @Override
    public String toString() {
        return "Student!" + super.toString();
    }
}
