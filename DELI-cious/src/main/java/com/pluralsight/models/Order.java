/**
 * Order class represents a full order containing sandwiches, drinks, chips, and sides.
 * It handles adding items to the order, calculating the total price, and generating a summary.
  */
package com.pluralsight.models;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich>sandwiches;
    private final List<Drink>drinks;
    private final List<Chips>chipsList;
    private String sides;

    /** Constructor:
     * Initializes the lists to hold sandwiches, drinks, and chips
     *
     */
    public Order() {
        this.sandwiches=new ArrayList<>();
        this.drinks=new ArrayList<>();
        this.chipsList=new ArrayList<>();
    }


// Add a sandwich to the order
    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);


    }
    // Add a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);


    }
    // add chips to the order
    public void addChips(Chips chips){
        chipsList.add(chips);

    }
// sets the sides for the order
    public void setSides(String sides) {
        this.sides = sides;
    }
/**
 * Calculates and returns the total price of the order.
 * @return The total price of sandwiches, drinks, and chips.
 */
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

/**
 * Generates and returns a detailed summary of the entire order,
 * including sandwiches, drinks, chips, sides, and the total price.
 * @return Order summary as a formatted string.
 */
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
