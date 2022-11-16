package com.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WholeFood {
    static Scanner scanner = new Scanner(System.in);
    public static void VegList(List<Food> list){
        /*
        List of food
         */
        for(int i=0;i<list.size();i++){
            System.out.printf("\n\t%d.\n%s%n",i+1,list.get(i).toString());
        }
    }

    public static List<Food> AddFood(List<Food> veg){
        /*
        Add new food to List
         */
        scanner.useLocale(Locale.US);
        String name;
        double cal;
        int type;
        do {
            System.out.print("\nInsert the name of food: ");
            name = scanner.next();
            System.out.print("\nInsert the calories in 100 gramm: ");
            cal = scanner.nextFloat();
            System.out.print("\nInsert the type of food(fruit(1), vegetable(2), topping(3)): ");
            type = scanner.nextInt();

            switch (type){
                case (1): veg.add(new Fruit(name, cal));
                case (2): veg.add(new Vegetable(name, cal));
                case (3): veg.add(new Topping(name, cal));
            }
            System.out.println("\nAdd another one(Y/N): ");
            name = scanner.next();
            while (!name.equals("Y") && !name.equals("N")) {
                System.out.println("\nAdd another one(Y/N): ");
                name = scanner.next();
            }

        } while (!name.equals("N"));
        return veg;
    }

    public static List<Food> FoodSelect(List<Food> veg){
        /*
        Creating salat from vegetables
         */
        List<Food> choise = veg;
        List<Food> select = new ArrayList<>();
        System.out.println("List of not selected food: ");

        do {
            VegList(choise);
            System.out.print("\n\t\tList of selected food(insert '0' to complete the operation): ");
            for (Food food : select) {
                System.out.print(food.getName() + " ");
            }
            System.out.print("\n\n\tSelect: ");
            int var = scanner.nextInt();
            while (var > choise.size() && var < 0) {
                System.out.print("\tSelect: ");
                var = scanner.nextInt();
            }
            if (var == 0) {
                break;
            }
            select.add(choise.get((var - 1)));
            choise.remove((var - 1));
            System.out.println();


        } while (choise.size() != 0);
        return select;
    }

    public static List<Food> FoodRemove(List<Food> veg){
        /*
        Remove vegetable from List
         */
        VegList(veg);
        System.out.print("Select: ");
        int var = scanner.nextInt();
        while(var <= 0 && var > veg.size()){
            System.out.print("Select: ");
            var = scanner.nextInt();
        }
        veg.remove((var-1));
        return veg;
    }

}
