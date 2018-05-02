package com.modexo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.modexo.db.ConnectionProvider;

public class EmpolyeeWorkDeails {
	
public static double getEmpWorkDetails(int employeeid , int numDays){  
		
		double workTime = 0.0;
		
		try{  
			Connection con=ConnectionProvider.getConnection();  

			PreparedStatement ps=con.prepareStatement(  
					"SELECT timediff(emp_clockout,emp_clockin) AS clocked_time from emp_clockhistory where emp_id=? and emp_clockdate >=  CURRENT_DATE - INTERVAL "+numDays+" DAY");  
			
			ps.setInt(1,employeeid);
		
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
			
				
				
				double timeDiff = rs.getInt("clocked_time");
				
				workTime +=timeDiff;
			}

		}catch(Exception e){
			e.printStackTrace();
		}  

		return workTime;  

	}  


public static double getTotalWorkHours(int employeeid , java.util.Date joiningDate){  
	
	double workTime = 0.0;
	
	try{  
		Connection con=ConnectionProvider.getConnection();  

		PreparedStatement ps=con.prepareStatement(  
				"SELECT timediff(emp_clockout,emp_clockin) AS clocked_time from emp_clockhistory where emp_id=? and emp_clockdate >= "+joiningDate);  
		
		ps.setInt(1,employeeid);
	
		ResultSet rs=ps.executeQuery();  
		while (rs.next()) {
		
			
			
			double timeDiff = rs.getInt("clocked_time");
			
			workTime +=timeDiff;
		}

	}catch(Exception e){
		e.printStackTrace();
	}  

	return workTime;  

}  

}
