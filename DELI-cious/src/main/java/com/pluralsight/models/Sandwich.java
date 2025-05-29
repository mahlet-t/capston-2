/**
 * Represents a sandwich in the system.
 * This class handles the building and customization of individual sandwiches, including bread, size,
 * toasted state, meats, cheeses, toppings, sauces, and price calculation.
 */
package com.pluralsight.models;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final String bread;
    private final int size;
    private final boolean toasted;
    private final List<Topping> meats;
    private final List<Topping> cheeses;
    private final List<Topping> regularToppings;
    private final List<Topping> sauces;
    private double price;


    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        init();

    }
// Sets the base price based on sandwich size
    public void init() {
        switch (size) {
            case 4 -> price += 5.50;
            case 8 -> price += 7.00;
            case 12 -> price += 8.50;
            default -> throw new RuntimeException("Error");
        }

    }
// Adds a meat topping and updates the price
    public void addMeat(Topping topping) {
        meats.add(topping);
        price += topping.getPrice();


    }
// Adds a cheese topping and updates the price
    public void addCheese(Topping topping) {
        cheeses.add(topping);
        price += topping.getPrice();

    }
// Adds a regular topping
    public void addTopping(Topping topping) {
        regularToppings.add(topping);

    }
    //Removes a meat topping and updates the price
    public void removeMeat(Topping topping){
        boolean removed =meats.remove(topping);
        if (removed){
        price-=topping.getPrice();
        }
    }
    //Remove a cheese topping and updates the price
    public void removeCheese(Topping topping){
        boolean removed=cheeses.remove(topping);
        if (removed){
            price-=topping.getPrice();
        }
    }
    // remove regular topping
    public void removeTopping(Topping topping){
        regularToppings.remove(topping);
    }

// Adds a sauce topping
    public void addSauce(Topping topping) {
        sauces.add(topping);


    }
    //Remove a sauce topping
    public void removeSauce(Topping topping){
        sauces.remove(topping);
    }

    public double getPrice() {
        return price;
    }

    public List<Topping> getMeats() {
        return meats;
    }

    public List<Topping> getCheeses() {
        return cheeses;
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    public List<Topping> getSauces() {
        return sauces;
    }
    //Builds a summary of the sandwich's details

    public String getSummary() {
            StringBuilder summary = new StringBuilder();
            summary.append("Bread: ").append(bread).append("\n");
            summary.append("Size: ").append(size).append("\n");
            summary.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

            summary.append("Meats:\n");
            for (Topping meat : meats) {
                summary.append("- ").append(meat.getName()).append(" (").append(meat.getPrice()).append(")\n");
            }

            summary.append("Cheeses:\n");
            for (Topping cheese : cheeses) {
                summary.append("- ").append(cheese.getName()).append(" (").append(cheese.getPrice()).append(")\n");
            }

            summary.append("Toppings:\n");
            for (Topping regular : regularToppings) {
                summary.append("- ").append(regular.getName()).append("\n");
            }

            summary.append("Sauces:\n");
            for (Topping sauce : sauces) {
                summary.append("- ").append(sauce.getName()).append("\n");
            }

            summary.append("Price: $").append(price).append("\n");

            return summary.toString();
        }

}
