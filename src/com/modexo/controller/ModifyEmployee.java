package com.modexo.controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.modexo.db.*;
import com.modexo.model.EmployeeDetailsBean;



public class ModifyEmployee {

	public static int update(EmployeeDetailsBean bean){
		int status=0;

		Connection con = null;

		try{


			con=ConnectionProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("update modexo.employee set emp_name=?,emp_contact=?,emp_doj=?,emp_email=?,emp_rate=?,emp_role=? where emp_id=?");
			ps.setString(1,bean.getEmpname());
			ps.setString(2,bean.getEmpcontact());
			ps.setDate(3,(Date) bean.getEmpdoj());
			ps.setString(4,bean.getEmpemail());
			ps.setDouble(5,bean.getEmprate());
			ps.setString(6,bean.getEmprole());
			ps.setInt(7,bean.getEmpid());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}

	public static EmployeeDetailsBean getRecordById(String empid){
		EmployeeDetailsBean bean=new EmployeeDetailsBean();
		try{
			Connection con=ConnectionProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from modexo.employee where emp_id=?");
			ps.setString(1,empid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				bean.setEmpid(rs.getInt("emp_id"));
				bean.setEmpname(rs.getString("emp_name"));
				bean.setEmpcontact(rs.getString("emp_contact"));
				bean.setEmpdoj(rs.getDate("emp_doj"));
				bean.setEmpemail(rs.getString("emp_email"));
				bean.setEmprate(rs.getDouble("emp_rate"));
				bean.setEmprole(rs.getString("emp_role"));

			}
		}catch(Exception e){System.out.println(e);}
		return bean;
	}

}
