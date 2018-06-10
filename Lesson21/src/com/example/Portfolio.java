package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Portfolio implements Runnable {
    public void run() {
    
       // Homework guidelines:
       //select all the data from the table Portfolio, and 
       // print the symbol, quantity, and total value. 
       // Calculate the total value by multiplying price by quantity.
       
       String query = "Select * from Portfolio";
       
       try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson21");
    		   Statement stmt = conn.createStatement();
    		   ResultSet rs = stmt.executeQuery(query);
    		   ) {
    	   
    	   int quantityColumn = -1;
    	   int priceColumn = -1;

    	   // Find out the number of columns, their names
    	   // and display the data
    	   ResultSetMetaData rsMeta = rs.getMetaData();
    	   int colCount = rsMeta.getColumnCount();

    	   for (int i = 1; i <= colCount; i++)  {
    		   
    		   String colName = rsMeta.getColumnName(i);
			   
    		   // cols abbreviated to 3 characters
    		   if(colName.length() > 4) {
				   colName = colName.substring(0, 3);
			   }
			   
    		   // save quantity and price locations
			   if(colName.equals("QUA")) {
				   quantityColumn = i;
			   }else if(colName.equals("PRI")) {
				   priceColumn = i;
			   }
			   
    		   System.out.print(colName + "\t");
    	   }
    	   // extra column for total value
    	   System.out.println("VAL");

    	   
    	   while (rs.next()){
    		   int quantity = -1;
    		   double price = -1;
    		   for (int i = 1; i <= colCount; i++)  {
    			   
    			   System.out.print( rs.getString(i) + "\t");
    		
    			   // save quantity and price for total value calculation
    			   if(i == quantityColumn) {
    				   quantity = Integer.parseInt(rs.getString(i));
    			   }else if(i == priceColumn) {
    				   price = Double.parseDouble(rs.getString(i));
    			   }
    			   
    		   }
    		   // print the total value
    		   System.out.println(quantity * price);
    	   }
    	   
       } catch( SQLException se ) {
    	   System.out.println ("SQLError: " + se.getMessage ()
    	   	+ " code: " + se.getErrorCode ());
       } catch( Exception e ) {
    	   e.printStackTrace();
       }
    
    }
}



