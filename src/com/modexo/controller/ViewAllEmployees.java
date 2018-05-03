package com.modexo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.modexo.db.ConnectionProvider;
import com.modexo.model.EmployeeDetailsBean;


public class ViewAllEmployees {

	public static List<EmployeeDetailsBean> getAllRecords(){
		Connection con = null;
		List<EmployeeDetailsBean> list=new ArrayList<EmployeeDetailsBean>();
		
		try{
			con=ConnectionProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmployeeDetailsBean bean=new EmployeeDetailsBean();
				bean.setEmpid(rs.getInt("emp_id"));
				bean.setEmpname(rs.getString("emp_name"));
				bean.setEmpcontact(rs.getString("emp_contact"));
				bean.setEmpemail(rs.getString("emp_email"));
				bean.setEmpdoj(rs.getDate("emp_doj").toString());
				bean.setEmprate(rs.getDouble("emp_rate"));
				bean.setEmprole(rs.getString("emp_role"));
				list.add(bean);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

}
