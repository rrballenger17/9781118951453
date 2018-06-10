package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


class ShowAnyData {
    public static void main(String args[]) {
     if (args.length==0){
       System.out.println(
        "Usage: java ShowAnyData SQLSelectStatement");
       System.out.println(
        "For example: java ShowAnyData \"Select * from Employee\"");
       System.exit(1);
     }
     
     // driver manager - get connection
     // connection create a statement
     // statement execute a query 
     try (Connection conn = DriverManager.getConnection(
                            "jdbc:derby://localhost:1527/Lesson21");
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(args[0]);) {
    	 
    	 // result set get meta data
    	 // result set get column name
    	 ResultSetMetaData rsMeta = rs.getMetaData();
    	 int colCount = rsMeta.getColumnCount();
    	 for (int i = 1; i <= colCount; i++)  {
    		 System.out.print(rsMeta.getColumnName(i) + " ");
    	 }
      
    	 // result set print result values
    	 System.out.println();
    	 while (rs.next()){
    		 for (int i = 1; i <= colCount; i++)  {
    			 System.out.print(rs.getString(i) + " ");
    		 }
    		 System.out.print("\n");   // new line character
    	 }
    	 
     } catch( SQLException se ) {
        System.out.println ("SQLError: " + se.getMessage ()
             + " code: " + se.getErrorCode ());
        
     } catch( Exception e ) {
        e.printStackTrace();

     } 
    }
    
}