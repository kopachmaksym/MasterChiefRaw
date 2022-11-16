import com.food.*;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    List<Food> veg = new ArrayList<>();

    public Menu(){
        /*
        Constructor
         */
        veg = Default(veg);
    }

    private List<Food> Default(List<Food> veg){
        /*
        Default food for easier using (you don't need to create a lot of new food)
         */
        veg.add(new Vegetable("Tomato",17.7));
        veg.add(new Vegetable("Cucumber",15));
        veg.add(new Vegetable("Carrot",41.3));
        veg.add(new Fruit("Apple",52.1));
        veg.add(new Fruit("Peach",39));
        veg.add(new Topping("Olive Oil",884.1));
        veg.add(new Topping("Lemon Juice", 21.7));
        return veg;
    }

    public void Selection(){
        /*
        Main menu
         */
        Salat sal = null;
        System.out.println("\n\n\t\t\t\t\t\tMenu");
        int var;
        while(true){
            System.out.println("""

                    \t\t\t1.Food (show, add, remove)
                    \t\t\t2.Salat(show all, creation, sorting, calories ranging)
                    \t\t\t3.Read list of salats from file (Not Working)
                    \t\t\t4.Help (Not Working)
                    \t\t\t5.Exit
                    """);
            System.out.print("\t\tSelect: ");
            var = scanner.nextInt();
            while (var <=0 || var > 5){
                System.out.print("\t\tSelect: ");
                var = scanner.nextInt();
            }
            if(var == 5){
                break;
            }
            else if (var == 1) {
                        /*
                        Submenu for food and his operations
                        */
                System.out.println("""

                        \t\t\tFood
                        \t\t\t\t1.Show list
                        \t\t\t\t2.Add new food
                        \t\t\t\t3.Remove one(Not Working)
                        \t\t\t\t4.Cancel
                        """) ;
                System.out.print("\t\t\tSelect: ");
                var = scanner.nextInt();
                while (var <=0 || var > 4){
                    System.out.print("\t\t\tSelect: ");
                    var = scanner.nextInt();
                }
                if (var == 4){
                    continue;
                }
                else if (var == 1) {
                    VegList(veg);
                }
                else if (var == 2) {
                    veg = AddFood(veg);
                }
            }
            else if (var == 2) {
                        /*
                        Submenu for salats and his operations
                        */
                System.out.println("""

                        \t\t\tSalat
                        \t\t\t\t1.Create (Without Recording To File)
                        \t\t\t\t2.Sort
                        \t\t\t\t3.Find by parameter(calories)
                        \t\t\t\t4.Cancel
                        """);
                System.out.print("\t\t\tSelect: ");
                var = scanner.nextInt();
                while (var <= 0 || var > 4) {
                    System.out.print("\t\t\tSelect: ");
                    var = scanner.nextInt();
                }
                if (var == 4) {
                    continue;
                } else if (var == 1) {
                    sal = new Salat(FoodSelect());
                    System.out.println(sal.toString());
                } else if (var == 2) {
                    if (sal == null) {
                        System.out.println("You didn't make a salat. First, select the create option.");
                    } else {
                        System.out.print("Choose parameter of sorting (1)by mass (2)by calories: ");
                        var = scanner.nextInt();
                        while (var != 1 && var != 2) {
                            System.out.print("\t\t\tSelect: ");
                            var = scanner.nextInt();
                        }
                        sal.bubbleSort(var);
                    }
                } else {
                    if (sal == null) {
                        System.out.println("You didn't make a salat. First, select the create option.");
                    } else {
                        sal.CalRange();
                    }

                }
            }
            else if (var == 3) {
                        /*
                        Read file Salats.txt (it contains all saved salats)
                        */
            }
            else {
                        /*
                        Read file Help.txt (it contains documentation of using progmamme)
                        */
            }
        }
    }

    private void VegList(List<Food> list){
        /*
        List of food
         */
        for(int i=0;i<list.size();i++){
            System.out.printf("\n\t%d.\n%s%n",i+1,list.get(i).toString());
        }
    }

    private List<Food> AddFood(List<Food> veg){
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

    private List<Food> FoodSelect(){
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

}