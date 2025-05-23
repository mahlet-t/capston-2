package com.pluralsight.ui;

import com.pluralsight.util.Utility;

import java.util.Scanner;

public class UserInterface {

public Scanner input=new Scanner(System.in);

    public UserInterface(Scanner input) {
        this.input = input;
    }

    public void displayHomeScreen(){
        Utility.printTitle("Welcome ");
        System.out.println("What you want to do");
        System.out.println("1) new order");
        System.out.println("0) Exit");
        int choose=input.nextInt();
        input.nextLine();
        switch (choose){
            case 1->displayOrderScreen();
            case 0-> {
                Utility.loadingMessage("Exiting....");
            System.out.println("Good bye ");
            Utility.clearScreen();
            }
        }


    }
    public void displayOrderScreen(){
        System.out.println("choose from the following");
        System.out.println("1) Add sandwich");
        System.out.println("2) Add Drink");


    }
}
