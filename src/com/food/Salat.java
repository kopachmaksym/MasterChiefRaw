package com.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Salat {
    private final Scanner scanner = new Scanner(System.in);
    private final String salat;
    private final List<String> veg = new ArrayList<>();
    private final List<Double> mass = new ArrayList<>();
    private final List<Double> calories = new ArrayList<>();

    public Salat(List<Food> select){
        /*
        Constructor
         */
        scanner.useLocale(Locale.US);
        System.out.print("Insert the name of the salat: ");
        salat = scanner.next();
        for (int i=0;i<select.size();i++){
            veg.add(select.get(i).getName());
            System.out.print("\nEnter the weight of the " + veg.get(i) + ": ");
            mass.add((double) scanner.nextFloat());
            calories.add((select.get(i).getCalorie()*(mass.get(mass.size()-1)*10)));
        }
    }

    public void CalRange(){
        /*
        Finding food with needed calories from salat
         */
        int j=1;
        double more, less;
        System.out.print("\tEnter the range:\n\t\tMore: ");
        more = scanner.nextFloat();
        System.out.print("\t\tLess: ");
        less = scanner.nextFloat();
        System.out.printf("%s's food in range > %.1f and < %.1f%n",salat,more,less);
        for (int i=0;i<veg.size();i++){
            if(calories.get(i)>more && calories.get(i)< less){
                System.out.printf("\t\t%d. %s - %.1fkcal%n",j,veg.get(i),calories.get(i));
                j++;
            }
        }
    }

    public String toString(){

        /*
        Method of returning salat's data
         */

        double ms = 0, cl = 0;
        String text = String.format("\n\tName: %s\n",salat);
        String add ="\n\tFood in salat:\n";
        for (int i =0;i<veg.size();i++){
            ms += mass.get(i);
            cl += calories.get(i);
            add += String.format("\t\t%d. %s (%.3fkg, %.1fkcal)\n",(i+1), veg.get(i),mass.get(i),calories.get(i));
        }
        text += String.format("\tWeight: %.3fkg\n\tCalories: %.1fkcal",ms,cl);
        text += add;
        text += "\n";
        return text;
    }

    public void bubbleSort(int var){
        /*
        Sorting methods
         */
        Double[] sortarr = new Double[mass.size()];
        Double[] addsort = new Double[calories.size()];
        String[] veget = new String[veg.size()];
        sortarr = mass.toArray(sortarr);
        addsort = calories.toArray(addsort);
        veget = veg.toArray(veget);
        int len = sortarr.length;

        switch (var){
            case (1):
                for (int i=0;i<len-1;++i){

                    for(int j=0;j<len-i-1; ++j){

                        if(sortarr[j+1]<sortarr[j]){

                            Double swap = sortarr[j];
                            sortarr[j] = sortarr[j+1];
                            sortarr[j+1] = swap;

                            swap = addsort[j];
                            addsort[j] = addsort[j+1];
                            addsort[j+1] = swap;

                            String sw = veget[j];
                            veget[j] = veget[j+1];
                            veget[j+1] = sw;

                        }
                    }
                }
            case (2):
                for (int i=0;i<len-1;++i){

                    for(int j=0;j<len-i-1; ++j){

                        if(addsort[j+1]<addsort[j]){

                            Double swap = sortarr[j];
                            sortarr[j] = sortarr[j+1];
                            sortarr[j+1] = swap;

                            swap = addsort[j];
                            addsort[j] = addsort[j+1];
                            addsort[j+1] = swap;

                            String sw = veget[j];
                            veget[j] = veget[j+1];
                            veget[j+1] = sw;
                        }
                    }
                }
        }

        double ms = 0, cl = 0;
        String text = String.format("\n\tName: %s\n",salat);
        String add ="\n\tFood in salat:\n";
        for (int i =0;i<veget.length;i++){
            ms += sortarr[i];
            cl += addsort[i];
            add += String.format("\t\t%d. %s (%.3fkg, %.1fkcal)\n",(i+1), veget[i],sortarr[i],addsort[i]);
        }
        text += String.format("\tWeight: %.3fkg\n\tCalories: %.1fkcal",ms,cl);
        text += add;
        text += "\n";
        System.out.println(text);

    }

}
