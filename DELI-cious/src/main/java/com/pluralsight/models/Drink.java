package com.pluralsight.models;

public class Drink {
    private String size;
    private double price;

    public Drink(String size, double price) {
        this.size = size;
        this.price = price;
    }
    public double getPrice(){
        if (size.equalsIgnoreCase("small"))
            return 2.00;
        else if (size.equalsIgnoreCase("medium"))
            return 2.50;
        else if (size.equalsIgnoreCase("Large"))
            price=3.00;


        return price;
    }
}
