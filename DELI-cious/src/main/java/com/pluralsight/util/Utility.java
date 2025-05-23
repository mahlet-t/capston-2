package com.pluralsight.util;

public class Utility {
    public static void printTitle(String title) {
        System.out.println("\n=================================================================");
        System.out.println("                  " + title);
        System.out.println("==================================================================\n");
    }
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
    public static String capitalize(String s){
        StringBuilder resultString=new StringBuilder();
        String[]words=s.split( " ");
        for (String word:words){
            resultString.append(firstUpper(word)).append(" ");

        }
        return resultString.toString().trim();
    }
    public static String firstUpper(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }

public static void clearScreen(){
        for (int i=0;i<50;i++){
            System.out.println();
        }
}
}
