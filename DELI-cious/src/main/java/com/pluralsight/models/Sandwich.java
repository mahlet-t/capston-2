package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
private String bread;
private int size;
private boolean toasted;
private List<Topping>meats;
private List<Topping>cheeses;
private List<Topping>regularToppings;
private List<Topping>sauces;
private double price;

    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.meats=new ArrayList<>();
        this.cheeses=new ArrayList<>();
        this.regularToppings=new ArrayList<>();
        this.sauces=new ArrayList<>();
        init();

    }
    public void init(){
        switch (size){
            case 4 ->price+=5.50;
            case 8->price+=7.00;
            case 12->price+=8.50;
            default -> throw new RuntimeException("Error");
        }

    }
    public void addMeat(){



    }
    public void addCheese(){

    }
    public void addTopping(){

    }
    public void addSauce(){

    }



}
