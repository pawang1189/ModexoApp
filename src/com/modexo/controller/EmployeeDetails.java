package com.modexo.controller;

import java.sql.*;

import com.modexo.db.ConnectionProvider;
import com.modexo.model.EmployeeDetailsBean;
 

public class EmployeeDetails {


	public static EmployeeDetailsBean getEmpDetails(int employeeid){  
		
		EmployeeDetailsBean ebean= new EmployeeDetailsBean();
		
		try{  
			Connection con=ConnectionProvider.getConnection();  

			PreparedStatement ps=con.prepareStatement(  
					"select * from modexo.employee where emp_id=? ");  
			
			ps.setInt(1,employeeid);
		
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				String empname = rs.getString("emp_name");
				ebean.setEmpname(empname);
				System.out.println(empname);
				
				
				int empid = rs.getInt("emp_id");
				ebean.setEmpid(empid);
				
				String empemail = rs.getString("emp_email");
				ebean.setEmpemail(empemail);
				
				String empcontact = rs.getString("emp_contact");
				ebean.setEmpcontact(empcontact);
				
				Date empdoj = rs.getDate("emp_doj");
				ebean.setEmpdoj(empdoj);
				
				double emprate = rs.getDouble("emp_rate");
				ebean.setEmprate(emprate);
				
				String emprole=rs.getString("emp_role");
				ebean.setEmprole(emprole);
			}

		}catch(Exception e){
			e.printStackTrace();
		}  

		return ebean;  

	}  
}  
