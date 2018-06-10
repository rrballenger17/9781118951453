package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class EmployeeList {
    public static void main(String argv[]) {
     
    	String sqlQuery = "SELECT * from Employee";

		// Create an object for collection of employees
	     ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

    	// driver manager get connection
	     // create a statement
	     // execute the statement - returns a result set
    	try (Connection conn = DriverManager.getConnection(
                         "jdbc:derby://localhost:1527/Lesson21");
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sqlQuery); ) {


    		// Process each column in the result set and print the data
    		while (rs.next()){
    			int empNo = rs.getInt("EMPNO");
    			String eName = rs.getString("ENAME");
    			String job = rs.getString("JOB_TITLE");
    			System.out.println(""+ empNo + ", " + eName + ", " + job );
    		
    		     // Process ResultSet and populate the collection
    		      EmployeeDTO currentEmp = new EmployeeDTO();
    		      currentEmp.setEmpNo(rs.getInt("EMPNO"));
    		      currentEmp.setEName(rs.getString("ENAME"));
    		      currentEmp.setJobTitle(rs.getString("JOB_TITLE"));
    		      employees.add(currentEmp);
    		
    		}
    	} catch( SQLException se ) {
    		System.out.println ("SQLError: " + se.getMessage ()
             + " code: " + se.getErrorCode ());
    	} catch( Exception e ) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
        
    	} 
    }
}




