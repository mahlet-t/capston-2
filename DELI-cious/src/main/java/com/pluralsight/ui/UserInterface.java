package com.pluralsight.ui;

import com.pluralsight.models.Order;
import com.pluralsight.models.Topping;
import com.pluralsight.util.Utility;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public Scanner input = new Scanner(System.in);

    public UserInterface(Scanner input) {
        this.input = input;
    }

    public void displayHomeScreen() {
        Utility.printTitle("Welcome ");
        System.out.println("What you want to do");
        System.out.println("1) new order");
        System.out.println("0) Exit");
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1 -> displayOrderScreen();
            case 0 -> {
                Utility.loadingMessage("Exiting....");
                System.out.println("Good bye ");
                Utility.clearScreen();
            }
        }


    }

    public void displayOrderScreen() {
        while (true) {
            Order order = new Order();
            System.out.println("choose from the following");
            System.out.println("1) Add sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1 -> order.addSandwich();
                case 2 -> order.addDrink();
                case 3 -> order.addChips();

            }
        }
    }

    public String promptForBreadType() {
        System.out.println("what type of bread do you want");
        System.out.println("White Bread");
        System.out.println("Wheat Bread");
        System.out.println("Rye Bread");
        System.out.println("Wrap ");
        return input.nextLine();

    }

    public int promptForSize() {
        System.out.println("what size do you want 4,8 or 12 inches");
        int size = input.nextInt();
        input.nextLine();
        return size;


    }

    public String promptForToasted() {
        System.out.println(" would you like it toasted(yes or no )");
        return input.nextLine();
    }
    public List<Topping> promptForMeats(int size) {
        List<Topping> meats=new ArrayList<>();
        while (true) {
            System.out.println("What type of meat do you want ");
            System.out.println("Choose from the list of meat");
            System.out.println(" or type done to finish");
            System.out.println(".Steak\n.Ham\n.Salami\n.Roast Beef\n.Chicken\n.Bacon");
            String listOfMeat = input.nextLine();
            if (listOfMeat.equalsIgnoreCase("done")) {
                Utility.loadingMessage("Exiting...");
                break;
            }

            System.out.println("you want Extra Meat");
            String extras = input.nextLine();
            boolean isExtra=false;
            if (extras.equalsIgnoreCase("yes")) {
                isExtra = true;

            } else if (extras.equalsIgnoreCase("No")) {
              isExtra=false;

            } else {
                System.err.println("Invalid input ");
            }

            Topping topping = new Topping(listOfMeat,"Meat", isExtra, size);
            meats.add(topping);
        }
return meats;
    }
    public List<Topping> promptForCheese(int size){
        List<Topping> cheese=new ArrayList<>();
        while (true) {
            boolean isExtra=false;
            System.out.println("What type of cheese do you want ");
            System.out.println("American\nProvolone\nCheddar\nSwiss");
            System.out.println("or type done to finish");
            String listOfCheese = input.nextLine();
            if (listOfCheese.equalsIgnoreCase("done"))
                break;
            System.out.println("would you like Extra Cheese(yes or no)");
            String extra=input.nextLine();
            if (extra.equalsIgnoreCase("Yes")){
                isExtra=true;
            } else if (extra.equalsIgnoreCase("No")) {
                isExtra=false;

            }
            Topping topping=new Topping("Cheese",listOfCheese,isExtra,size);
            cheese.add(topping);


        }
        return cheese;


    }
    public List<Topping> promptForRegularToppings(int size){
        List<Topping> regular=new ArrayList<>();
        while (true) {

            System.out.println("Add Toppings");
            System.out.println("or type done to finish ");
            System.out.printf("Lettuce %s10", "Peppers");
            System.out.printf("Onions %s10", "Tomatoes");
            System.out.printf("Jalapenos %s10", "Cucumbers");
            System.out.printf(" Pickles %s10 ", "Guacamole %s10");
            System.out.println("Mushrooms");
            String regularTopping = input.nextLine();
            if (regularTopping.equalsIgnoreCase("done")){
                break;
            }
            Topping topping=new Topping(regularTopping,"Regular",false,size);
            regular.add(topping);

        }
        return regular;
    }
    public List<Topping> promptForSauces()

}
