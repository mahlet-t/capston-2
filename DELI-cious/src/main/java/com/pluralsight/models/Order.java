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

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }


    public String getSides() {
        return sides;
    }


    public String getOrderSummaryMethod () {
        return "Sandwich"+sandwiches+"\nDrinks"+drinks+"\nChips"+chipsList+"\nSides"+sides+"\nTotalPrice"+getTotalPrice();
    }
}
