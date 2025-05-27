package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import com.pluralsight.util.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public Scanner input = new Scanner(System.in);
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
            Sandwich sandwich=buildSandwich();
            String drinkSize=promptForDrinks();
            Drink drink=new Drink(drinkSize);
            Chips chips=new Chips();
            System.out.println("choose from the following");
            System.out.println("1) Add sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1 ->order.addSandwich(sandwich);
                case 2 ->order.addDrink(drink);
                case 3 -> order.addChips(chips);
                case 4->checkout();
                case 0-> Utility.loadingMessage("Exiting...");
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
            System.out.printf("%s10 %s10","Onions ", "Tomatoes");
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
    public List<Topping> promptForSauces(int size) {
        List<Topping> sauces = new ArrayList<>();
        while (true) {
            System.out.println("Add Sauces");
            System.out.println("Type done to finish");
            System.out.printf("%s-10 %s10", "Mayo", "Mustard");
            System.out.printf("%s-10 %s10", "Ketchup", "Ranch");
            System.out.printf("%s-10 %s10", "Thousand island", "Vinaigrette");
            String sauce = input.nextLine();
            if (sauce.equalsIgnoreCase("done")){
                break;
            }
            Topping topping = new Topping(sauce, "Sauces", false, size);
            sauces.add(topping);
        }
        return sauces;
    }
    public String promptForSides(){
        System.out.println("what sides do you want");
        System.out.println(".Au Jus\n .Sauce\n none");
      return input.nextLine();

    }
    String side=promptForSides();


   public String promptForDrinks(){
       System.out.println("what size do you want\n Small, Medium, Large");
      return input.nextLine();

   }
   // Add drink

   public Sandwich buildSandwich() {
       String bread = promptForBreadType();
       int size = promptForSize();
       boolean toasted = promptForToasted().equalsIgnoreCase("Yes");
       Sandwich sandwich = new Sandwich(bread, size, toasted);
       List<Topping> meats = promptForMeats(size);
       for (Topping meat : meats) {
           sandwich.addMeat(meat);
       }
       List<Topping> cheeses = promptForCheese(size);
       for (Topping cheese : cheeses) {
           sandwich.addCheese(cheese);
       }
       List<Topping> regularToppings = promptForRegularToppings(size);
       for (Topping regular : regularToppings) {
           sandwich.addTopping(regular);
       }
       List<Topping> sauces = promptForSauces(size);
       for (Topping sauce : sauces) {
           sandwich.addSauce(sauce);
       }
       return sandwich;
   }

   public void checkout(){
       Order order=new Order();
       order.getOrderSummary();

       System.out.println("1)Confirm");
       System.out.println("2) Cancel");
       int choose= input.nextInt();
       input.nextLine();
       if (choose==1){
           ReceiptWriter.saveReceipt(order);


       } else if (choose==2) {
           System.out.println("Order cancelled.");
           Utility.clearScreen();
           Utility.loadingMessage("Returning to home screen...");

       }
       else {
           System.out.println("Invalid choice");
       }


   }

}
