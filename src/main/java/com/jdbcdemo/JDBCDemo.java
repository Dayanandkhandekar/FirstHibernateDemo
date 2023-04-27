package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	 static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo?autoReconnect=true&useSSL=false";
	   static final String USER = "root";
	   static final String PASS = "root";
  public static void main(String[] args) {
	// Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
       //  System.out.println("Inserting records into the table...");          
        // String sql = "INSERT INTO student VALUES (1, 'Zara',  18)";
        //stmt.executeUpdate(sql);
          String sql = "INSERT INTO student VALUES (2, 'AA',  18)";
           stmt.executeUpdate(sql);
          sql = "INSERT INTO student VALUES (3, 'VV',  18)";
          int r = stmt.executeUpdate(sql);
      
        System.out.println("result==="+r);
         
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
	
}
}
