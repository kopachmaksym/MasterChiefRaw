package com.food;

public class Food {
    /*
    Class with name of food
    */
    protected String name;

    Food(String nm){
        name = nm;
    }

    public String getName(){
        return name;
    }

    public double getCalorie(){
        return 0;
    }

    public String toString(){
        return "";
    }

}
