import com.command.*;
import com.file.FileWorking;
import com.food.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    List<Food> veg = new ArrayList<>();


    public void Selection() throws IOException {
        Database menu = new Database();

        Database developer = new Database(
                new SalatFileCommand(menu),
                new HelpCommand(menu),
                new ExitCommand(menu)
        );

        veg = Default(veg);
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
                    \t\t\t3.Read list of salats from file
                    \t\t\t4.Help
                    \t\t\t5.Exit
                    """);
            System.out.print("\t\tSelect: ");
            var = scanner.nextInt();
            while (var <=0 || var > 5){
                System.out.print("\t\tSelect: ");
                var = scanner.nextInt();
            }

            /*
            Submenu
             */
            if(var == 5){ //exit
                developer.exit();
            }
            else if (var == 1) { //Open submenu Food
                /*
                Submenu for food and his operations
                */
                var = 0;
                System.out.println("""

                        \t\t\tFood
                        \t\t\t\t1.Show list
                        \t\t\t\t2.Add new food
                        \t\t\t\t3.Remove one
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
                    WholeFood.VegList(veg);
                }
                else if (var == 2) {
                    veg = WholeFood.AddFood(veg);
                }
                else {
                    veg = WholeFood.FoodRemove(veg);
                }

            }
            else if (var == 2) { //Open submenu Salat
                         /*
                 Submenu for salats and his operations
                 */
                System.out.println("""

                        \t\t\tSalat
                        \t\t\t\t1.Create
                        \t\t\t\t2.Sort
                        \t\t\t\t3.Find by parameter(calories)
                        \t\t\t\t4.Cancel
                        """);
                var=1;
                System.out.print("\t\t\tSelect: ");
        var = scanner.nextInt();
                while (var <= 0 || var > 4) {
                    System.out.print("\t\t\tSelect: ");
            var = scanner.nextInt();
                }
                if (var == 4) {
                    continue;
                } else if (var == 1) {
                    sal = new Salat(WholeFood.FoodSelect(veg));
                    System.out.println(sal.toString());
                    FileWorking.FileWriting(sal.toString());
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
            else if (var == 3) { //Open Submenu SalatFile
                developer.salatFile();
            }
            else {          //Open Submenu Help
                developer.help();
            }
        }
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

}