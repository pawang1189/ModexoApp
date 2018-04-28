package com.modexo.controller;

import java.sql.*;

import com.modexo.db.ConnectionProvider;

import com.modexo.model.UserBean; 

public class LoginOut {  

	public static boolean validate(UserBean bean){  
		boolean status=false;  
		try{  
			Connection con=ConnectionProvider.getConnection();  

			PreparedStatement ps=con.prepareStatement(  
					"select * from modexo.employee where emp_id=? and emp_password=? and emp_role=?");  
			
			ps.setString(1,bean.getEmpid());
			String emp_id=bean.getEmpid();
			System.out.println(emp_id);

			ps.setString(2, bean.getEmppassword());  
			String emp_password=bean.getEmppassword();
			System.out.println(emp_password);
			
			ps.setString(3, bean.getRole());  
			String emp_role=bean.getRole();
			System.out.println(emp_role);
			
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  

		}catch(Exception e){
			e.printStackTrace();
		}  

		return status;  

	}  
}  
