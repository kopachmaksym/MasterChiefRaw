package com.food;
public class Fruit extends Food {
    /*
    Subclass with type Fruit
    */
    private final double calorie;
    private final String type = "Fruit";

    public Fruit(String nm, double kcal) {
        super(nm);
        calorie = kcal;
    }

    public double getCalorie(){
        return calorie;
    }

    public String toString(){
        return String.format("\t\tFruit: %s\n\t\tCalorie: %.1f kcal/100g\n\t\tType: %s\n\n", name, calorie, type);
    }

}