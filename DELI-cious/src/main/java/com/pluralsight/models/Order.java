package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich>sandwiches;
    private List<Drink>drinks;
    private List<Chips>chipsList;
    private double price;
    private String sides;

    public Order() {
        this.price = price;
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
}
