/**
 * Utility class responsible for saving order receipts.
 * It writes the order summary to a timestamped file in the receipt directory.
 */
package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    /**
     * Saves the provided order summary to a receipt file with a timestamped filename.
     * @param order the Order object containing the summary details to be saved
     */
    public static void saveReceipt(Order order){
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
       LocalDateTime now=LocalDateTime.now();
       String filename="src/main/resources/receipts/"+now.format(formatter)+".txt";
       try {
           BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
           writer.write(order.getOrderSummary());
           Utility.printSuccess("Receipt created");
           writer.close();
       }catch (Exception e){
           Utility.printError("Error"+e.getMessage());

       }

    }
}
