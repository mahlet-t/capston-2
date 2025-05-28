package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order){
       DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
       LocalDateTime now=LocalDateTime.now();
       String filename="src/main/resources/receipts/"+now.format(formatter)+".txt";
       try {
           BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
           writer.write(order.getOrderSummary());
           System.out.println("Receipt created");
           writer.close();
       }catch (Exception e){
           System.err.println("Error"+e.getMessage());

       }

    }
}
