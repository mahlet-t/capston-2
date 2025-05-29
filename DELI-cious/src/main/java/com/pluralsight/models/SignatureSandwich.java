package com.pluralsight.models;

public class SignatureSandwich extends Sandwich{

    public SignatureSandwich(String bread, int size, boolean toasted) {
        super(bread,size , toasted);
        init();


    }
    public static SignatureSandwich createBLT (){
        SignatureSandwich blt=new SignatureSandwich("white bread",8,true);
        blt.addMeat(new Topping("Bacon","Meat",false,8));
        blt.addCheese(new Topping("Cheddar","Cheese",false,8));
        blt.addTopping(new Topping("Lettuce","Regular Topping",false,8));
        blt.addTopping(new Topping("tomato","Regular Topping",false,8));
        blt.addSauce(new Topping("Ranch","sauces",false,8));

        return blt;
    }
    public static SignatureSandwich createPhillyCheeseSteak(){
        SignatureSandwich philly=new SignatureSandwich("white bread",8,true);
        philly.addMeat(new Topping("Steak","meat",false,8));
        philly.addCheese(new Topping("American Cheese","Cheese",false,8));
        philly.addTopping(new Topping("Peppers","Regular",false,8));
        philly.addSauce(new Topping("Mayo","Sauces",false,8));
        return philly;
    }
}
