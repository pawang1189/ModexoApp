package com.modexo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.modexo.db.*;
import com.modexo.model.EmployeeDetailsBean;

public class DeleteEmployee {
	public static int deleteEmployee(EmployeeDetailsBean bean){
		int status=0;
		Connection con = null;
		PreparedStatement ps = null;
		
	
		try{

			con=ConnectionProvider.getConnection();
			
			ps=con.prepareStatement("delete from employee where emp_id=?");
			ps.setInt(1,bean.getEmpid());
			int empid = bean.getEmpid();
			System.out.println(empid);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
