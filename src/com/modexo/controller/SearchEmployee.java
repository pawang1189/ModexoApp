package com.modexo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.modexo.db.*;
import com.modexo.model.EmployeeDetailsBean;;


public class SearchEmployee {

	public static EmployeeDetailsBean searchEmployee(EmployeeDetailsBean bean) {
		Connection con = null;
		PreparedStatement psselect = null;
		ResultSet rs= null;
		try {
			con=ConnectionProvider.getConnection();  
			String query = "select * from modexo.employee where emp_name like ";
//			String name=bean.getName();
			query=query+"'%"+bean.getEmpname()+"%'";
			System.out.println(query);
			psselect = con.prepareStatement(query);
			
			
			rs = psselect.executeQuery();
			System.out.println("select query executed!");
			if (!rs.next()) {
				System.out.println("No Records Exists");
			}
			else {
				int empid = rs.getInt("emp_id"); //ID is the columnname in mysql
				bean.setEmpid(empid);
				String empname = rs.getString("emp_name");
				bean.setEmpname(empname);
				String empcontact = rs.getString("emp_contact");
				bean.setEmpcontact(empcontact);
				
				String empemail = rs.getString("emp_email");
				bean.setEmpemail(empemail);
				
				Date empdoj = rs.getDate("emp_doj");
				bean.setEmpdoj(empdoj.toString());
				
				double emprate= rs.getDouble("emp_rate");
				bean.setEmprate(emprate);
				
				String emprole= rs.getString("emp_role");
				bean.setEmprole(emprole);
				
				System.out.println(empcontact+empid+empemail+empname+emprate+emprole);
				
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (psselect!=null)
				try {
					psselect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



		}
		return bean;


	}

}