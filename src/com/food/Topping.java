package com.food;
public class Topping extends Food {
    /*
    Subclass with type Topping
    */
    private final double calorie;
    private final String type = "Topping";

    public Topping(String nm, double kcal) {
        super(nm);
        calorie = kcal;
    }

    public double getCalorie(){
        return calorie;
    }

    public String toString(){
        return String.format("\t\tTopping: %s\n\t\tCalorie: %.1f kcal/100g\n\t\tType: %s\n\n", name, calorie, type);
    }

}