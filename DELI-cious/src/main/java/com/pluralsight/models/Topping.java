package com.pluralsight.models;

public class Topping {
    private String type;
    private boolean isExtra;
    private int size;

    public Topping( String type, boolean isExtra, int size) {
        this.type = type;
        this.isExtra = isExtra;
        this.size = size;
    }
    public double getPrice() {
        double price = 0;
        if (type.equalsIgnoreCase("Meat")) {
            if (size == 4) {
                price += 1.00;
            } else if (size == 8) {
                price += 2.00;
            } else if (size == 12) {
                price += 3;
            }
            if (isExtra && size == 4) {
                price += 0.50;
            } else if (isExtra && size == 8) {
                price += 1.00;
            } else if (isExtra && size == 12) {
                price += 1.50;
            }

        } else if (type.equalsIgnoreCase("Cheeses")) {

            if (size == 4) {
                price += 0.75;
            } else if (size == 8) {
                price += 1.50;
            } else if (size == 12) {
                price += 2.25;
            }
            if (isExtra && size == 4) {
                price += 0.30;
            } else if (isExtra && size == 8) {
                price += 0.60;
            } else if (isExtra && size == 12) {
                price += 0.90;
            }
        }
        return price;


    }
}
