package com.pluralsight.models;

public class Drink {
    private final String size;
    public Drink(String size) {
        this.size = size;


    }
    public double getPrice(){
        if (size.equalsIgnoreCase("small"))
            return 2.00;
        else if (size.equalsIgnoreCase("medium"))
            return 2.50;
        else if (size.equalsIgnoreCase("Large"))
            return 3.00;


        return 0.00;
    }

    @Override
    public String toString() {
        return
                "size='" + size + '\'' +
                ", price=" + getPrice() ;
    }
}
