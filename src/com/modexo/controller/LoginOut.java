package com.modexo.controller;

import java.sql.*;

import com.modexo.db.ConnectionProvider;

import com.modexo.model.UserBean; 

public class LoginOut {  

	public static boolean validate(String username, String password, String role){  
		boolean status=false;  
		try{  
			Connection con=ConnectionProvider.getConnection();  

			PreparedStatement ps=con.prepareStatement(  
					"select * from modexo.employee where emp_id=? and emp_password=? and emp_role=?");  
			
			ps.setString(1,username);
			String emp_id=username;
			System.out.println(emp_id);

			ps.setString(2, password);  
			String emp_password=password;
			System.out.println(emp_password);
			
			ps.setString(3, role);  
			String emp_role=role;
			System.out.println(emp_role);
			
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  

		}catch(Exception e){
			e.printStackTrace();
		}  

		return status;  

	}  
}  
