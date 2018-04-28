package com.modexo.db;

import java.sql.*;  
  
public class ConnectionProvider  implements Provider{  
	private static Connection con=null;  
	static{  
		try{  
			Class.forName(driver).newInstance();  
			con=DriverManager.getConnection(url,username,password);  
			System.out.println("Connected");
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}  
  
public static Connection getConnection(){  
    
	try {
		Class.forName(driver).newInstance();
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	try {
		con=DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
		return con;  
}  
  
}
