/**
 * Represents a drink ordered with a sandwich.
 * It has a size (small, medium, large) and calculates its price based on the size.
 */
package com.pluralsight.models;

public class Drink {

    private final String size;

    public Drink(String size) {
        this.size = size;


    }

    /**
     * Calculate and returns the price of the drink based on its size
     *
     * @return the price of the drink
     */
    public double getPrice() {
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
                "size=" + size + '\'' +
                        " price=" + getPrice();
    }
}
