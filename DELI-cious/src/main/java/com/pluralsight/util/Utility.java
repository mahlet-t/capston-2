/**
 * Utility class providing general-purpose helper methods
 * such as printing titles, simulating loading messages,
 * clearing the console, and string manipulation.
 */
package com.pluralsight.util;

public class Utility {
    /**
     * Prints a formatted title surrounded by dashes for emphasis.
     * @param title the title text to be displayed
     */
    public static void printTitle(String title) {
        System.out.println("\n=================================================================");
        System.out.println("                  " + title);
        System.out.println("==================================================================\n");
    }
    /**
     * Simulates a loading message by printing the provided text
     * @param message the loading message to display
     */
    public static void loadingMessage(String message) {
        System.out.println(message);
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
    public static String capitalize(String string){
        StringBuilder resultString=new StringBuilder();
        String[]words=string.split( " ");
        for (String word:words){
            resultString.append(firstUpper(word)).append(" ");

        }
        return resultString.toString().trim();
    }
    public static String firstUpper(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }
    /**
     * Attempts to clear the console by printing multiple newlines.
     */
public static void clearScreen(){
        for (int i=0;i<50;i++){
            System.out.println();
        }
}
}
