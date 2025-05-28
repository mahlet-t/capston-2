package com.pluralsight.models;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich>sandwiches;
    private final List<Drink>drinks;
    private final List<Chips>chipsList;
    private String sides;

    public Order() {
        this.sandwiches=new ArrayList<>();
        this.drinks=new ArrayList<>();
        this.chipsList=new ArrayList<>();
    }



    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);


    }
    public void addDrink(Drink drink) {
        drinks.add(drink);


    }
    public void addChips(Chips chips){
        chipsList.add(chips);

    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public double getTotalPrice() {
        double total=0.00;
        for (Sandwich sandwich:sandwiches){
            total+=sandwich.getPrice();
        }
        for (Drink drink:drinks){
            total+=drink.getPrice();
        }
        for (Chips chips:chipsList){
            total+=chips.getPrice();
        }
        return total ;
    }


    public String getOrderSummary () {
            StringBuilder summary = new StringBuilder();
            summary.append("Order Summary:\n");

            for (Sandwich sandwich : sandwiches) {
                summary.append(sandwich.getSummary()).append("\n");
                summary.append("........................................\n");
            }

            for (Drink drink : drinks) {
                summary.append("Drink: ").append(drink.toString()).append("\n");
                summary.append("..........................................\n");
            }

            for (Chips chips : chipsList) {
                summary.append("Chips: $").append(chips.getPrice()).append("\n");
                summary.append("...........................................\n");
            }

            if (sides != null && !sides.equalsIgnoreCase("none")) {
                summary.append("Sides: ").append(sides).append("\n");
                summary.append(".............................................\n");
            }

            summary.append("Total: $").append(getTotalPrice());

            return summary.toString();
        }

}
