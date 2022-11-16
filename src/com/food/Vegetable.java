package com.food;
public class Vegetable extends Food {
    /*
    Subclass with type Vegetable
    */
    private final double calorie;
    private final String type = "Vegetable";

    public Vegetable(String nm, double kcal) {
        super(nm);
        calorie = kcal;
    }

    public double getCalorie(){
        return calorie;
    }

    public String toString(){
        return String.format("\t\tVegetable: %s\n\t\tCalorie: %.1f kcal/100g\n\t\tType: %s\n\n", name, calorie, type);
    }

}
