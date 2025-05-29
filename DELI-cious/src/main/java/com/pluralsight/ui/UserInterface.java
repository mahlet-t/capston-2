package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import com.pluralsight.util.Utility;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class UserInterface {

    public Scanner input = new Scanner(System.in);

    public void displayHomeScreen() {
        Utility.printTitle("Welcome ");
        System.out.println("What you want to do");
        System.out.println("🧺" + "1) new order");
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
        Order order = new Order();
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("choose from the following");
            System.out.println("1) Add sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order and Exit");
            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1 -> addSandwich(order);

                case 2 -> {
                    String drinkSize = promptForDrinks();
                    Drink drink = new Drink(drinkSize);
                    order.addDrink(drink);
                }
                case 3 -> {
                    Chips chips = new Chips();
                    order.addChips(chips);
                }
                case 4 -> checkout(order);
                case 0 -> {
                    Utility.loadingMessage("Exiting...");
                    keepGoing = false;
                }
                default -> System.out.println("Invalid choice. please try again ");
            }
        }
        displayHomeScreen();
    }

    public void addSandwich(Order order) {
        while (true) {
            System.out.println("1)build your own sandwich");
            System.out.println("2)Signature sandwich ");
            System.out.println("3) go back to order menu");
            int choose = input.nextInt();
            input.nextLine();


            if (choose == 1) {

                String sides = promptForSides();
                Sandwich sandwich = buildSandwich();
                order.addSandwich(sandwich);
                order.setSides(sides);
            } else if (choose == 2) {
                while (true) {
                    System.out.println("""
                            1) Philly Cheese Steak
                            o  8" white bread
                            "o Steak
                            "o American Cheese
                            "o Peppers
                            "o Mayo
                            "o Toasted""");
                    System.out.println("""
                            2) BLT"
                            "o 8" white bread
                            "o Bacon
                            "o Cheddar
                            "o Lettuce
                            "o Tomato
                            "o Ranch
                            "o Toasted""");
                    System.out.println("3) done");

                    int signatureChoice;
                    try {
                        signatureChoice = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. please Enter a number");
                        input.nextLine();// clear bad input
                        continue;// back to start of loop
                    }
                    input.nextLine();//clear \n

                    SignatureSandwich signatureSandwich = null;

                    if (signatureChoice == 1) {
                        signatureSandwich = SignatureSandwich.createPhillyCheeseSteak();
                    } else if (signatureChoice == 2) {
                        signatureSandwich = SignatureSandwich.createBLT();
                    } else if (signatureChoice == 3) {
                        break;

                    } else {
                        System.err.println("Invalid choice");
                    }
                    customizeSignatureSandwich(signatureSandwich);
                    order.addSandwich(signatureSandwich);
                    order.setSides(promptForSides());

                }

            } else if (choose == 3) {
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private void customizeSignatureSandwich(SignatureSandwich sandwich) {
        while (true) {
            System.out.println("1) add topping");
            System.out.println("2) remove topping ");
            System.out.println("3) done");
            int choice;
            try{choice=input.nextInt();}
            catch(InputMismatchException e) {
                System.out.println("Invalid input. please enter number only");
                input.nextLine();
                continue;
            }
            input.nextLine();
            if (choice == 1) {
                while (true) {
                System.out.println("What type of topping would you like to add?");
                System.out.println("1) Meat");
                System.out.println("2) Cheese");
                System.out.println("3) Regular Topping");
                System.out.println("4) Sauce");
                System.out.println("5) Done");

                    int addChoice=input.nextInt();
                    input.nextLine();
                    if (addChoice==1){
                        List<Topping> extraMeat = promptForMeats(8);
                        for (Topping meat : extraMeat) {
                            sandwich.addMeat(meat);
                        }

                    } else if (addChoice==2) {
                        List<Topping> extraCheese = promptForCheese(8);

                        for (Topping cheese : extraCheese) {
                            sandwich.addCheese(cheese);
                        }
                    } else if (addChoice==3) {
                        List<Topping> extraRegularTopping = promptForRegularToppings(8);
                        for (Topping regular : extraRegularTopping) {
                            sandwich.addTopping(regular);
                        }
                    } else if (addChoice==4) {
                        List<Topping> extraSauce = promptForSauces(8);

                        for (Topping sauce : extraSauce) {
                            sandwich.addSauce(sauce);
                        }
                    } else if (addChoice==5) {
                        break;

                    }else {
                        System.out.println("Invalid choice");
                    }


                }
            } else if (choice == 2) {
                while (true) {
                    System.out.println("Current Meats: " + sandwich.getMeats());
                    System.out.println("Current Cheeses: " + sandwich.getCheeses());
                    System.out.println("Current Regular Toppings: " + sandwich.getRegularToppings());
                    System.out.println("Current Sauces: " + sandwich.getSauces());
                    System.out.println("Type the topping name to remove, or 'done' to finish:");
                    String toppingToRemove = input.nextLine();
                    if (toppingToRemove.equalsIgnoreCase("done")) {
                        break;
                    }
                    boolean removed = false;
                    for (Topping meat : sandwich.getMeats()) {
                        if (meat.getName().equalsIgnoreCase(toppingToRemove)) {
                            sandwich.removeMeat(meat);
                            removed = true;
                            break;
                        }
                    }
                    for (Topping cheese : sandwich.getCheeses()) {
                        if (cheese.getName().equalsIgnoreCase(toppingToRemove)) {
                            sandwich.removeCheese(cheese);
                            removed = true;
                            break;
                        }
                    }
                    for (Topping topping : sandwich.getRegularToppings()) {
                        if (topping.getName().equalsIgnoreCase(toppingToRemove)) {
                            sandwich.removeTopping(topping);
                            removed = true;
                            break;
                        }
                    }
                    for (Topping sauce : sandwich.getSauces()) {
                        if (sauce.getName().equalsIgnoreCase(toppingToRemove)) {
                            sandwich.removeSauce(sauce);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("Removed: " + toppingToRemove);


                    } else {
                        System.out.println("Topping not found:" + toppingToRemove);
                    }

                }

            } else if (choice == 3) {
                break;

            } else {
                System.err.println("Invalid choice");

            }
        }
    }

    public String promptForBreadType() {
        List<String> validBread = List.of("white bread", "wheat bread", "rye bread", "wrap", "done");
        while (true) {
            System.out.println("what type of bread do you want");
            System.out.println("White Bread");
            System.out.println("Wheat Bread");
            System.out.println("Rye Bread");
            System.out.println("Wrap ");
            String userInput = input.nextLine().toLowerCase();
            if (validBread.contains(userInput)) {
                return userInput;
            } else {
                System.out.println("Invalid choice. please try again ");
            }
        }

    }

    public int promptForSize() {
        while (true) {
            System.out.println("what size do you want 4,8 or 12 inches");
            int size = input.nextInt();
            input.nextLine();
            if (size == 4 || size == 8 || size == 12) {
                return size;
            } else {
                System.out.println("Invalid choice. please try again");
            }
        }
    }

    public String promptForToasted() {
        while (true) {
            System.out.println(" would you like it toasted(yes or no )");
            String toasted = input.nextLine();
            if (toasted.equalsIgnoreCase("Yes") || toasted.equalsIgnoreCase("No")) {
                return toasted;
            } else {
                System.out.println("Invalid choice. please try again");
            }
        }
    }

    public List<Topping> promptForMeats(int size) {
        List<Topping> meats = new ArrayList<>();
        List<String> validMeats = List.of("steak", "ham", "salami", "roast beef", "Chicken", "Bacon", "done");
        while (true) {
            System.out.println("What type of meat do you want ");
            System.out.println("Choose from the list of meat");
            System.out.println(" or type done to finish");
            System.out.println(".Steak\n.Ham\n.Salami\n.Roast Beef\n.Chicken\n.Bacon");
            String listOfMeat = input.nextLine();
            if (!validMeats.contains(listOfMeat.toLowerCase())) {
                System.err.println("Invalid meat type ");
                continue;
            }
            if (listOfMeat.equalsIgnoreCase("done")) {
                Utility.loadingMessage("Exiting...");
                break;
            }
            System.out.println("you want Extra Meat");
            String extras = input.nextLine();
            boolean isExtra = false;
            if (extras.equalsIgnoreCase("yes")) {
                isExtra = true;

            } else if (!extras.equalsIgnoreCase("No")) {
                System.err.println("Invalid input ");
            }

            Topping topping = new Topping(listOfMeat, "Meat", isExtra, size);
            meats.add(topping);


        }
        return meats;
    }

    public List<Topping> promptForCheese(int size) {
        List<Topping> cheese = new ArrayList<>();
        List<String> validCheese = List.of("american", "provolone", "cheddar", "swiss", "done");
        while (true) {
            boolean isExtra = false;
            System.out.println("What type of cheese do you want ");
            System.out.println("American\nProvolone\nCheddar\nSwiss");
            System.out.println("or type done to finish");
            String listOfCheese = input.nextLine();
            if (!validCheese.contains(listOfCheese.toLowerCase())) {
                System.err.println("Invalid Cheese type");
                continue;
            }
            if (listOfCheese.equalsIgnoreCase("done"))
                break;
            System.out.println("would you like Extra Cheese(yes or no)");
            String extra = input.nextLine();
            if (extra.equalsIgnoreCase("Yes")) {
                isExtra = true;
            } else if (!extra.equalsIgnoreCase("No")) {
                System.out.println("Invalid input");

            }
            Topping topping = new Topping("Cheese", listOfCheese, isExtra, size);
            cheese.add(topping);


        }
        return cheese;


    }

    public List<Topping> promptForRegularToppings(int size) {
        List<Topping> regular = new ArrayList<>();
        List<String> validRegular = List.of("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "Guacamole", "Mushrooms", "done");
        while (true) {

            System.out.println("Add Toppings");
            System.out.println("or type done to finish ");
            System.out.println("Lettuce, Peppers");
            System.out.println("Onions, Tomatoes");
            System.out.println("Jalapenos,Cucumbers");
            System.out.println(" Pickles, Guacamole ");
            System.out.println("Mushrooms");
            String regularTopping = input.nextLine();
            if (!validRegular.contains(regularTopping.toLowerCase())) {
                System.err.println("Invalid choice.");
                continue;
            }
            if (regularTopping.equalsIgnoreCase("done")) {
                break;
            }
            Topping topping = new Topping(regularTopping, "Regular", false, size);
            regular.add(topping);

        }
        return regular;
    }

    public List<Topping> promptForSauces(int size) {
        List<Topping> sauces = new ArrayList<>();
        List<String> validSauce = List.of("mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette", "done");
        while (true) {
            System.out.println("Add Sauces");
            System.out.println("Type done to finish");
            System.out.println("Mayo, Mustard");
            System.out.println("Ketchup, Ranch");
            System.out.println("Thousand island, Vinaigrette");
            String sauce = input.nextLine();
            if (!validSauce.contains(sauce.toLowerCase())) {
                System.err.println("Invalid choice");
                continue;
            }
            if (sauce.equalsIgnoreCase("done")) {
                break;
            }
            Topping topping = new Topping(sauce, "Sauces", false, size);
            sauces.add(topping);
        }
        return sauces;
    }


    public String promptForDrinks() {
        while (true) {
            System.out.println("what size do you want\n Small, Medium, Large");
            String size = input.nextLine();
            if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
                return size;
            } else {
                System.err.println("Invalid Choice");
            }

        }
    }

    public String promptForSides() {
        while (true) {
            System.out.println("what sides do you want ");
            System.out.println("* Au jus\n * Sauce\n*None");
            String sides = input.nextLine();
            if (sides.equalsIgnoreCase("Au jus") || sides.equalsIgnoreCase("sauce") || sides.equalsIgnoreCase("None")) {
                return sides;
            } else {
                System.out.println("Invalid choice. ");
            }
        }
    }

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

    public void checkout(Order order) {

        System.out.println(order.getOrderSummary());

        System.out.println("1)Confirm");
        System.out.println("2) Cancel");
        int choose = input.nextInt();
        input.nextLine();
        if (choose == 1) {
            ReceiptWriter.saveReceipt(order);


        } else if (choose == 2) {
            System.out.println("Order cancelled.");
            Utility.clearScreen();
            Utility.loadingMessage("Returning to home screen...");

        } else {
            System.out.println("Invalid choice");
        }


    }

}
