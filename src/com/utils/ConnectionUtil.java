package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {
	
	// Holds the single instance
		private static ConnectionUtil util; 
		private static Connection conn;
		
		public static ConnectionUtil getUtil() throws ClassNotFoundException{
			if (util == null){
				util = new ConnectionUtil(); 
			} 
			return util; 
		}
		 

		public static Connection getConnection()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopcart", "root", "root");
	            
	             //System.out.println("Connection done successfully");
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	            e.printStackTrace();
	        }
	 
	        return conn;
	    }

}
