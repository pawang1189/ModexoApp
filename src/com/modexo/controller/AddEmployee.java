package com.modexo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.modexo.db.*;
import com.modexo.model.EmployeeDetailsBean;


public class AddEmployee {

	public static void InsertEmployees(EmployeeDetailsBean bean) {
		Connection con = null;
		PreparedStatement psinsert = null;

		try {
			con=ConnectionProvider.getConnection();  
			String query = "insert into employee (emp_name,emp_email,emp_contact,emp_doj,emp_password,emp_rate,emp_role) values (?,?,?,?,?,?,?)";
			psinsert=con.prepareStatement(query);
			
			
			psinsert.setString(1, bean.getEmpname());
			
			psinsert.setString(2, bean.getEmpemail());
			
			psinsert.setString(3, bean.getEmpcontact());
//			java.util.Date empdoj=bean.getEmpdoj();
			/*System.out.println(empdoj);*/
			
			
//			psinsert.setTimestamp(4,bean.getEmpdoj().getTime());
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String date=simpleDateFormat.format(bean.getEmpdoj());
//			Date startdate=new Date(date);  
//			System.out.println(date);
//			System.out.println(startdate);
//			
			//System.out.println("333333333333333333333333333333 "+ bean.getEmpdoj());
			psinsert.setDate(4, new Date(bean.getEmpdoj().getTime()));
		//	psinsert.setDate(4, (Date) bean.getEmpdoj());
			psinsert.setString(5,bean.getEmppassword());
			
			psinsert.setDouble(6,bean.getEmprate());
			
			psinsert.setString(7,bean.getEmprole());
			
			int val =psinsert.executeUpdate();
			System.out.println("Records have been inserted into customer table with row count of "+val);

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
			if (psinsert!=null)
				try {
					psinsert.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



		}


	}

}
