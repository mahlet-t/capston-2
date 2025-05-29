/**
 * Utility class providing general-purpose helper methods
 * such as printing titles, simulating loading messages,
 * clearing the console, and string manipulation.
 */
package com.pluralsight.util;

public class Utility {
    // ANSI escape codes for color
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";


    /**
     * Prints a formatted title surrounded by dashes for emphasis.
     *
     * @param title the title text to be displayed
     */
    public static void printTitle(String title) {
        System.out.println("\n=================================================================");
        System.out.println("               " + BLUE + title + RESET);
        System.out.println("==================================================================\n");
    }

    public static void printSuccess(String message) {
        System.out.println(GREEN + message + RESET);
    }
    public static void printOptions(String message){
        System.out.println(PURPLE +message+RESET);
    }

    public static void printError(String message) {
        System.out.println(RED + "Error: " + message + RESET);
    }

    /**
     * Simulates a loading message by printing the provided text
     *
     * @param message the loading message to display
     */
    public static void loadingMessage(String message) {
        System.out.println(YELLOW + message + RESET);
        try {
            {
                Thread.sleep(2000);//wait 2 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Loading was interrupted");
        }
    }

    /**
     * Capitalizes the first letter of the provided string.
     *
     * @param string the input string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String string) {
        StringBuilder resultString = new StringBuilder();
        String[] words = string.split(" ");
        for (String word : words) {
            resultString.append(firstUpper(word)).append(" ");

        }
        return resultString.toString().trim();
    }

    public static String firstUpper(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /**
     * Attempts to clear the console by printing multiple newlines.
     */
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
